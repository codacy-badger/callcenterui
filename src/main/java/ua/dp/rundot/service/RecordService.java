package ua.dp.rundot.service;

import ua.dp.rundot.model.Record;

import java.time.LocalDateTime;
import java.util.List;

public interface RecordService {

    Record save(Record record);

    List<Record> findAll();

    void saveAll(List<Record> records);

    void bunchSave(List<Record> records, int batchSize);

    List<Record> findByCallStartBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<Record> findByCallStartBetweenAndParty1DeviceIn(LocalDateTime startDateTime, LocalDateTime endDateTime, List<String> party1DeviceList);

}
