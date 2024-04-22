package hh_sof.kahvilaakso.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Arvostelu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int arvosana;
    private String kommentti;

    @ManyToOne
    private User user;

    @ManyToOne
    private Kahvi kahvi;

    public Arvostelu() {
    }

    public Arvostelu(User user, int arvosana, String kommentti, Kahvi kahvi) {
        this.user = user;
        this.arvosana = arvosana;
        this.kommentti = kommentti;
        this.kahvi = kahvi;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getArvosana() {
        return arvosana;
    }

    public void setArvosana(int arvosana) {
        this.arvosana = arvosana;
    }

    public String getKommentti() {
        return kommentti;
    }

    public void setKommentti(String kommentti) {
        this.kommentti = kommentti;
    }

    public Kahvi getKahvi() {
        return kahvi;
    }

    public void setKahvi(Kahvi kahvi) {
        this.kahvi = kahvi;
    }


    @Override
    public String toString() {
        return "Arvostelu [id=" + id + ", käyttäjä=" + user + ", arvosana=" + arvosana + ", kommentti=" + kommentti + "]";
    }
}
