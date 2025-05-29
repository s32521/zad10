public class Plyny extends Kontener{

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
}
