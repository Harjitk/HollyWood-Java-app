package models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "studios")

public class Studio {
    private int id;
    private String name;
    private String location;
    private int budget;
    private List<Film> films;

    public Studio() {
    }

    public Studio(String name, String location, int budget) {
        this.name = name;
        this.location = location;
        this.budget = budget;
        this.films = new ArrayList<Film>();

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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "budget")
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @OneToMany(mappedBy = "studio", fetch = FetchType.LAZY)
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }


    public void payFilmCrew(FilmCrew filmCrew, int amount) {
        filmCrew.getPaid(amount);
        this.budget = this.budget - amount;
    }
}

//SHIP CLASS
//    @OneToMany(mappedBy="ship", fetch = FetchType.LAZY)
//    public Set<Pirate> getCrew() {
//        return crew;
//    }
//
//    public void setCrew(Set<Pirate> crew) {
//        this.crew = crew;
//    }



