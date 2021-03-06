package com.example.model;

import com.example.service.actions.statuses.*;

import java.util.Arrays;
import java.util.List;

public enum  OrderStatus {

    NEW(PendingStatus.NAME, CancelStatus.NAME),
    PENDING(AprovedStatus.NAME, FaildFindStatus.NAME),
    APROVED(FaildComeStatus.NAME, ForeignStatus.NAME),
    FOREIGN(SendedStatus.NAME),
    SENDED(LocalStatus.NAME),
    LOCAL(ComplitedStatus.NAME, CallStatus.NAME),
    COMPLITED(),
    CALL(),
    FIELDFIND(),
    CANCEL(ComplitedStatus.NAME),
    FIELDCOME();


    private final List<String> statuses;

    OrderStatus(String... status){
        this.statuses = Arrays.asList(status);
    }

    public List<String>  getStatuses() {
        return statuses;
    }


}
