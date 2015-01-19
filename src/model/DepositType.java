package model;

import java.math.BigDecimal;

/**
 * Created by Dotin school 6 on 1/18/2015.
 */
public abstract class DepositType {

    protected BigDecimal interestRate;

    public abstract void setInterestRate();
    public abstract BigDecimal getInterestRate();

    }

