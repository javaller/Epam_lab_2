import org.junit.Test;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Home on 20.01.2017.
 */


class Pen {

    private int idNumber;
    private String color;
    private int size;

    public Pen(int idNumber, String color, int size) {
        if (color == null || size == 0) throw new IllegalArgumentException();
        this.idNumber = idNumber;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "ID: " + idNumber + " Color: " + color + " Size: " + size;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pen)) return false;
        Pen pen = (Pen) obj;
        return this.idNumber == pen.idNumber && this.color == pen.color;
    }

    @Override
    public int hashCode() {
        return this.idNumber + 7 * this.color.hashCode();
    }
}

public class TestTask1 {

    @Test
    public void test() {
        Pen pen = new Pen(1, "red", 15);
        Pen pen2 = pen;
        assertThat(pen.toString(), is("ID: 1 Color: red Size: 15"));
        assertTrue(pen.equals(pen2));
        assertThat(pen.hashCode(), is(789496));
    }

}