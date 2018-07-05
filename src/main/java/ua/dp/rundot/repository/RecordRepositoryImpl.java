package ua.dp.rundot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.dp.rundot.model.Record;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class RecordRepositoryImpl implements RecordRepository {

    @Autowired
    private CrudRecordRepository crudRecordRepository;

    @Override
    public Record save(Record record) {
        return crudRecordRepository.save(record);
    }

    @Override
    public List<Record> findAll() {
        return crudRecordRepository.findAll();
    }

    @Override
    public List<Record> findByCallStartBetween(LocalDateTime starDateTime, LocalDateTime endDateTime) {
        return crudRecordRepository.findByCallStartBetween(starDateTime, endDateTime);
    }

    @Override
    public List<Record> findByCallStartBetweenAndParty1DeviceIn(LocalDateTime startDateTime, LocalDateTime endDateTime, List<String> party1DeviceList) {
        return  crudRecordRepository.findByCallStartBetweenAndParty1DeviceIn(startDateTime, endDateTime, party1DeviceList);
    }

    @Override
    public void saveAll(List<Record> records) {
        crudRecordRepository.saveAll(records);
    }
}
