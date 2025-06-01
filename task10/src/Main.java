
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
    }
}