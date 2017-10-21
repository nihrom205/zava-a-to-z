package ru.job4j.tracker;

import java.util.Calendar;
import java.util.Formatter;

public class StartUI {
    private static final int ADD = 0;
    private static final int SHOW_ALL = 1;
    private static final int EDIT = 2;
    private static final int DELETE = 3;
    private static final int FIND_ID = 4;
    private static final int FIND_NAME = 5;
    private static final int EXIT = 6;

    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        Tracker tracker = new Tracker();

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
        }
    }

    private void printItems(Item[] itemList) {
        System.out.println();
        for (Item item : itemList) {
//            String data = String.format("%td.%tm.%tY", item.getCreated());
            Formatter fmt = new Formatter();
            long date = item.getCreated();
            fmt.format("%td.%tm.%tY %tl:%tM", date, date, date, date, date);
            System.out.println("id:" + item.getId() + " name:" + item.getName() + " description:" + " date:" + fmt);
        }
        System.out.println();
    }

    private void add(Input input, Tracker tracker) {
        String name = input.ask("Input your name: ");
        String desc = input.ask("Input description name: ");
        long data = Calendar.getInstance().getTimeInMillis();
        tracker.add(new Item(name, desc, data));
        System.out.println();
    }

    private void showAll(Tracker tracker) {
        Item[] itemList = tracker.findAll();
        printItems(itemList);
    }

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

    private void delete(Input input, Tracker tracker) {
        String id = input.ask("Input id item for deleting: ");
        tracker.delete(tracker.findById(id));
        System.out.println("items for id:" + id + " deleting\n");
    }
    private void findId(Input input, Tracker tracker) {
        String id = input.ask("Input id item for search: ");
        tracker.findById(id);
    }

    private void findName(Input input, Tracker tracker) {
        String name = input.ask("Input name item for search: ");
        Item[] itemList = tracker.findByName(name);
        printItems(itemList);
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput()).init();
    }
}
