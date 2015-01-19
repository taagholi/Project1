package businessLogic;


import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import model.Deposit;

/**
 * Created by Dotin school 6 on 1/18/2015.
 */

public class Parser {

    public ArrayList<Deposit> parse(String addressXmlFile) throws Exception {
        SAXParserFactory parserFactor = SAXParserFactory.newInstance();
        SAXParser saxParser = parserFactor.newSAXParser();
        SaxHandler saxHandler = new SaxHandler();
        saxParser.parse(ClassLoader.getSystemResourceAsStream(addressXmlFile),
                saxHandler);
        return  saxHandler.getDeposits();


    }
}



