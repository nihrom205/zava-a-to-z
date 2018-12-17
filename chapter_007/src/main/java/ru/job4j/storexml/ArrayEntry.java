package ru.job4j.storexml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 15.07.2018
 */
@XmlRootElement (name = "entries")
public class ArrayEntry {
    private List<Entry> values;

    public ArrayEntry() {

    }

    public ArrayEntry(List<Entry> values) {
        this.values = values;
    }

    @XmlElement(name = "entry")
    public List<Entry> getValues() {
        return values;
    }

    public void setValues(List<Entry> values) {
        this.values = values;
    }
}
