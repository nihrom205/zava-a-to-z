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
    private UserAction[] actions = new UserAction[6];

    /**
     * Констуртор
     * @param input интефейс
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
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowAllItem();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();

    }

    /**
     * выбор значения из пользовательского меню.
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
    private static class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the task name: ");
            String desc = input.ask("Please enter the task desc: ");
            long data = Calendar.getInstance().getTimeInMillis();
            tracker.add(new Item(name, desc, data));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }

    /**
     * Внутренний кла для вывода всех заявок на экран.
     */
    private static class ShowAllItem implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                long date = item.getCreated();
                String strDate = String.format("%td.%tm.%tY %tl:%tM", date, date, date, date, date);
                System.out.println("ID: " + item.getId() + " Name: " + item.getName() + " Description: " + item.getDesc() + " Date: " + strDate);
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all item");
        }
    }

    /**
     * Внутренний клас для редактирования заявки.
     */
    private static class EditItem implements UserAction {
        @Override
        public int key() {
            return 2;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }
    }

    /**
     * Внутренний клас для удаления заявки.
     */
    private static class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Input id item for deleting: ");
            tracker.delete(tracker.findById(id));
            System.out.println("items for id:" + id + " deleting\n");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }

    /**
     * Внутренний класс для поиска заявки по id.
     */
    private static class FindById implements UserAction {
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Input id item for search: ");
            Item item = tracker.findById(id);
            if (item != null) {
                long date = item.getCreated();
                String strDate = String.format("%td.%tm.%tY %tl:%tM", date, date, date, date, date);
                System.out.println("ID: " + item.getId() + " Name: " + item.getName() + " Description: " + item.getDesc() + " Date: " + strDate);
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by id");
        }
    }

    /**
     * Внутренний класс для поиска заявки по имени.
     */
    private static class FindByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Input name item for search: ");
            for (Item item : tracker.findByName(name)) {
                long date = item.getCreated();
                String strDate = String.format("%td.%tm.%tY %tl:%tM", date, date, date, date, date);
                System.out.println("ID: " + item.getId() + " Name: " + item.getName() + " Description: " + item.getDesc() + " Date: " + strDate);
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by id");
        }
    }

}
