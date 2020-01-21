package org.hunter.userrequestlogservice.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequestLog implements Serializable {

    private UUID userId;
    private BigDecimal maxPaymentAmount;

    public UserRequestLog() {}
    public UserRequestLog(@JsonProperty UUID userId, @JsonProperty BigDecimal maxPaymentAmount) {
        this.userId = userId;
        this.maxPaymentAmount = maxPaymentAmount;
    }

    public UUID getUserId() {
        return userId;
    }

    public BigDecimal getMaxPaymentAmount() {
        return maxPaymentAmount;
    }

}
