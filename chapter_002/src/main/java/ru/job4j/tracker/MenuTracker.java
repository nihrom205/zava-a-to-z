package ru.job4j.tracker;

import java.util.Calendar;

/**
 * Class MenuTracker.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 25.10.2017
 */
public class MenuTracker {
    /**
     * хранит в себе объект пользовательского интерфейса.
     */
    private Input input;

    /**
     * Объект с хранилищем заявок.
     */
    private Tracker tracker;

    /**
     * Массив действий пользователя.
     */
    private UserAction[] actions = new UserAction[7];

    private int position = 1;
    /**
     * Констуртор
     *
     * @param input   интефейс
     * @param tracker хранилище заявок
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Инициализация массива пользовательских действий.
     */
    public void fillAction() {
        this.actions[position++] = this.new AddItem("Add the new item.", 1);
        this.actions[position++] = this.new ShowAllItem("Show all item.", 2);
        this.actions[position++] = this.new EditItem("Edit item.", 3);
        this.actions[position++] = this.new DeleteItem("Delete item.", 4);
        this.actions[position++] = this.new FindById("Find item by id", 5);
        this.actions[position++] = this.new FindByName("Find item by name", 6);

    }

    /**
     * Возвращает список индексов массива пользовательских действий.
     * @return список индексов
     */
    public int[] getIndexFillAction() {
        int[] ranges = new int[this.actions.length - 1];
        for (int i = 1; i <= ranges.length; i++) {
            ranges[i - 1] = i;
        }
        return ranges;
    }

    /**
     * выбор значения из пользовательского меню.
     *
     * @param key значение
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * вывод в консоль названий у меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Внутренний клас для добавления заявок в хранилище.
     */
    private class AddItem extends BaseAction {

        public AddItem(String name, int key) {
            super(name, key);
        }

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the task name: ");
            String desc = input.ask("Please enter the task desc: ");
            long data = Calendar.getInstance().getTimeInMillis();
            tracker.add(new Item(name, desc, data));
        }
    }

    /**
     * Внутренний кла для вывода всех заявок на экран.
     */
    private class ShowAllItem extends BaseAction {
        public ShowAllItem(String name, int key) {
            super(name, key);
        }

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                long date = item.getCreated();
                String strDate = String.format("%td.%tm.%tY %tl:%tM", date, date, date, date, date);
                System.out.println("ID: " + item.getId() + ", Name: " + item.getName() + ", Description: " + item.getDesc() + ", Date: " + strDate);
            }
        }
    }

    /**
     * Внутренний клас для редактирования заявки.
     */
    private class EditItem extends BaseAction {

        public EditItem(String name, int key) {
            super(name, key);
        }

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Input your id for editing: ");
            String name = input.ask("Input new name: ");
            String desc = input.ask("Input new description: ");
            Item item = tracker.findById(id);
            item.setName(name);
            item.setDesc(desc);
            tracker.update(item);
        }
    }

    /**
     * Внутренний клас для удаления заявки.
     */
    private class DeleteItem extends BaseAction {

        public DeleteItem(String name, int key) {
            super(name, key);
        }

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Input id item for deleting: ");
            tracker.delete(tracker.findById(id));
            System.out.println("items for id:" + id + " deleting\n");
        }
    }

    /**
     * Внутренний класс для поиска заявки по id.
     */
    private class FindById extends BaseAction {

        public FindById(String name, int key) {
            super(name, key);
        }

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Input id item for search: ");
            Item item = tracker.findById(id);
            if (item != null) {
                long date = item.getCreated();
                String strDate = String.format("%td.%tm.%tY %tl:%tM", date, date, date, date, date);
                System.out.println("ID: " + item.getId() + ", Name: " + item.getName() + ", Description: " + item.getDesc() + ", Date: " + strDate);
            }
        }
    }

    /**
     * Внутренний класс для поиска заявки по имени.
     */
    private class FindByName extends BaseAction {

        public FindByName(String name, int key) {
            super(name, key);
        }

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Input name item for search: ");
            for (Item item : tracker.findByName(name)) {
                long date = item.getCreated();
                String strDate = String.format("%td.%tm.%tY %tl:%tM", date, date, date, date, date);
                System.out.println("ID: " + item.getId() + ", Name: " + item.getName() + ", Description: " + item.getDesc() + ", Date: " + strDate);
            }
        }
    }
}
