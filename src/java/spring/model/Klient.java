package spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Klient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Pole nie może być puste")
    private String imie;
    @NotEmpty(message = "Pole nie może być puste")
    private String nazwisko;
    @NotEmpty(message = "Pole nie może być puste")
    @Email(message = "Niepoprawny email")
    private String email;
    @NotEmpty(message = "Pole nie może być puste")
    private String haslo;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "kurs_klient", joinColumns = @JoinColumn(name = "klient_id"), inverseJoinColumns = @JoinColumn(name = "kurs_id"))
    private List<Kurs> kursy;

    public Klient() {
        this.kursy = new ArrayList<>();
    }

    public Klient(String imie, String nazwisko, String email, String haslo) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;
        this.kursy = new ArrayList<>();
    }

    public List<Kurs> getKursy() {
        return kursy;
    }

    public void setKursy(List<Kurs> kursy) {
        this.kursy = kursy;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klient)) {
            return false;
        }
        Klient other = (Klient) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "model.Klient[ id=" + id + " ]";
    }

}
