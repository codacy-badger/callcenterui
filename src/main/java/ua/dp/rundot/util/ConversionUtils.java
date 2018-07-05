package ua.dp.rundot.util;

import ua.dp.rundot.model.CallDirection;
import ua.dp.rundot.model.Record;
import ua.dp.rundot.to.DailyStatistics;
import ua.dp.rundot.to.MonthlyStatistics;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class ConversionUtils {

    private ConversionUtils() {
    }

    public static DailyStatistics fromRecordListDaily(List<Record> records) {
        DailyStatistics result = new DailyStatistics();
        records.forEach(
                record -> {
                    result.getCallsPerHour()[record.getCallStart().getHour()]++;
                    if (record.getDirection() == CallDirection.I) {
                        result.setInboundCalls(result.getInboundCalls() + 1);
                        result.setInboundCallsDuration(result.getInboundCallsDuration().plusSeconds(record.getCallDuration().getSecond()));
                    } else {
                        result.setOutboundCalls(result.getOutboundCalls() + 1);
                        result.setOutboundCallsDuration(result.getOutboundCallsDuration().plusSeconds(record.getCallDuration().getSecond()));
                    }
                }
        );
        return result;
    }

    public static MonthlyStatistics fromRecordListMonthly(List<Record> records) {
        MonthlyStatistics result = new MonthlyStatistics();
        Map<LocalDate, List<Record>> recordsByDate = records
                .stream()
                .collect(Collectors.groupingBy(r -> r.getCallStart().toLocalDate()));
        recordsByDate.forEach((d, r) ->
                result.getDailyStatisticsMap().put(d, fromRecordListDaily(r))
        );
        return result;
    }
}
