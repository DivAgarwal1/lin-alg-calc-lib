package lin.alg.lib;

import lin.alg.lib.structures.*;

public class LinAlgLib {
    public static Polynomial createFunction(double[] function) {
        double[] temp = new double[function.length];
        for (int i = 0; i < function.length; i++) {
            temp[i] = function[function.length - i - 1];
        }
        return new Polynomial(temp);
    }

    public static Polynomial createFunction(int[] function) {
        int[] temp = new int[function.length];
        for (int i = 0; i < function.length; i++) {
            temp[i] = function[function.length - i - 1];
        }
        return new Polynomial(temp);
    }

    public static Polynomial takeDerivative(Polynomial polynomial) {
        if (polynomial.getRows() <= 1) return LinAlgLib.createFunction(new int[]{0});
        Derivative derivative = new Derivative(polynomial.getRows());
        Matrix matrix = new Matrix(new double[][]{});
        try {
            matrix =  Matrix.multiply(derivative, polynomial);
        } catch (MatrixDimesionException e) {
            e.printStackTrace();
        }

        double[] temp = new double[polynomial.getRows() - 1];
        for (int i = 0; i < polynomial.getRows() - 1; i++) {
            temp[i] = matrix.get(i, 0);
        }
        return new Polynomial(temp);
    }

    public static Polynomial takeIntegral(Polynomial polynomial) {
        Integral integral = new Integral(polynomial.getRows());
        Matrix matrix = new Matrix(new double[][]{});
        try {
            matrix =  Matrix.multiply(integral, polynomial);
        } catch (MatrixDimesionException e) {
            e.printStackTrace();
        }

        double[] temp = new double[polynomial.getRows() - 1];
        for (int i = 0; i < polynomial.getRows() + 1; i++) {
            temp[i] = matrix.get(i, 0);
        }
        return new Polynomial(temp);
    }

    public static Polynomial takeIntegral(Polynomial polynomial, double c) {
        Polynomial returnF = takeIntegral(polynomial);
        returnF.set(0, c);
        return returnF;
    }

    public static Polynomial takeIntegral(Polynomial polynomial, double x, double equals) {
        Polynomial returnF = takeIntegral(polynomial);
        double c = equals - returnF.compute(x);
        returnF.set(0, c);
        return returnF;
    }

    public static Polynomial cosine(double amplitude, double frequency, int terms) {
        double[] coefficients = new double[2*terms];
        int sign;
        for (int i = 0; i < 2*terms; i+=2) {
            if (i % 4 == 0) sign = 1;
            else sign = -1;
            coefficients[i] = sign * amplitude * Math.pow(frequency, i) / factorial(i);
        }
        return new Polynomial(coefficients);
    }

    public static Polynomial cosine(double amplitude, double frequency) {
        return cosine(amplitude, frequency, 100);
    }

    public static Polynomial cosine(int terms) {
        return cosine(1, 1, terms);
    }

    public static Polynomial cosine() {
        return cosine(100);
    }
    public static Polynomial sine(double amplitude, double frequency, int terms) {
        double[] coefficients = new double[2*terms];
        int sign;
        for (int i = 1; i < 2*terms; i+=2) {
            if (i % 4 == 1) sign = 1;
            else sign = -1;
            coefficients[i] = sign * amplitude * Math.pow(frequency, i) / factorial(i);
        }
        return new Polynomial(coefficients);
    }

    public static Polynomial sine(double amplitude, double frequency) {
        return sine(amplitude, frequency, 100);
    }

    public static Polynomial sine(int terms) {
        return sine(1, 1, terms);
    }

    public static Polynomial sine() {
        return sine(100);
    }

    public static double factorial(int n) {
        double sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }
}
