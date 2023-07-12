package ru.netology.services;


public class FilmManager {
    private FilmInfo[] films = new FilmInfo[0];
    private int limit;

    public FilmManager() {
        this.limit = 5;
    }

    public FilmManager(int limit) {
        this.limit = limit;
    }

    public void addFilm(FilmInfo film) {
        FilmInfo[] tmp = new FilmInfo[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    public FilmInfo[] getFilms() {
        return films;
    }

    public int getLimit() {
        return limit;
    }

    public FilmInfo[] findAll() {
        int resultLength;
        if (limit < films.length) {
            resultLength = this.limit;
        } else {
            resultLength = films.length;
        }
        FilmInfo[] all = new FilmInfo[resultLength];
        for (int i = 0; i < all.length; i++) {
            all[i] = films[i];
        }
        return all;
    }

    public FilmInfo[] findLast() {
        int resultLength;

        if (limit < films.length) {
            resultLength = this.limit;
        } else {
            resultLength = films.length;
        }
        FilmInfo[] last = getFilms();
        FilmInfo[] reversed = new FilmInfo[resultLength];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = last[last.length - 1 - i];
        }
        return reversed;
    }

}