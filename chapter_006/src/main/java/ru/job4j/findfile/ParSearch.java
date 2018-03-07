package ru.job4j.findfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 26.02.2018
 */
@ThreadSafe
public class ParSearch {
    private final String root;
    private final String text;
    private final List<String> exts;
    private volatile boolean finish = false;

    @GuardedBy("this")
    private final Queue<String> files = new LinkedList<>();

    @GuardedBy("this")
    private final List<String> paths = new ArrayList<>();

    public ParSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;

    }

    /**
     * инициализация и запуск нитей
     */
    public void init() {
        // нить для поиска файлов с заданными расширениями
        Thread search = new Thread() {
            @Override
            public void run() {
                findExts();
                finish = true;
            }
        };

        // нить для поиска текста в файле
        Thread read = new Thread() {
            @Override
            public void run() {
                while (!files.isEmpty()) {
                    findText(files.poll());
                }
            }
        };

        search.start();
        read.start();
        try {
            search.join();
            read.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * метод возвращает результат
     * @return список файлов
     */
    synchronized List<String> result() {
        return this.paths;

    }

    /**
     * Метод поиск тескста в переданном файле
     * @param file файл
     */
    private void findText(String file) {
        synchronized ("this") {
            Scanner sc = null;
            try {
                sc = new Scanner(new File(file));
                while (sc.hasNext()) {
                    String st = sc.nextLine();
                    if (st.indexOf(text) != -1) {
                        System.out.println(st);
                        paths.add(file);
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            sc.close();
        }
    }

    /**
     * метод обхода каталога
     */
    private void findExts() {
        synchronized ("this") {
            try {
                Files.walkFileTree(Paths.get(root), new MyVisit());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * класс поиска файлов с требуемыми расширениями заданы в списке " List<String> exts"
     * при нахожденни файла добавляется в очередь "Queue<String> files".
     */
    final class MyVisit extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            synchronized ("files") {
                if (attrs.isRegularFile()) {
                    String[] parsFile = file.getFileName().toString().split("\\.");
                    if (parsFile.length > 1 && exts.contains(parsFile[1].toLowerCase())) {
                        files.add(file.toAbsolutePath().toString());
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        }
    }

}
