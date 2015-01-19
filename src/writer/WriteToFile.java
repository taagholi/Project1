package writer;

import model.Deposit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Created by Dotin school 6 on 1/18/2015.
 */
public class WriteToFile {


    public void writeDeposites(ArrayList<Deposit> deposits) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("results.txt", "rw");
            for (Deposit deposit : deposits){
                randomAccessFile.writeBytes(deposit.getCustomerNumber()+"#"+deposit.getPayedInterest());
                String breakLine = "\n";
                randomAccessFile.writeBytes(breakLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
