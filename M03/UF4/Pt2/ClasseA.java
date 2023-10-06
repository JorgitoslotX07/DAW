package dawmainm03.M03.UF4.Pt2;

public class ClasseA {
    private int valorPrimari;
    private int valorSecundari;    

    public ClasseA() {
        valorPrimari = 5;
        valorSecundari = 10;
    }

    public ClasseA(int valorPrimari) {
        this.valorPrimari = valorPrimari;
        valorSecundari = 10;
    }

    public ClasseA(int valorPrimari, int valorSecundari) {
        this.valorPrimari = valorPrimari;
        this.valorSecundari = valorSecundari;
    }

    public static final void main (String[] args) {
        ClasseA a = new ClasseA();
        ClasseA b = new ClasseA(20);
        ClasseA c = new ClasseA(20, 40);
        System.out.println("L'objecte [a] conté: " + a.getPrimari() + ", " + a.getSecundari());
        System.out.println("L'objecte [b] conté: " + b.getPrimari() + ", " + b.getSecundari());
        System.out.println("L'objecte [c] conté: " + c.getPrimari() + ", " + c.getSecundari());
        }

    
    public int getPrimari() {
        return this.valorPrimari;
    }

    public void setPrimari(int valorPrimari) {
        this.valorPrimari = valorPrimari;
    }


    public int getSecundari() {
        return this.valorSecundari;
    }

    public void setSecundari(int valorSecundari) {
        this.valorSecundari = valorSecundari;
    }
}
