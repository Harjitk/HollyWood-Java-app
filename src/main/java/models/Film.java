package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "films")

public class Film {

    private int id;
    private String title;
    private Genre genre;
    private Studio studio;
    private List<FilmCrew> filmCrews;

    public Film() {
    }

    public Film(String title, Genre genre, Studio studio) {
        this.title = title;
        this.genre = genre;
        this.studio = studio;
        this.filmCrews = new ArrayList<FilmCrew>();
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

    @Enumerated(value = EnumType.STRING)
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "film_filmCrew",
            joinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "filmCrew_id", nullable = false, updatable = false)})
    public List<FilmCrew> getFilmCrew() {

        return filmCrews;
    }

    public void setFilmCrew(List<FilmCrew> filmCrew) {
        this.filmCrews = filmCrews;
    }

    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    public Studio getStudio() {

        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }



    public void addfilmCrew(FilmCrew filmCrew) {
        this.filmCrews.add(filmCrew);
    }
}


