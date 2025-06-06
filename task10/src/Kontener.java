public abstract class Kontener {
    private double masaLadunku;
    private double wysokosc;
    private double wagaKont;
    private double glebokosc;
    protected String numerSer;
    private double maxLadunku;

    protected static int n = 0;
    protected String nrS1 ="KON";
    protected String nrS2 ="brak";

    protected String wygenerujNr(){
        n++;
        return nrS1 + "-" + nrS2+"-"+n;
    }

    public Kontener(double masaLadunku, double wysokosc, double wagaKont, double glebokosc, double maxLadunku) {
        this.masaLadunku = masaLadunku;
        this.wysokosc = wysokosc;
        this.wagaKont = wagaKont;
        this.glebokosc = glebokosc;
        this.maxLadunku = maxLadunku;
        this.numerSer = wygenerujNr();
    }
    public double getMasaLadunku() {
        return masaLadunku;
    }
    public double getWysokosc() {
        return wysokosc;
    }
    public double getWagaKont() {
        return wagaKont;
    }
    public double glebokosc() {
        return glebokosc;
    }
    public double getMaxLadunku() {
        return maxLadunku;
    }

    public void setMasaLadunku(double masaLadunku) {
        this.masaLadunku = masaLadunku;
    }

    public String getNumerSer() {
        return numerSer;
    }

    public String oproznienieLadunku() {
        double nowaMasaLadunku;
        if(masaLadunku == 0) {
            return "Brak ładunku";
        }else {
           nowaMasaLadunku = masaLadunku - masaLadunku;
        }
        return "Opróżniono ładunek o wadzę:" + masaLadunku + ", nowa masa to:"+ nowaMasaLadunku;
    }

    public abstract String zaladowanieLadunku(double masa, boolean niebezpieczny) throws OverfillException;


    public String toString(){
        return "Masa ładunku " + masaLadunku + " kg, wysokość " + wysokosc + " cm, waga kontenera: " + wagaKont + "kg, głebokość " + glebokosc + "cm, numer seryjny " + wygenerujNr()+ "\n";
    }


}
