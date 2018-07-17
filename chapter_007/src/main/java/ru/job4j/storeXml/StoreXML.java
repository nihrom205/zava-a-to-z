package ru.job4j.storeXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Class класс сохраняет xml .
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 05.07.2018
 */
public class StoreXML {
    private File target;

    /**
     * Конструктор.
     */
    public StoreXML() {
    }

    /**
     * Конструктор с параметром File.
     * @param target файл для записи результата.
     */
    public StoreXML(File target) {
        this.target = target;
    }

    /**
     * Метод записывает в файл xml данные.
     * @param list список элементов.
     */
    public void save(ArrayEntry list) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ArrayEntry.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(list, target);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
