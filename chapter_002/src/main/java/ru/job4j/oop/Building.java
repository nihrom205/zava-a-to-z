package ru.job4j.oop;

/**
 * Class Building.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 17.10.2017
 */
public class Building {
    /**
     * процесс.
     */
    private String process;

    /**
     * метод предоставляет процесс строительства.
     *
     * @return процесс
     */
    public String getProcess() {
        return process;
    }

    /**
     * метод устанавливает процесс строительства.
     *
     * @param process процесс
     */
    public void setProcess(String process) {
        this.process = process;
    }
}