package db;

import models.Film;
import models.FilmCrew;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBFilm {

    private static Session session;

    public static void addFilmToFilmCrew(Film film, FilmCrew filmCrew) {
        film.addfilmCrew(filmCrew);
        filmCrew.addFilm(film);
        DBHelper.saveOrUpdate(film);
    }

        public static List<FilmCrew> getfilmFilmCrew(Film film){
            List<FilmCrew> results = null;
            session = HibernateUtil.getSessionFactory().openSession();
            try {
                Criteria cr = session.createCriteria(FilmCrew.class);
                cr.createAlias("films", "film"); // ADDED
                cr.add(Restrictions.eq("film.id", film.getId())); // ADDED
                results = cr.list();
            } catch (HibernateException ex){
                ex.printStackTrace();
            } finally {
                session.close();
            }
            return results;

        }


        }





//            public static List<Raid> getPirateRaids(Pirate pirate){
//        List<Raid> results = null;
//        session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            Criteria cr = session.createCriteria(Raid.class);
//            cr.createAlias("pirates", "pirate"); // ADDED
//            cr.add(Restrictions.eq("pirate.id", pirate.getId())); // ADDED
//            results = cr.list();
//        } catch (HibernateException ex){
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return results;


