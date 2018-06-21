package ru.job4j.tracker;

/**
 * Class Item.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 18.10.2017
 */
public class Item {
    /**
     * уникльный номер заявки.
     */
    private String id;
    /**
     * имя заявки.
     */
    private String name;
    /**
     * описание заявки.
     */
    private String desc;
    /**
     * датасоздания заявки.
     */
    private long created;
    /**
     * список коментариев.
     */
    private String[] comments;

    /**
     *  конструктор.
     * @param name наименование заявки
     * @param desc описание заявки
     * @param created дата создания заявки
     */
    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public Item(String id, String name, String desc, long created) {
        this(name, desc, created);
        this.id = id;
    }



    /**
     * возвращает уникальный номер.
     * @return уникальный номер
     */
    public String getId() {
        return id;
    }
    /**
     * устанавливается уникальный номер.
     * @param id  уникальный номер
     */

    /**
     * возвращается наименование заявки.
     * @return наименование
     */
    public String getName() {
        return name;
    }

    /**
     * устанавливается имя заявки.
     * @param name умя заявки
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * возвращает описание.
     * @return описание
     */
    public String getDesc() {
        return desc;
    }

    /**
     * задается описание заявки.
     * @param desc описание
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * возвращает дату создания заявки.
     * @return дата
     */
    public long getCreated() {
        return created;
    }

    /**
     * устанавливает дату создания заявки.
     * @param created дата
     */
    public void setCreated(long created) {
        this.created = created;
    }

    /**
     * возвращает коментарии.
     * @return коментарии
     */
    public String[] getComments() {
        return comments;
    }

    /**
     * устанавливается коментарий.
     * @param comments коментарий
     */
    public void setComments(String[] comments) {
        this.comments = comments;
    }
}
