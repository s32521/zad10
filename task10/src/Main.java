
public class Main {
    public static void main(String[] args) throws OverfillException {
        Plyny kontener1 = new Plyny(300.9, 90,325.8 , 800,1000);
       System.out.println(kontener1.oproznienieLadunku());
       System.out.println(kontener1.zaladowanieLadunku(300.9, false));
       System.out.println(kontener1.toString());


        Plyny kontener2 = new Plyny(890.9, 90,3205.8 , 890,10000);
        System.out.println(kontener2.oproznienieLadunku());
        System.out.println(kontener2.zaladowanieLadunku(890.9, true));
        System.out.println(kontener2.toString());

        Gaz gaz1 = new Gaz(500,40,207,200,600,20);
        System.out.println(gaz1.oproznienieLadunku());
        System.out.println(gaz1.zaladowanieLadunku(500, true));
        System.out.println(gaz1.toString());

        Chlodniczy chlodniczy1 = new Chlodniczy(90,40,207,200,600,"Banany", 20);
        System.out.println(chlodniczy1.oproznienieLadunku());
        System.out.println(chlodniczy1.zaladowanieLadunku(90, "Banany"));
        System.out.println(chlodniczy1.toString());

        Statek statek = new Statek("Fajny", 5, 25.0, 10000.0);

        System.out.println(statek.dodajKontener(kontener1));
        System.out.println(statek.dodajKontener(kontener2));
        System.out.println(statek.dodajKontener(gaz1));
        System.out.println(statek.dodajKontener(chlodniczy1));

        System.out.println(statek.toString());
        statek.wypiszKontenery();

        System.out.println(statek.rozladujKontener(kontener1.getNumerSer()));

        System.out.println(statek.usunKontener(gaz1.getNumerSer()));

        statek.wypiszKontenery();
    }
}

