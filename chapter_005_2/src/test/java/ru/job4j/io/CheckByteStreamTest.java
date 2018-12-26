package ru.job4j.io;

import org.junit.Test;
import java.io.ByteArrayInputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 26.12.2018
 */
public class CheckByteStreamTest {

    @Test
    public void whenArrayToTrue() {
        CheckByteStream check = new CheckByteStream();
        byte[] array = new String("34abcd").getBytes();
        ByteArrayInputStream byteArray = new ByteArrayInputStream(array);

        assertThat(check.isNumber(byteArray), is(true));
    }

    @Test
    public void whenArrayToFalse() {
        CheckByteStream check = new CheckByteStream();
        byte[] array = new String("3ab7cd").getBytes();
        ByteArrayInputStream byteArray = new ByteArrayInputStream(array);

        assertThat(check.isNumber(byteArray), is(false));
    }

}
