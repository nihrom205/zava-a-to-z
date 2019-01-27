package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 27.01.2019
 */
public class SearchTest {
    List<String> doc;
    List<String> zip;
    List<String> exec;
    List<String> audio;

    @Before
    public void init() {
        doc = Arrays.asList("doc", "xls", "txt", "pdf", "html");
        zip = Arrays.asList("zip", "7z", "rar");
        exec = Arrays.asList("exe", "bin");
        audio = Arrays.asList("mp3", "aac");
    }

    @Test
    public void whenSearcDicTypeThenRezultFile() {
        Search search = new Search();
        List<File> rezult = search.files("tmpdir", doc);
        assertThat(rezult.size(), is(16));
    }

    @Test
    public void whenSearcArchivTypeThenRezultFile() {
        Search search = new Search();
        List<File> rezult = search.files("tmpdir", zip);
        assertThat(rezult.size(), is(1));
    }

    @Test
    public void whenSearcAudioTypeThenRezultFile() {
        Search search = new Search();
        List<File> rezult = search.files("tmpdir", audio);
        assertThat(rezult.size(), is(1));
    }

    @Test
    public void whenSearcExecuteTypeThenRezultFile() {
        Search search = new Search();
        List<File> rezult = search.files("tmpdir", exec);
        assertThat(rezult.size(), is(1));
    }

}