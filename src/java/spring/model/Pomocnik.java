package spring.model;


public class Pomocnik {
    
    private String kierunek;
    private int miejsca;
    private boolean zalogowany;

    public Pomocnik() {
        zalogowany = false;
    }

    public boolean isZalogowany() {
        return zalogowany;
    }

    public void setZalogowany(boolean zalogowany) {
        this.zalogowany = zalogowany;
    }

    public int getMiejsca() {
        return miejsca;
    }

    public void setMiejsca(int miejsca) {
        this.miejsca = miejsca;
    }
    

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

}
