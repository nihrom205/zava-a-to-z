package ru.job4j.storexml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 08.07.2018
 */
@XmlRootElement
//@XmlType(name = "entries")
public class Entry {

    private int field;

    public Entry() {
    }

    public Entry(int value) {
        this.field = value;
    }

    @XmlElement(name = "field")
    public int getFiels() {
        return field;
    }

    public void setField(int value) {
        this.field = value;
    }
}
