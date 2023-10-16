package com.negoci;

public class Punt {
    private double x;
    private double y;

    public Punt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void desplazar(char coordenada, double valor) {
        if (coordenada == 'x') {
            x += valor;
        } else if (coordenada == 'y') {
            y += valor;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double distancia(Punt altre) {
        double dx = x - altre.getX();
        double dy = y - altre.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public Punt puntMig(Punt altre) {
        double migX = (x + altre.getX()) / 2;
        double migY = (y + altre.getY()) / 2;
        return new Punt(migX, migY);
    }
}
