public class Gaz extends Kontener implements IHazardNotifier{
    protected static int n = 0;
    private double cisnienie;

    @Override
    protected String wygenerujNr() {
        n++;
        nrS2 = "G";
        return nrS1 + "-" + nrS2 + "-" + n;
    }

    public Gaz(double masaLadunku, double wysokosc, double wagaKont, double glebokosc, double maxLadunku, double cisnienie) {
        super(masaLadunku, wysokosc, wagaKont, glebokosc, maxLadunku);
        this.cisnienie = cisnienie;
    }

    public double getCisnienie() {
        return cisnienie;
    }

    public void setCisnienie(double cisnienie) {
        this.cisnienie = cisnienie;
    }

    @Override
    public String zaladowanieLadunku(double masa, boolean niebezpieczny) throws OverfillException {
            if (masa > getMaxLadunku()) {
                notifyHazard("Próba przeładowania kontenera gazowego " + wygenerujNr() + " (masa: " + masa + ")");
                throw new OverfillException("Przekroczono maksymalną ładowność kontenera gazowego!");
            }

            setMasaLadunku(masa);
            return "Załadowano gaz o masie " + masa + " kg (ciśnienie: " + cisnienie + " atm) do kontenera";
        }
    @Override
    public void notifyHazard(String message) {
        System.out.println("!!! ALERT " + message);
    }


    }

