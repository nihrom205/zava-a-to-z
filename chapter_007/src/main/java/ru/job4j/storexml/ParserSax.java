package ru.job4j.storexml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Class Parser.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 16.07.2018
 */
public class ParserSax {

    private int value = 0;

    /**
     * Метод считает сумму значений и выводит в консоль результат.
     * @param f файл из которыго считываются данные.
     */
    public void count(File f) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(f, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(value);
    }

    private class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("entry")) {
                value += Integer.valueOf(attributes.getValue("href"));
            }
        }
    }
}
