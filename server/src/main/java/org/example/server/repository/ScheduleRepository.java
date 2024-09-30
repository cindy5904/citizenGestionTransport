package org.example.server.repository;

import org.example.server.entity.Schedule;
import org.example.server.enums.DaysOfWeeks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
    List<Schedule> findByDayOfWeekAndLineId(DaysOfWeeks dayOfWeek, Long lineId);
}
