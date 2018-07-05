package ua.dp.rundot.repository;

import ua.dp.rundot.model.Record;

import java.time.LocalDateTime;
import java.util.List;

public interface RecordRepository {

    Record save(Record record);

    void saveAll(List<Record> records);

    List<Record> findAll();

    List<Record> findByCallStartBetween(LocalDateTime starDateTime, LocalDateTime endDateTime);

    List<Record> findByCallStartBetweenAndParty1DeviceIn(LocalDateTime startDateTime, LocalDateTime endDateTime, List<String> party1DeviceList);


}
