package com.ryvas.project_web_services.domain.model;

import com.ryvas.project_web_services.domain.exception.InvalidPaymentException;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@ToString
public class Payment {

    private Integer id;
    private Instant moment;

    public Payment(Integer id, Instant moment) {
        validate(moment);
        this.id = id;
        this.moment = moment;
    }
    private void validate(Instant moment) {
        if (moment == null) {
            throw new InvalidPaymentException("Data do pagamento é obrigatória");
        }
    }
}