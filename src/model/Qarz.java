package model;

import java.math.BigDecimal;

/**
 * Created by Dotin school 6 on 1/18/2015.
 */
public class Qarz extends DepositType {

    @Override
    public void setInterestRate() {
        this.interestRate= new BigDecimal("0");
    }

    @Override
    public BigDecimal getInterestRate() {
        return this.interestRate;
    }
}
