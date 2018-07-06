package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "films")

public class Film {

    private int id;
    private String title;
    private Genre genre;
    private Director director;
    private List<FilmCrew> filmCrew;
    private Studio studio;

    public Film() {
    }

    public Film(int id, String title, Genre genre, Director director, Studio studio) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.studio = studio;
        this.filmCrew = new ArrayList<FilmCrew>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "genre")
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Column(name = "director")
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Column(name = "filmCrew")
    public List<FilmCrew> getFilmCrew() {
        return filmCrew;
    }

    public void setFilmCrew(List<FilmCrew> filmCrew) {
        this.filmCrew = filmCrew;
    }

    @Column(name = "studio")
    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
}

