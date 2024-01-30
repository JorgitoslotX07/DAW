package m03.uf5.p1.excepcions;

//import java.util.EmptyStackException;

public class Pila {
    private int capacitat;
    private int index;
    private Integer[] dades;

    public Pila(int capacitat) {
        this.capacitat = capacitat;
        this.index = 0;
        this.dades = new Integer[capacitat];
    }

    public void afegir(int elem) {
        try {
            if (index >= capacitat) {
                throw new LogicException("Pila llena");
            }
            dades[index++] = elem;
        } catch (LogicException e) {
            System.out.println("Error lógico: " + e.getMessage());
        }   
    }

    public int extreure() {
        try {
            if (index == 0) {
                throw new LogicException("Pila vacia");
            }
            return dades[--index];
        } catch (LogicException e) {
            System.out.println("Error lógico: " + e.getMessage());
            return -1; 
        }
    }

    public int getTop() {
        try {
            if (index == 0) {
                throw new LogicException("Pila vacia");
            }
            return dades[index - 1];
        } catch (LogicException e) {
            System.out.println("Error lógico: " + e.getMessage());
            return -1;
        }
    }

    public void buidarPila() {
        index = 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Pila [");
        for (int i = 0; i < index; i++) {
            result.append(dades[i]);
            if (i < index - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
