/**
 * Created by Home on 25.01.2017.
 */

@ClassHistory(
        createdBy = "Vadim Opolskiy",
        dateCreate = "26/01/2017",
        versionNumber = 1,
        description = ""
)
public class Submarine {

    private String message = "Engine works!";

    /**
     * get message
     * @return meesage name
     */
    public String getMessage() {
        return message;
    }

    interface Fireable {
        public int fire();
    }

    //    protected class Engine {
//        public int repeat = 3;
//
//        public void start () {
//            for (int i = 0; i < repeat; i++) {
//                System.out.println(message);
//            }
//        }
//    }

    public void fire() {
        Fireable fa = new Fireable() {
            @Override
            public int fire() {
                return 3;
            }
        };

        for (int i = 0; i < fa.fire(); i++) {
            System.out.println("Fire!");
        }
    }

    /**
     * Method run.
     *
     * @param repeat a new person repeat
     */
    public void run(int repeat) {
        class Engine {

            public void start() {
                for (int i = 0; i < repeat; i++) {
                    System.out.println(message);
                }
            }
        }
        Engine engine = new Engine();
        engine.start();
        System.out.println("Submarine run!");
    }
}