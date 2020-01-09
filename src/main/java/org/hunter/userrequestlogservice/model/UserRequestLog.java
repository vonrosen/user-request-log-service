package org.hunter.userrequestlogservice.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequestLog implements Serializable {

    private UUID userId;
    private BigInteger maxPaymentAmountCents;

    public UserRequestLog() {}
    public UserRequestLog(@JsonProperty UUID userId, @JsonProperty BigInteger maxPaymentAmountCents) {
        this.userId = userId;
        this.maxPaymentAmountCents = maxPaymentAmountCents;
    }

    public UUID getUserId() {
        return userId;
    }

    public BigInteger getMaxPaymentAmountCents() {
        return maxPaymentAmountCents;
    }

}
