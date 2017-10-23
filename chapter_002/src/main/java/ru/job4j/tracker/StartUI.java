package ru.job4j.tracker;

import java.util.Calendar;
import java.util.Formatter;


/**
 * Класс для вывода меню.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 20.10.2017
 */
public class StartUI {
    /**
     * Const Add.
     */
    private static final int ADD = 0;
    /**
     * Const Show all.
     */
    private static final int SHOW_ALL = 1;
    /**
     * Const editing.
     */
    private static final int EDIT = 2;
    /**
     * Const delete.
     */
    private static final int DELETE = 3;
    /**
     * Const find by id.
     */
    private static final int FIND_ID = 4;
    /**
     * Const find by name.
     */
    private static final int FIND_NAME = 5;
    /**
     * Const exit.
     */
    private static final int EXIT = 6;

    /**
     * хранит в себе объект пользовательского интерфейса.
     */
    private Input input;

    /**
     * Объект с хранилищем заявок.
     */
    private Tracker tracker = null;

    /**
     * Конструктор.
     * @param input пользовательский интерфейс
     * @param tracker хранилище заявок
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Конструктор .
     * @param input пользовательский интерфейс
     */
    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * Инициализация программы.
     */
    public void init() {
        if (tracker == null) {
            tracker = new Tracker();
        }

        String[] questions = {"Add new Item",
                                "Show all item",
                                "Edit",
                                "Delete item",
                                "Find item by Id",
                                "Find items by name",
                                "Exit Program"};
        int code = -1;
        while (code != EXIT) {
            for (int i = 0; i < questions.length; i++) {
                System.out.println(i + ". " + questions[i]);
            }
            code = Integer.parseInt(input.ask("Select: "));
            menu(code, tracker);

        }
    }

    /**
     * метод для отображения меню.
     * @param code код выбора элемента им меню
     * @param tracker хранилище заявок
     */
    private void menu(int code, Tracker tracker) {
        switch (code) {
            case ADD:
                this.add(input, tracker);
                break;
            case SHOW_ALL:
                this.showAll(tracker);
                break;
            case EDIT:
                this.edit(input, tracker);
                break;
            case DELETE:
                this.delete(input, tracker);
                break;
            case FIND_ID:
                this.findId(input, tracker);
                break;
            case FIND_NAME:
                this.findName(input, tracker);
                break;
            default:
                //
                break;
        }
    }

    /**
     * метод ля печати заявок.
     * @param itemList список с заявками
     */
    private void printItems(Item[] itemList) {
        System.out.println();
        for (Item item : itemList) {
//            String data = String.format("%td.%tm.%tY", item.getCreated());
            Formatter fmt = new Formatter();
            long date = item.getCreated();
            fmt.format("%td.%tm.%tY %tl:%tM", date, date, date, date, date);
            System.out.println("id:" + item.getId() + " name:" + item.getName() + " description:" + item.getDesc() + " date:" + fmt);
        }
        System.out.println();
    }

    /**
     * метод ля добавления завяки.
     * @param input объект для взаимодействия с пользователем
     * @param tracker хранилише с заявками
     */
    private void add(Input input, Tracker tracker) {
        String name = input.ask("Input your name: ");
        String desc = input.ask("Input description name: ");
        long data = Calendar.getInstance().getTimeInMillis();
        tracker.add(new Item(name, desc, data));
        System.out.println();
    }

    /**
     * метод для выведения на печать всех заявок.
     * @param tracker хранилище заявок
     */
    private void showAll(Tracker tracker) {
        Item[] itemList = tracker.findAll();
        printItems(itemList);
    }

    /**
     * редактирование заявок.
     * @param input объект для взаимодействия с пользователем
     * @param tracker хранилише с заявками
     */
    private void edit(Input input, Tracker tracker) {
        String id = input.ask("Input your id for editing: ");
        String name = input.ask("Input new name: ");
        String desc = input.ask("Input new description: ");
        Item item = tracker.findById(id);
        item.setName(name);
        item.setDesc(desc);
        tracker.update(item);
        System.out.println();
    }

    /**
     * удаление заявки.
     * @param input объект для взаимодействия с пользователем
     * @param tracker хранилише с заявками
     */
    private void delete(Input input, Tracker tracker) {
        String id = input.ask("Input id item for deleting: ");
        tracker.delete(tracker.findById(id));
        System.out.println("items for id:" + id + " deleting\n");
    }

    /**
     * метод для поиска заявки по id.
     * @param input объект для взаимодействия с пользователем
     * @param tracker хранилише с заявками
     * @return заявка
     */
    private Item findId(Input input, Tracker tracker) {
        String id = input.ask("Input id item for search: ");
        Item item = tracker.findById(id);
        this.printItems(new Item[]{item});
        return item;
    }

    /**
     * метод для поиска заявки по имени.
     * @param input объект для взаимодействия с пользователем
     * @param tracker хранилише с заявками
     * @return pfz
     */
    private Item[] findName(Input input, Tracker tracker) {
        String name = input.ask("Input name item for search: ");
        Item[] itemList = tracker.findByName(name);
        printItems(itemList);
        return itemList;
    }

    /**
     * точка входа в программу.
     * @param args аргументы
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput()).init();
    }
}
