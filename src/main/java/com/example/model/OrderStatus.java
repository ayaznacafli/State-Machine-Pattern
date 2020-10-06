package com.example.model;

import com.example.service.actions.statuses.*;

import java.util.Arrays;
import java.util.List;

public enum  OrderStatus {
    NEW(new PendingStatus().getStatusName(), new CancelStatus().getStatusName()),
    PENDING(new AprovedStatus().getStatusName(), new FaildFindStatus().getStatusName()),
    APROVED(new FaildComeStatus().getStatusName(), new ForeignStatus().getStatusName()),
    FOREIGN(new SendedStatus().getStatusName()),
    SENDED(new LocalStatus().getStatusName()),
    LOCAL(new ComplitedStatus().getStatusName(), new CallStatus().getStatusName()),
    COMPLITED(),
    CALL(),
    FIELDFIND(),
    CANCEL(),
    FIELDCOME();


    private final List<String> statuses;

    OrderStatus(String... status){
        this.statuses = Arrays.asList(status);
    }

    public List<String>  getStatuses() {
        return statuses;
    }


}
