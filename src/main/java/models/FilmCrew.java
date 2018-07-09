package models;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "filmCrews")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class FilmCrew {

    private int id;
    private String firstName;
    private String lastName;
    private int money;
    private List<Film> films;

    public FilmCrew() {
    }

    public FilmCrew(String firstName, String lastName, int money) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
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

    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "money")
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "film_filmCrew",
            joinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "filmCrew_id", nullable = false, updatable = false)})
    public List<Film> getFilm() {
        return films;
    }

    public void setFilm(List<Film> film) {
        this.films = film;
    }

    public void addFilm(Film film) {
        this.films.add(film);
    }

    public void getPaid(int amount) {
        this.money += amount;
    }
}

////    payActor (studio budget goes down, actors cash goes up)could not get this to work in actor as as money is "private"
//        in filmCrew


