package hu.petrik.bankiszolgaltatasok;

public class HitelSzamla extends Szamla {
    private final int hitelkeret;

    public HitelSzamla(Tulajdonos tulajdonos, int hitelkeret) {
        super(tulajdonos);
        this.hitelkeret = hitelkeret;
    }

    public int getHitelkeret() {
        return hitelkeret;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (egyenleg - osszeg >= -hitelkeret) {
            egyenleg -= osszeg;
            return true;
        }
        return false;
    }
}
