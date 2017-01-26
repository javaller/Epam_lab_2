import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Home on 20.01.2017.
 */

abstract class Stationery implements Comparable<Stationery> {
    public double price;
    public String name;

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Stationery o) {
        return name.compareTo(o.name);
    }
}

class Pencil extends Stationery {
    private int size;

    public Pencil(String name, double price) {
        this.name = name;
        this.price = price;
    }

}

class Clip extends Stationery {
    public Clip(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Paper extends Stationery {
    private String format;

    public Paper(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class WorkPlace {

    private List<Stationery> stationeries;

    public WorkPlace() {
        stationeries = new ArrayList<>();
    }

    public WorkPlace(String str) {
        if (str == "Beginner") {
            stationeries = new ArrayList<>();
            stationeries.add(new Pencil("pencil", 50));
            stationeries.add(new Paper("paper", 80));
            stationeries.add(new Clip("clip", 80));
        } else {
            stationeries = new ArrayList<>();
        }

    }

    public void sortStationeries(String str) {
        if (str == "byPrice") {
            Comparator<Stationery> byPrice = new Comparator<Stationery>() {
                @Override
                public int compare(Stationery o1, Stationery o2) {
                    if (o1.getPrice() < o2.getPrice()) return -1;
                    if (o1.getPrice() > o2.getPrice()) return 1;
                    return 0;
                }
            };
            Collections.sort(stationeries, byPrice);
        } else if (str == "byPriceName") {
            Comparator<Stationery> byPriceName = new Comparator<Stationery>() {
                @Override
                public int compare(Stationery o1, Stationery o2) {
                    if (o1.getPrice() < o2.getPrice()) return -1;
                    if (o1.getPrice() > o2.getPrice()) return 1;
                    return o1.getName().compareTo(o2.getName());
                }
            };
            Collections.sort(stationeries, byPriceName);
        } else {
            Collections.sort(stationeries);
        }
    }

    public String getListWorkPlace() {
        String result = "";
        for (Stationery item : stationeries) {
            result += item.getName() + " " + item.getPrice() + " ";
        }
        return result;
    }

    public void addItem(Stationery item) {
        stationeries.add(item);
    }

    public double sumPrice() {
        double sum = 0.0;
        for (Stationery x : stationeries) {
            sum += x.getPrice();
        }
        return sum;
    }

}

public class TestTask23 {

    @Test
    public void test() {
//        Pencil pencil = new Pencil(50);
//        Clip clip = new Clip(60);
//        Paper paper = new Paper(20);
//        WorkPlace workplace = new WorkPlace();
//        workplace.addItem(paper);
//        workplace.addItem(clip);
//        workplace.addItem(pencil);
        WorkPlace workplace = new WorkPlace("Beginner");
        assertThat(workplace.sumPrice(), is(210.0));
        workplace.sortStationeries("byName");
        assertThat(workplace.getListWorkPlace(), is("clip 80.0 paper 80.0 pencil 50.0 "));
        workplace.sortStationeries("byPrice");
        assertThat(workplace.getListWorkPlace(), is("pencil 50.0 clip 80.0 paper 80.0 "));
        workplace.sortStationeries("byPriceName");
        assertThat(workplace.getListWorkPlace(), is("pencil 50.0 clip 80.0 paper 80.0 "));
    }
}