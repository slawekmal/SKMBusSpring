package spring.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;


@Entity
public class Kurs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dzien;
    private String godzina; 
    private int miejsca;
    private String kierunek;

    public Kurs(){
        
    }

    public Kurs(Calendar dzien, String godzina, int miejsca, String kierunek) {
        this.dzien = dzien;
        this.godzina = godzina;
        this.miejsca = miejsca;
        this.kierunek = kierunek;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public Calendar getDzien() {
        return dzien;
    }

    public void setDzien(Calendar dzien) {
        this.dzien = dzien;
    }

    public String getGodzina() {
        return godzina;
    }

    public void setGodzina(String godzina) {
        this.godzina = godzina;
    }

    public int getMiejsca() {
        return miejsca;
    }

    public void setMiejsca(int miejsca) {
        this.miejsca = miejsca;
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
        if (!(object instanceof Kurs)) {
            return false;
        }
        Kurs other = (Kurs) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }
    
    public String getDzienString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(this.dzien.getTime());
    }

    @Override
    public String toString() {
        return getDzienString() + ", " + this.godzina + ", " + this.kierunek;
    }

}
