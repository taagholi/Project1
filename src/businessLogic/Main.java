package businessLogic;

import model.Deposit;
import writer.WriteToFile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Dotin school 6 on 1/17/2015.
 */
public class Main {


    public static void main(String[] args) throws Exception {
        String addressXmlFile = "model/Deposits.xml";
        ArrayList<Deposit> deposits;
        Parser parser = new Parser();
        deposits = parser.parse(addressXmlFile);
        for (Deposit deposit : deposits) {
            deposit.calculatePayedInterest();
        }
        Collections.sort(deposits);
        for (Deposit deposit : deposits) {
            System.out.println(deposit);
        }
        WriteToFile writeToFile = new WriteToFile();
        writeToFile.writeDeposites(deposits);
        System.out.println("The Program Execute Successfully");


    }
}
