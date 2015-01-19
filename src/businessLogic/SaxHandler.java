package businessLogic;

import exception.DepositBalanceException;
import exception.DepositDurationException;

import exception.DepositTypeException;
import model.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.math.BigDecimal;
import java.util.ArrayList;


public class SaxHandler extends DefaultHandler {

    private ArrayList<Deposit> deposits = new ArrayList<Deposit>();
    private Deposit deposit = null;
    private String content = null;

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes){

        if (qName.equals("deposit")) {
            deposit = new Deposit();

        }
    }

    @Override
    public void endElement(String uri, String localName,
                           String qName) {
        try {
            if (qName.equals("deposit")) {
                deposits.add(deposit);

                //For all other end tags the deposit has to be updated.
            } else if (qName.equals("customerNumber")) {
                deposit.setCustomerNumber(new BigDecimal(content));

            } else if (qName.equals("depositType")) {

                deposit.setDepositType(content);


            } else if (qName.equals("depositBalance")) {


                deposit.setDepositBalance(new BigDecimal(content));


            } else if (qName.equals("durationInDays")) {


                deposit.setDurationInDays(new BigDecimal(content));


            }
        }catch (DepositTypeException e) {

        }
        catch (DepositBalanceException e) {

        }
        catch (DepositDurationException e) {

        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
    }

    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }
}
