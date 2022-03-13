package com.company;

import com.company.structures.*;

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
        } catch (MatrixInputMismatchException e) {
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
        } catch (MatrixInputMismatchException e) {
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
}
