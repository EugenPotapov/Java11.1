package ru.netology.services;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {

    FilmInfo film1 = new FilmInfo("Бладшот");
    FilmInfo film2 = new FilmInfo("Вперёд");
    FilmInfo film3 = new FilmInfo("Отель 'Белград'");
    FilmInfo film4 = new FilmInfo("Джентельмены");
    FilmInfo film5 = new FilmInfo("Человек - невидимка");
    FilmInfo film6 = new FilmInfo("Тролли. Мировой тур");
    FilmInfo film7 = new FilmInfo("Номер один");

    @Test
    public void addFilms() {
        FilmManager add = new FilmManager();
        add.addFilm(film1);
        add.addFilm(film2);
        add.addFilm(film3);
        add.addFilm(film4);
        add.addFilm(film5);
        add.addFilm(film6);
        add.addFilm(film7);
        FilmInfo[] expected = {film1, film2, film3, film4, film5, film6, film7};
        FilmInfo[] actual = add.getFilms();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void newLimit() {
        FilmManager newLimit = new FilmManager(7);
        int expected = 7;
        int actual = newLimit.getLimit();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void defaultLimit() {
        FilmManager defaultLimit = new FilmManager();
        int expected = 5;
        int actual = defaultLimit.getLimit();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void reversed() {
        FilmManager reversed = new FilmManager();
        reversed.addFilm(film7);
        reversed.addFilm(film3);
        reversed.addFilm(film1);
        FilmInfo[] expected = {film1, film3, film7};
        FilmInfo[] actual = reversed.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void reversedUnderLimit() {
        FilmManager underLimitReversed = new FilmManager(2);
        underLimitReversed.addFilm(film1);
        underLimitReversed.addFilm(film3);
        underLimitReversed.addFilm(film5);
        FilmInfo[] expected = {film5, film3};
        FilmInfo[] actual = underLimitReversed.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void reversedNoLimit() {
        FilmManager noLimitReversed = new FilmManager(5);
        noLimitReversed.addFilm(film1);
        noLimitReversed.addFilm(film3);
        noLimitReversed.addFilm(film5);
        FilmInfo[] expected = {film5, film3, film1};
        FilmInfo[] actual = noLimitReversed.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void inSeriesUnderLimit() {
        FilmManager underLimitInSeries = new FilmManager(2);
        underLimitInSeries.addFilm(film2);
        underLimitInSeries.addFilm(film4);
        underLimitInSeries.addFilm(film6);
        FilmInfo[] expected = {film2, film4};
        FilmInfo[] actual = underLimitInSeries.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void inSeriesNoLimit() {
        FilmManager noLimitInSeries = new FilmManager(5);
        noLimitInSeries.addFilm(film2);
        noLimitInSeries.addFilm(film4);
        noLimitInSeries.addFilm(film6);
        FilmInfo[] expected = {film2, film4, film6};
        FilmInfo[] actual = noLimitInSeries.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}