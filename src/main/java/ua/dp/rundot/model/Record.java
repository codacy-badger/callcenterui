package ua.dp.rundot.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "records", uniqueConstraints = {
//        @UniqueConstraint(columnNames = {"call_id", "party1_device", "call_duration"}, name = "call_id_party1_device_call_duration_idx")
})
public class Record extends AbstractBaseEntity {

    @Column(name = "call_start", nullable = false)
    private LocalDateTime callStart;
    @Column(name = "call_duration", nullable = false)
    private LocalTime callDuration;
    @Column(name = "ring_duration")
    private int ringDuration;
    @Column(name = "caller", length = 25)
    private String caller;
    @Enumerated(EnumType.STRING)
    private CallDirection direction;
    @Column(name = "called_number", length = 20)
    private String calledNumber;
    @Column(name = "dialed_number", length = 20)
    private String dialedNumber;
    @Column(name = "account")
    private int account;
    @Column(name = "is_internal")
    private boolean isInternal;
    @Column(name = "call_id")
    private int callId;
    @Column(name = "continuation")
    private boolean continuation;
    @Column(name = "party1_device", length = 5)
    private String party1Device;
    @Column(name = "party1_name", length = 15)
    private String party1Name;
    @Column(name = "party2_device", length = 5)
    private String party2Device;
    @Column(name = "party2_name", length = 15)
    private String party2Name;
    @Column(name = "hold_time")
    private int holdTime;
    @Column(name = "park_time")
    private int parkTime;

    public Record() {
    }

    public Record(LocalDateTime callStart, LocalTime callDuration, int ringDuration, String caller, CallDirection direction, String calledNumber, String dialedNumber, int account, boolean isInternal, int callId, boolean continuation, String party1Device, String party1Name, String party2Device, String party2Name, int holdTime, int parkTime) {
        this.callStart = callStart;
        this.callDuration = callDuration;
        this.ringDuration = ringDuration;
        this.caller = caller;
        this.direction = direction;
        this.calledNumber = calledNumber;
        this.dialedNumber = dialedNumber;
        this.account = account;
        this.isInternal = isInternal;
        this.callId = callId;
        this.continuation = continuation;
        this.party1Device = party1Device;
        this.party1Name = party1Name;
        this.party2Device = party2Device;
        this.party2Name = party2Name;
        this.holdTime = holdTime;
        this.parkTime = parkTime;
    }

    public LocalDateTime getCallStart() {
        return callStart;
    }

    public void setCallStart(LocalDateTime callStart) {
        this.callStart = callStart;
    }

    public LocalTime getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(LocalTime callDuration) {
        this.callDuration = callDuration;
    }

    public int getRingDuration() {
        return ringDuration;
    }

    public void setRingDuration(int ringDuration) {
        this.ringDuration = ringDuration;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public CallDirection getDirection() {
        return direction;
    }

    public void setDirection(CallDirection direction) {
        this.direction = direction;
    }

    public String getCalledNumber() {
        return calledNumber;
    }

    public void setCalledNumber(String calledNumber) {
        this.calledNumber = calledNumber;
    }

    public String getDialedNumber() {
        return dialedNumber;
    }

    public void setDialedNumber(String dialedNumber) {
        this.dialedNumber = dialedNumber;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public boolean isInternal() {
        return isInternal;
    }

    public void setInternal(boolean internal) {
        isInternal = internal;
    }

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
    }

    public boolean isContinuation() {
        return continuation;
    }

    public void setContinuation(boolean continuation) {
        this.continuation = continuation;
    }

    public String getParty1Device() {
        return party1Device;
    }

    public void setParty1Device(String party1Device) {
        this.party1Device = party1Device;
    }

    public String getParty1Name() {
        return party1Name;
    }

    public void setParty1Name(String party1Name) {
        this.party1Name = party1Name;
    }

    public String getParty2Device() {
        return party2Device;
    }

    public void setParty2Device(String party2Device) {
        this.party2Device = party2Device;
    }

    public String getParty2Name() {
        return party2Name;
    }

    public void setParty2Name(String party2Name) {
        this.party2Name = party2Name;
    }

    public int getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(int holdTime) {
        this.holdTime = holdTime;
    }

    public int getParkTime() {
        return parkTime;
    }

    public void setParkTime(int parkTime) {
        this.parkTime = parkTime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id =" + id +
                ", callStart=" + callStart +
                ", callDuration=" + callDuration +
                ", ringDuration=" + ringDuration +
                ", caller='" + caller + '\'' +
                ", direction=" + direction +
                ", calledNumber='" + calledNumber + '\'' +
                ", dialedNumber='" + dialedNumber + '\'' +
                ", account=" + account +
                ", isInternal=" + isInternal +
                ", callId=" + callId +
                ", continuation=" + continuation +
                ", party1Device='" + party1Device + '\'' +
                ", party1Name='" + party1Name + '\'' +
                ", party2Device='" + party2Device + '\'' +
                ", party2Name='" + party2Name + '\'' +
                ", holdTime=" + holdTime +
                ", parkTime=" + parkTime +
                '}';
    }
}
