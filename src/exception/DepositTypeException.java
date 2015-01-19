package exception;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Dotin school 6 on 1/19/2015.
 */
public class DepositTypeException extends Exception {
    public DepositTypeException(){}

    public DepositTypeException(String s){
        System.out.println(s);
    }

}
