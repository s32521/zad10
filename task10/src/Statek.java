import java.util.ArrayList;
import java.util.List;

public class Statek {
    private String nazwa;
    private int maxIleKontenery;
    private double maxPredkosc;
    private double maxWaga;
    private List<Kontener> kontenery;

    public Statek(String nazwa, int maxIleKontenery, double maxPredkosc, double maxWaga) {
        this.nazwa = nazwa;
        this.maxIleKontenery = maxIleKontenery;
        this.maxPredkosc = maxPredkosc;
        this.maxWaga = maxWaga;
        this.kontenery = new ArrayList<Kontener>();
    }

    public String dodajKontener(Kontener kontener) throws OverfillException{
        if(this.kontenery.contains(kontener)){
            throw new OverfillException("Już kontener został dodany");
        }
        if(kontener.getMasaLadunku() + kontener.getWagaKont() >= maxWaga){
            throw new OverfillException("Za duża waga");
        }
        if(kontenery.size() > maxIleKontenery){
            throw new OverfillException("Za dużo kontenerów");
        }
        kontenery.add(kontener);
        return "Kontener o nazwie" + nazwa + "został dodany.";
    }

    public String usunKontener(String numer) throws OverfillException {
        for (Kontener k : kontenery) {
            if (k.getNumerSer().equals(numer)) {
                kontenery.remove(k);
                return "Usunięto kontener " + numer;
            }
        }
        throw new OverfillException("Nie znaleziono kontenera do usunięcia.");
    }

    public String rozladujKontener(String numer) throws OverfillException {
        for (Kontener k : kontenery) {
            if (k.getNumerSer().equals(numer)) {
                return k.oproznienieLadunku();
            }
        }
        throw new OverfillException("Nie znaleziono kontenera");
    }

    public String zastapKontener(String numer, Kontener nowy) throws OverfillException {
        for (int i = 0; i < kontenery.size(); i++) {
            if (kontenery.get(i).getNumerSer().equals(numer)) {
                kontenery.set(i, nowy);
                return "Zastąpiono kontener " + numer + " nowym: " + nowy.getNumerSer();
            }
        }
        throw new OverfillException("Nie znaleziono kontenera");
    }

    public String przeniesKontener(Statek cel, String numer) throws OverfillException {
        for (Kontener k : kontenery) {
            if (k.getNumerSer().equals(numer)) {
                cel.dodajKontener(k);
                kontenery.remove(k);
                return "Przeniesiono kontener " + numer + " na statek " + cel.nazwa;
            }
        }
        throw new OverfillException("Nie znaleziono kontenera");
    }

    public void wypiszKontenery() {
        System.out.println("Kontenery na statku " + nazwa + ":");
        for (Kontener k : kontenery) {
            System.out.println(k.toString());
        }
    }

    @Override
    public String toString() {
        return "Statek: " + nazwa + ", prędkość max: " + maxPredkosc + " w, maks kontenerów: " + maxIleKontenery + ", maks waga: " + maxWaga + " kg, obecnie załadowanych: " + kontenery.size();
    }



}
