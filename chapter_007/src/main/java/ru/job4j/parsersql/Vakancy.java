package ru.job4j.parsersql;

import java.util.Calendar;
import java.util.Objects;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 09.08.2018
 */
public class Vakancy {
    private String subject;
    private String url;
    private Calendar calendar;

    public Vakancy(String subject, String url, Calendar calendar) {
        this.subject = subject;
        this.url = url;
        this.calendar = calendar;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vakancy vakancy = (Vakancy) o;
        return Objects.equals(subject, vakancy.subject) && Objects.equals(url, vakancy.url);
                //&&
                //Objects.equals(calendar, vakancy.calendar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, url);
    }

    @Override
    public String toString() {
        return "Vakancy{" + "\nsubject='" + subject + '\'' + ", \nurl='" + url + '\'' + ", \ncalendar= " + calendar.getTime().toString() + '}' + "\n";
    }
}