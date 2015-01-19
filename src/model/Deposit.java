package model;

import exception.DepositBalanceException;
import exception.DepositDurationException;
import exception.DepositTypeException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * Created by Dotin school 6 on 1/18/2015.
 */
public class Deposit implements Comparable<Deposit> {
    private BigDecimal payedInterest;
    private BigDecimal depositBalance;
    private BigDecimal durationInDays;
    private String customerNumber;
    private DepositType depositType;

    public BigDecimal getPayedInterest() {
        return payedInterest;
    }

    public void setPayedInterest(BigDecimal payedInterest) {
        this.payedInterest = payedInterest;
    }

    public BigDecimal getDepositBalance() {
        return depositBalance;
    }

    public void setDepositBalance (BigDecimal depositBalance) throws DepositBalanceException {
        if (depositBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new DepositBalanceException("Exception In Balance.......!!!!");
        }

        this.depositBalance = depositBalance;
    }

    public BigDecimal getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(BigDecimal durationInDays) throws DepositDurationException{
        if (durationInDays.compareTo(BigDecimal.ZERO) < 0) {
            throw new DepositDurationException("Exception In Duration.......!!!!");
        }
        this.durationInDays = durationInDays;
    }


    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public DepositType getDepositType() {
        return depositType;
    }

    public void setDepositType(String typeOfDeposit) throws DepositTypeException {
        Object o;
        try {
            o = Class.forName("model." + typeOfDeposit).newInstance();
            Method method = o.getClass().getDeclaredMethod("setInterestRate");
            method.invoke(o);
            depositType = (DepositType) o;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }  catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new DepositTypeException("Exception In Type.......!!!!");
        }
    }

    public void calculatePayedInterest() {
        try {
            payedInterest = (depositType.getInterestRate()).multiply(depositBalance);
            payedInterest = payedInterest.multiply(durationInDays);
            payedInterest = payedInterest.divide(new BigDecimal("36500"), 2, 1);
            setPayedInterest(payedInterest);
        }catch (NullPointerException e){
            System.out.println("Inja ham....");
            setPayedInterest(new BigDecimal("-1"));
        }
    }


    /*@Override
    public String toString() {
        return getCustomerNumber() + " " + getDepositBalance() + " " + getDepositType().getInterestRate()
                + " " + getDurationInDays() + " " + getPayedInterest();
    }*/

    @Override
    public int compareTo(Deposit o) {
        int res;
        res = o.getPayedInterest().compareTo(getPayedInterest());
        return res;
    }
}
