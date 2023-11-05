package UF4.Pt3.act;

public class NIF {
    private int numeroDNI;
    private char letra;

    //Potser es podria arrodonir contemplant també la revisió dels nombres (que siguin 8 xifres, però és cert que l'enunciat no ho demanava de forma explícita.
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

    //No té gaire sentit aquesta funció de setNIF, o es fa servir el constructor, o bé amb els dos setters es canvien els dos valors.
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
