package com.space.and.beyond.test.model.dto;

import com.space.and.beyond.test.utils.DataUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class Travel {

    private int totalAdults;
    private int totalChilden;
    private Date departingDate;
    private Date returningDate;
    private double destinationPrice;
    private CheckoutInfo checkoutInfo;

    public Travel() {
        this.departingDate = DataUtils.getFaker().date().future(150, TimeUnit.DAYS);
        this.returningDate = DataUtils.getFaker().date().future(30, TimeUnit.DAYS, this.departingDate);
        this.checkoutInfo = new CheckoutInfo();
    }

}
