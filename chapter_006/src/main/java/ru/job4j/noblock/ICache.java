package ru.job4j.noblock;

/**
 * Interface ICache.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 07.04.2018
 */
public interface ICache {
    void add(Model model);
    Model update(Model updateModel);
    void delete(Model model);

}
