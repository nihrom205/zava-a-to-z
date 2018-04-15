package ru.job4j.noblock;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Хранилище моделей.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 07.04.2018
 */
public class Cache implements ICache {

    private ConcurrentHashMap<Integer, Model> store = new ConcurrentHashMap<>();

    /**
     * Метод добавляет новый элемент в колекцию
     * @param model модель
     */
    @Override
    public void add(Model model) {
        store.put(model.getId(), model);
    }

    /**
     * метод обновляет в кэше модель если она найдена, иначе пропускает
     * @param updateModel модель
     */
    @Override
    public Model update(Model updateModel) {
        Model rezult = null;
        int id = updateModel.getId();
        Model currentModel = store.get(id);
        if (updateModel.getVersion() == currentModel.getVersion()) {
            updateModel.setVersion(updateModel.getVersion() + 1);
            rezult = store.computeIfPresent(id, (k, v) -> new Model(updateModel.getId(), updateModel.getName()));
        }
        return rezult;
    }

    /**
     * метод удаляет меодель
     * @param model модель
     */
    @Override
    public void delete(Model model) {
        store.remove(model.getId());
    }
}
