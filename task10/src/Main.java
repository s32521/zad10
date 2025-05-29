//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws OverfillException {
        Plyny kontener1 = new Plyny(300.9, 90,325.8 , 800,1000);
       System.out.println(kontener1.oproznienieLadunku());
       System.out.println(kontener1.zaladowanieLadunku());
       System.out.println(kontener1.toString());


        Plyny kontener2 = new Plyny(890.9, 90,3205.8 , 890,10000);
        System.out.println(kontener2.oproznienieLadunku());
        System.out.println(kontener2.zaladowanieLadunku());
        System.out.println(kontener2.toString());
    }
}