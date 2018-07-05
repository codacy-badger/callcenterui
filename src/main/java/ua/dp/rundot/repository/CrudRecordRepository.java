package ua.dp.rundot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.dp.rundot.model.Record;

import java.time.LocalDateTime;
import java.util.List;

public interface CrudRecordRepository extends JpaRepository<Record, Integer> {

    List<Record> findByCallStartBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<Record> findByCallStartBetweenAndParty1DeviceIn(LocalDateTime startDateTime, LocalDateTime endDateTime, List<String> party1DeviceList);

}
