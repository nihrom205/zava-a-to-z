package ru.job4j.shape;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Testing class Paint.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version $1d$
 * @since 22.10.17
 */
public class PaintTest {
    /**
     * Testing method Square.
     */
    @Test
    public void whenTransferSquareleThenPrintTriangle() {
        Paint paint = new Paint();
        assertThat(paint.draw(new Square()), is("++++++\n++++++\n++++++\n++++++\n"));
    }

    /**
     * Testing method Triangle.
     */
    @Test
    public void whenTransferTriangleThenPrintTriangle() {
        Paint paint = new Paint();
        assertThat(paint.draw(new Triangle()), is("   +   \n  +++  \n +++++ \n+++++++\n"));
    }
}
