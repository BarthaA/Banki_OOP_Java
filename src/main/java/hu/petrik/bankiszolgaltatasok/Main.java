package hu.petrik.bankiszolgaltatasok;

public class Main {
    public static void main(String[] args) {
        Tulajdonos tulajdonos = new Tulajdonos("Kiss Péter");

        Bank bank = new Bank();

        Szamla megtakaritasiSzamla = bank.szamlaNyitas(tulajdonos, 0);
        System.out.println("Megtakarítási számla egyenleg: " + megtakaritasiSzamla.getEgyenleg());

        megtakaritasiSzamla.befizet(50000);
        System.out.println("Befizetés után egyenleg: " + megtakaritasiSzamla.getEgyenleg());

        if (megtakaritasiSzamla instanceof MegtakaritasiSzamla) {
            ((MegtakaritasiSzamla) megtakaritasiSzamla).kamatJovairas();
            System.out.println("Kamat jóváírása után egyenleg: " + megtakaritasiSzamla.getEgyenleg());
        }

        Szamla hitelSzamla = bank.szamlaNyitas(tulajdonos, 100000);
        System.out.println("Hitel számla egyenleg: " + hitelSzamla.getEgyenleg());

        boolean sikeresKivetel = hitelSzamla.kivesz(30000);
        System.out.println("Sikeres kivétel: " + sikeresKivetel);
        System.out.println("Egyenleg a kivétel után: " + hitelSzamla.getEgyenleg());

        sikeresKivetel = hitelSzamla.kivesz(100000);
        System.out.println("Sikeres kivétel: " + sikeresKivetel);
        System.out.println("Egyenleg: " + hitelSzamla.getEgyenleg());

        Kartya kartya = hitelSzamla.ujKartya("1234-5678-9012-3456");
        System.out.println("Kártya száma: " + kartya.getKartyaSzam());

        boolean vasarlasSikeres = kartya.vasarlas(20000);
        System.out.println("Vásárlás sikeres: " + vasarlasSikeres);
        System.out.println("Számla egyenlege vásárlás után: " + hitelSzamla.getEgyenleg());

        int osszEgyenleg = bank.getOsszEgyenleg(tulajdonos);
        System.out.println("Tulajdonos összes egyenlege: " + osszEgyenleg);

        Szamla legnagyobbEgyenleguSzamla = bank.getLegnagyobbEgyenleguSzamla(tulajdonos);
        System.out.println("Legnagyobb egyenlegű számla egyenlege: " + (legnagyobbEgyenleguSzamla != null ? legnagyobbEgyenleguSzamla.getEgyenleg() : "Nincs számla"));

        int osszHitelkeret = bank.getOsszHitelkeret();
        System.out.println("Bank összes hitelkerete: " + osszHitelkeret);
    }
}
