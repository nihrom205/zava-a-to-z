package ru.job4j.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 27.01.2019
 */
public class DropServiceTest {

    @Test
    public void whenSimpleStringThen() {
        DropService dropService = new DropService();
        String[] backList = {"aaa", "bbb", "ccc"};
        byte[] byteIn = new String("zz ccc vv aaa rr").getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(byteIn);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        dropService.dropAbuses(in, out, backList);
        byte[] byteOut = out.toByteArray();
        assertThat(new String(byteOut).equals("zz  vv  rr"), is(true));
    }

}