

public class ComplexNumber {
    public static final ComplexNumber ZERO = new ComplexNumber(0, 0);
    private double real;
    private double imaginary;

    public ComplexNumber() {
        this.real = 0;
        this.imaginary = 0;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber(ComplexNumber other) {
        this.real = other.real;
        this.imaginary = other.imaginary;
    }


    public double getReal() {
        return real;
    }
    public double getImaginary() {
        return imaginary;
    }

    public void setReal(double real) {
        this.real = real;
    }
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber c) {
        double newReal = this.real + c.real;
        double newImaginary = this.imaginary + c.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    @Override
    public String toString() {
        return "Real -> " + this.getReal() + "\nImaginary -> " + this.getImaginary() + "\n";
    }

     public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(2.0, 3.0);
        ComplexNumber c2 = new ComplexNumber(1.5, 2.5);

        System.out.println("Complex 1 -> " + c1.toString());
        System.out.println("Complex 2 -> " + c2.toString());

        ComplexNumber sum = c1.add(c2);
        System.out.println("add:\n" + sum.toString());
        System.out.println("Real add -> " + sum.getReal());
        System.out.println("Imaginària add -> " + sum.getImaginary());
    }
}
