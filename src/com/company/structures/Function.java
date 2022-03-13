package com.company.structures;

public class Function extends ColumnVector {
    public Function() {
        super(new double[]{});
    }

    public Function(int len) {
        super(len);
    }

    public Function(double[] function) {
        super(function);
    }

    public Function(int[] function) {
        super(function);
    }

    public double compute(double x) {
        double total = 0;
        for (int i = 0; i < getRows(); i++) {
            total += get(i) * Math.pow(x, i);
        }
        return total;
    }

    @Override
    public void print() {
        System.out.println("--------------------");
        double[] temp = new double[getRows()];
        for (int i = 0; i < getRows(); i++) {
            if (i == getRows() - 1) System.out.print("" + get(getRows() - i - 1) + " * x^" + (getRows() - i - 1) + "\n");
            else System.out.print("" + get(getRows() - i - 1) + " * x^" + (getRows() - i - 1) + "   +   ");
        }
        System.out.println("--------------------");
    }
}
