package ru.job4j.io;

import org.junit.Test;
import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 07.02.2019
 */
public class CompressionTest {

    @Test
    public void whenAddPathThenZipFie() {
        Compression compression = new Compression();
        compression.run(new String[]{"-d", "/tmp/project", "-e", "java.xml", "-o", "project.zip"});
        assertThat(new File("project.zip").exists(), is(true));
    }
}