package models;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actors")

public class Actor extends FilmCrew{

    private List<Film> films;

    public Actor() {
    }

    public Actor(int id, String firstName, String lastName, int money, List<Film> films) {
        super(id, firstName, lastName, money);
        this.films = new ArrayList<Film>();
    }
}
