package ru.job4j.storexml;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Class для конвертации в другой фармат XML.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 15.07.2018
 */
public class ConvertXSQT {

    public void convert(File source, File dest, File scheme) {
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Transformer transformer = factory.newTransformer(new StreamSource(scheme));
            transformer.transform(new StreamSource(source), new StreamResult(dest));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
