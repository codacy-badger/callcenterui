package ua.dp.rundot.to;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MonthlyStatistics {

    private Map<LocalDate, DailyStatistics> dailyStatisticsMap = new HashMap();

    public MonthlyStatistics() {
    }

    public Map<LocalDate, DailyStatistics> getDailyStatisticsMap() {
        return dailyStatisticsMap;
    }

    public void setDailyStatisticsMap(Map<LocalDate, DailyStatistics> dailyStatisticsMap) {
        this.dailyStatisticsMap = dailyStatisticsMap;
    }

    @Override
    public String toString() {
        return "MonthlyStatistics{" +
                "dailyStatisticsMap=" + dailyStatisticsMap +
                '}';
    }
}
