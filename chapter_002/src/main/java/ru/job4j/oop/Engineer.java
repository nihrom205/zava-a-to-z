package ru.job4j.oop;

/**
 * Class Engineer.
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 17.10.2017
 */
public class Engineer extends Profession {

    /**
     * метод подсчитывает смету.
     * @param drawing чертеж
     * @return смета
     */
    public Smeta calculation(Drawing drawing) {
        Smeta smeta = new Smeta();
        smeta.setNameBuilding("Инжинер " + this.getName() + " общитывает " + drawing.getDraw() + " для здания");
        return smeta;
    }

    /**
     * метод ведет процесс строительства здание.
     * @param order заказ
     * @return процес выполнения
     */
    public Building build(Order order) {
        Building building = new Building();
        building.setProcess("Инжинер " + this.getName() + " получил " + order.getZakaz() + " на строительство");
        return building;
    }
}
