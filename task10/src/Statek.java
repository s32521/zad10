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

}
