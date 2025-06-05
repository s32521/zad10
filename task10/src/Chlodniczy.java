public class Chlodniczy extends Kontener {
    private String rodzaj;
    private double temperatura;
    protected static int n = 0;

    private double getMinTemperatura(String rodzaj) throws IllegalArgumentException {
        if (rodzaj.equals("Banany")) return 13.3;
        else if (rodzaj.equals("Czekolada")) return 18;
        else if (rodzaj.equals("Ryba")) return 2;
        else if (rodzaj.equals("Mięso")) return -15;
        else if(rodzaj.equals("Lody")) return -18;
        else if(rodzaj.equals("Mrożona pizza")) return -30;
        else if(rodzaj.equals("Ser")) return 7.2;
        else if(rodzaj.equals("Kiełbasa")) return 5;
        else if (rodzaj.equals("Masło")) return 20.5;
        else if (rodzaj.equals("Jajka")) return 19;
        else throw new IllegalArgumentException("Nie ma takiego produktu");
     }

    public Chlodniczy(double masaLadunku, double wysokosc, double wagaKont, double glebokosc, double maxLadunku, String rodzaj, double temperatura) {
        super(masaLadunku, wysokosc, wagaKont, glebokosc, maxLadunku);
        this.rodzaj = rodzaj;
        this.temperatura = temperatura;
    }

    @Override
    protected String wygenerujNr() {
        n++;
        nrS2 = "C";
        return nrS1 + "-" + nrS2 + "-" + n;
    }



    @Override
    public String zaladowanieLadunku(double masa, boolean niebezpieczny) throws OverfillException {
        if (masa > getMaxLadunku()) {
            throw new OverfillException("Przekroczono maksymalną ładowność kontenera gazowego!");
        }
        setMasaLadunku(masa);
        return "Załadowano o masie " + masa + " do kontenera";
    }

    public String zaladowanieLadunku(double masa, String rodzaj) throws OverfillException {
        if (masa > getMaxLadunku()) {
            throw new OverfillException("Przekroczono maksymalną ładowność kontenera chłodniczego!");
        }else if( temperatura < getMinTemperatura(rodzaj) ) {
            throw new OverfillException("Za niska temperatura");
        }
        setMasaLadunku(masa);
        return "Załadowano " + rodzaj + " o masie " + masa + " i temperaturze " + temperatura +" C do kontenera";
    }
}
