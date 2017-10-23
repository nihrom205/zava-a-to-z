package ru.job4j.shape;

/**
 * класс квадрат.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 22.10.2017
 */
public class Square implements Shape {
    /**
     * метод печатает квадрат.
     * @return строку
     */
    @Override
    public String pic() {
        StringBuilder sb = new StringBuilder();
        sb.append("++++++\n");
        sb.append("++++++\n");
        sb.append("++++++\n");
        sb.append("++++++\n");
        return sb.toString();
    }
}
