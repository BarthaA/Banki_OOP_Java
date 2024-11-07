package hu.petrik.bankiszolgaltatasok;

public class MegtakaritasiSzamla extends Szamla {
    private static double alapKamat = 1.1;
    private double kamat;

    public MegtakaritasiSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.kamat = alapKamat;
    }

    public double getKamat() {
        return kamat;
    }

    public void setKamat(double kamat) {
        this.kamat = kamat;
    }

    public static double getAlapKamat() {
        return alapKamat;
    }

    public static void setAlapKamat(double alapKamat) {
        MegtakaritasiSzamla.alapKamat = alapKamat;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (egyenleg - osszeg >= 0) {
            egyenleg -= osszeg;
            return true;
        }
        return false;
    }

    public void kamatJovairas() {
        egyenleg *= kamat;
    }
}
