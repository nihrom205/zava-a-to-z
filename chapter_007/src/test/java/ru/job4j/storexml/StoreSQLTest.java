package ru.job4j.storexml;

import org.junit.Test;

import java.io.File;

/**
 * Class Test StoreXML.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 04.07.2018
 */
public class StoreSQLTest {

    @Test
    public void connectSqlite() {
        StoreSQL store = new StoreSQL("config.properties");
        store.generate(10000);
        File f = new File("target.xml");
        StoreXML sXml = new StoreXML(f);
        sXml.save(new ArrayEntry(store.getList()));
        ConvertXSQT convertXSQT = new ConvertXSQT();
        convertXSQT.convert(new File("target.xml"), new File("rezult.xsl"), new File("styleSheet.xsl"));
        ParserSax sax = new ParserSax();
        sax.count(new File("rezult.xsl"));
    }

}