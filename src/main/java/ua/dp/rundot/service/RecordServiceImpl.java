package ua.dp.rundot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dp.rundot.model.Record;
import ua.dp.rundot.repository.RecordRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;
    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Override
    public Record save(Record record) {
        return recordRepository.save(record);
    }

    @Override
    public List<Record> findAll() {
        return recordRepository.findAll();
    }

    @Override
    public void bunchSave(List<Record> records, int batchSize) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            for (int i = 0; i < records.size(); i++) {
                if (i > 0 && i % batchSize == 0) {
                    transaction.commit();
                    transaction.begin();
                    entityManager.clear();
                }
                entityManager.persist(records.get(i));
            }
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Record> findByCallStartBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return recordRepository.findByCallStartBetween(startDateTime, endDateTime);
    }

    @Override
    public List<Record> findByCallStartBetweenAndParty1DeviceIn(LocalDateTime startDateTime, LocalDateTime endDateTime, List<String> party1DeviceList) {
        return recordRepository.findByCallStartBetweenAndParty1DeviceIn(startDateTime, endDateTime, party1DeviceList);
    }

    @Override
    public void saveAll(List<Record> records) {
        recordRepository.saveAll(records);
    }
}
