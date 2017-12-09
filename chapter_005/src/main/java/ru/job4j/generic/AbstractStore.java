package ru.job4j.generic;

/**
 * AbstractClass.
 * для реализации мотодов Store.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 07.12.2017
 */
public class AbstractStore<T extends Base> implements Store {

    private SimpleArray<Base> simpleArray = new SimpleArray<>(5);

    @Override
    public Base add(Base model) {
        simpleArray.add(model);
        return model;
    }

    @Override
    public Base update(Base model) {
        T userRezult = null;
        String id = model.getId();
        T oldUser = (T) simpleArray.get(0);
        int index = 1;

        while (oldUser != null) {
            if (id.equals(oldUser.getId())) {
                simpleArray.update(oldUser, model);
                userRezult = oldUser;
                break;
            }

            try {
                oldUser = (T) simpleArray.get(index); // в SimpleArray можно в методе get сделать проверку и не использовать Exception код меньше займет
            } catch (ArrayIndexOutOfBoundsException e) {
//            e.printStackTrace();
            }

            index++;

        }

        return userRezult;
    }

    @Override
    public boolean delete(String id) {
        boolean isDelete = false;
        T rezult = null;
        T delUser = null;
        int idInt = Integer.valueOf(id);
        delUser = (T) simpleArray.get(0);
        int index = 1;
        while (delUser != null) {
            if (id.equals(delUser.getId())) {
                isDelete = simpleArray.delete(delUser);;
                break;
            }

            try {
                delUser = (T) simpleArray.get(index);
            } catch (ArrayIndexOutOfBoundsException e) {
//                e.printStackTrace();
            }
            index++;
        }
        return isDelete;
    }
}