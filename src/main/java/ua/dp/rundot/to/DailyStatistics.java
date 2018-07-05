package ua.dp.rundot.to;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class DailyStatistics {

    private int[] callsPerHour = new int[24];
    private int inboundCalls;
    private int outboundCalls;
    private int missedCalls;
    private LocalDate localDate;
    private LocalTime inboundCallsDuration = LocalTime.of(0, 0, 0);
    private LocalTime outboundCallsDuration = LocalTime.of(0, 0, 0);

    public DailyStatistics() {
    }

    public int[] getCallsPerHour() {
        return callsPerHour;
    }

    public void setCallsPerHour(int[] callsPerHour) {
        this.callsPerHour = callsPerHour;
    }

    public int getInboundCalls() {
        return inboundCalls;
    }

    public void setInboundCalls(int inboundCalls) {
        this.inboundCalls = inboundCalls;
    }

    public int getOutboundCalls() {
        return outboundCalls;
    }

    public void setOutboundCalls(int outboundCalls) {
        this.outboundCalls = outboundCalls;
    }

    public int getMissedCalls() {
        return missedCalls;
    }

    public void setMissedCalls(int missedCalls) {
        this.missedCalls = missedCalls;
    }

    public LocalTime getInboundCallsDuration() {
        return inboundCallsDuration;
    }

    public void setInboundCallsDuration(LocalTime inboundCallsDuration) {
        this.inboundCallsDuration = inboundCallsDuration;
    }

    public LocalTime getOutboundCallsDuration() {
        return outboundCallsDuration;
    }

    public void setOutboundCallsDuration(LocalTime outboundCallsDuration) {
        this.outboundCallsDuration = outboundCallsDuration;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "DailyStatistics{" +
                "callsPerHour=" + Arrays.toString(callsPerHour) +
                ", inboundCalls=" + inboundCalls +
                ", outboundCalls=" + outboundCalls +
                ", missedCalls=" + missedCalls +
                ", localDate=" + localDate +
                ", inboundCallsDuration=" + inboundCallsDuration +
                ", outboundCallsDuration=" + outboundCallsDuration +
                '}';
    }
}
