public class Plyny extends Kontener implements IHazardNotifier{

    protected static int n = 0;
    @Override
    protected String wygenerujNr(){
       n++;
       nrS2 = "L";
       return nrS1 + "-" + nrS2+"-"+n;
    }
    public Plyny(double masaLadunku, double wysokosc, double wagaKont, double glebokosc, double maxLadunku){
        super(masaLadunku, wysokosc, wagaKont, glebokosc, maxLadunku);

    }
    @Override
    public String zaladowanieLadunku(double masa, boolean niebezpieczny) throws OverfillException {
        double limit = niebezpieczny ? 0.5 * getMaxLadunku() : 0.9 * getMaxLadunku();

        if(masa > limit){
            notifyHazard("Niebezpieczny ładunek poza limitem.");
            throw new OverfillException("Przekroczono limit załadunku: " + masa + " > " + limit);
        }
        setMasaLadunku(masa);
        return "Załadowano " + masa + " kg do kontenera";
    }


    @Override
    public void notifyHazard(String message) {
        System.out.println("!!! ALERT " + message);
    }
}
