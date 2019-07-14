package wallets.portfele;

public class Pieniadze {
    private int kwota;
    private String waluta;

    public Pieniadze(int kwota, String waluta) {
        this.kwota = kwota;
        this.waluta = waluta;
    }

    public int getKwota() {
        return kwota;
    }

    public void setKwota(int kwota) {
        this.kwota = kwota;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    @Override
    public String toString() {
        return kwota + " " + waluta;
    }
}
