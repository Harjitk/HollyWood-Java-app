import db.DBHelper;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args){


        Actor actor1 = new Actor("Suraj", "Sharma", 8000);
        DBHelper.saveOrUpdate(actor1);
        Actor actor2 = new Actor("Emma", "Stone", 17000);
        DBHelper.saveOrUpdate(actor2);
        Actor actor3 = new Actor("Ryan", "Gosling", 15000);
        DBHelper.saveOrUpdate(actor3);
        Actor actor4 = new Actor("Chris", "Tucker", 10000);
        DBHelper.saveOrUpdate(actor4);


        Director director1 = new Director("Ang", "Lee", 16000);
        DBHelper.saveOrUpdate(director1);
        Director director2 = new Director("Tate", "Taylor", 20000);
        DBHelper.saveOrUpdate(director2);
        Director director3 = new Director("Nick", "Cassavetes", 17000);
        DBHelper.saveOrUpdate(director3);
        Director director4 = new Director(" Brett", "Ratner", 13000);
        DBHelper.saveOrUpdate(director4);

        Studio studio1 = new Studio("20th Century Fox", "Los Angeles", 9500000);
        DBHelper.saveOrUpdate(studio1);
        Studio studio2 = new Studio("Paramount", "Los Angeles", 800000);
        DBHelper.saveOrUpdate(studio2);


        Film film1 = new Film("Life of Pi", Genre.FANASTY, studio1);
        DBHelper.saveOrUpdate(film1);
        Film film2 = new Film("The Help", Genre.DRAMA, studio1);
        DBHelper.saveOrUpdate(film2);
        Film film3 = new Film("The Notebook", Genre.ROMANCE, studio2);
        DBHelper.saveOrUpdate(film3);
        Film film4 = new Film("Rush Hour", Genre.COMEDY, studio2);
        DBHelper.saveOrUpdate(film4);


        List<Film> allFilms = DBHelper.getAll(Film.class);
        List <FilmCrew> allFilmCrew = DBHelper.getAll(FilmCrew.class);
    }

}
