package UF4.Pt3.act;

public class NIF {
    private int numeroDNI;
    private char letra;

    public NIF(int numeroDNI, char letra) {
        this.numeroDNI = numeroDNI;
        this.letra = letra;
    }

    private boolean comprovarLetra() {
        String lletresPermeses = "TRWAGMYFPDXBNJZSQVHLCKE";
        char lletraCalculada = lletresPermeses.charAt(numeroDNI % 23);
        return letra == lletraCalculada;
    }

    public String getNIF() {
        if (comprovarLetra()) {
            return numeroDNI + Character.toString(letra);
        } else {
            return "NIF incorrecte";
        }
    }

    public void setNIF(int numeroDNI, char letra) {
        this.numeroDNI = numeroDNI;
        this.letra = letra;
    }


    public int getNumeroDNI() {
        return numeroDNI;
    }
    public char getLletra() {
        return letra;
    }
}
