package linalgcalclib;

import structures.*;

public class LinAlgLib {
    public static Function createFunction(double[] function) {
        double[] temp = new double[function.length];
        for (int i = 0; i < function.length; i++) {
            temp[i] = function[function.length - i - 1];
        }
        return new Function(temp);
    }

    public static Function createFunction(int[] function) {
        int[] temp = new int[function.length];
        for (int i = 0; i < function.length; i++) {
            temp[i] = function[function.length - i - 1];
        }
        return new Function(temp);
    }

    public static Function takeDerivative(Function function) {
        Derivative derivative = new Derivative(function.getRows());
        Matrix matrix = new Matrix(new double[][]{});
        try {
            matrix =  Matrix.multiply(derivative, function);
        } catch (MatrixDimesionException e) {
            e.printStackTrace();
        }

        double[] temp = new double[function.getRows() - 1];
        for (int i = 0; i < function.getRows() - 1; i++) {
            temp[i] = matrix.get(i, 0);
        }
        return new Function(temp);
    }

    public static Function takeIntegral(Function function) {
        Integral integral = new Integral(function.getRows());
        Matrix matrix = new Matrix(new double[][]{});
        try {
            matrix =  Matrix.multiply(integral, function);
        } catch (MatrixDimesionException e) {
            e.printStackTrace();
        }

        double[] temp = new double[function.getRows() - 1];
        for (int i = 0; i < function.getRows() + 1; i++) {
            temp[i] = matrix.get(i, 0);
        }
        return new Function(temp);
    }

    public static Function takeIntegral(Function function, double c) {
        Function returnF = takeIntegral(function);
        returnF.set(0, c);
        return returnF;
    }

    public static Function takeIntegral(Function function, double x, double equals) {
        Function returnF = takeIntegral(function);
        double c = equals - returnF.compute(x);
        returnF.set(0, c);
        return returnF;
    }

    public static Function cosine(double amplitude, double frequency, int terms) {
        double[] coefficients = new double[2*terms];
        int sign;
        for (int i = 0; i < 2*terms; i+=2) {
            if (i % 4 == 0) sign = 1;
            else sign = -1;
            coefficients[i] = sign * amplitude * Math.pow(frequency, i) / factorial(i);
        }
        return new Function(coefficients);
    }

    public static Function cosine(double amplitude, double frequency) {
        return cosine(amplitude, frequency, 100);
    }

    public static Function cosine(int terms) {
        return cosine(1, 1, terms);
    }

    public static Function cosine() {
        return cosine(100);
    }
    public static Function sine(double amplitude, double frequency, int terms) {
        double[] coefficients = new double[2*terms];
        int sign;
        for (int i = 1; i < 2*terms; i+=2) {
            if (i % 4 == 1) sign = 1;
            else sign = -1;
            coefficients[i] = sign * amplitude * Math.pow(frequency, i) / factorial(i);
        }
        return new Function(coefficients);
    }

    public static Function sine(double amplitude, double frequency) {
        return sine(amplitude, frequency, 100);
    }

    public static Function sine(int terms) {
        return sine(1, 1, terms);
    }

    public static Function sine() {
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
