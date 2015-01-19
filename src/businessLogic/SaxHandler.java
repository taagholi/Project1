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
        if (qName.equals("deposit")) {
            deposits.add(deposit);

            //For all other end tags the deposit has to be updated.
        } else if (qName.equals("customerNumber")) {
            deposit.setCustomerNumber(new BigDecimal(content));

        } else if (qName.equals("depositType")) {
            try {
                deposit.setDepositType(content);
            } catch (DepositTypeException e) {

            }


        } else if (qName.equals("depositBalance")) {

                try {
                    deposit.setDepositBalance(new BigDecimal(content));
                } catch (DepositBalanceException e) {

                }


        } else if (qName.equals("durationInDays")) {

            try {
                deposit.setDurationInDays(new BigDecimal(content));
            } catch (DepositDurationException e) {

            }

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
