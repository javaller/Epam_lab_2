/**
 * Created by Home on 24.01.2017.
 */

public class TestTask6 {

    /**
     * Name of a Submarine
     */
    static class Soldier {
        private String name = "Ivan";
    }

    /**
     * Test test
     *
     * @param args
     */


    public static void main(String[] args) {
        Submarine submarine = new Submarine();
//        Submarine.Engine engine = submarine.new Engine();
//        engine.start();
        submarine.run(1);
        submarine.fire();
        Soldier soldier = new Soldier();
        System.out.println(soldier.name);
    }
}