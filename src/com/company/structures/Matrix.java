package com.company.structures;

public class Matrix {
    private double[][] matrix;

    public Matrix(int x, int y) {
        matrix = new double[x][y];
    }

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix(int[][] matrix) {
        this.matrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public void set(int x, int y, double val) {
        matrix[x][y] = val;
    }

    public double get(int x, int y) {
        return matrix[x][y];
    }

    public int getRows() {
        return matrix.length;
    }

    public int getColumns() {
        return matrix[0].length;
    }

    public boolean isSquare() {
        return getRows() == getColumns();
    }

    public void print() {
        System.out.println("--------------------");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matrix[0].length;j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }
    
    public static Matrix add(Matrix m1, Matrix m2) throws MatrixInputMismatchException{
        if (!(m1.getRows() == m2.getRows() && m1.getColumns() == m2.getColumns())) throw new MatrixInputMismatchException();
        else {
            Matrix returnM = new Matrix(m1.getRows(), m2.getColumns());
            for (int i = 0; i < m1.getRows(); i++) {
                for (int j = 0; j < m2.getRows(); j++) {
                    returnM.set(i, j, m1.get(i, j) + m2.get(i, j));
                }
            }
            return returnM;
        }
    }
    
    public static Matrix multiply(double scalar, Matrix matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                matrix.set(i, j, matrix.get(i, j) * scalar);
            }
        }
        return matrix;
    }
    
    public static Matrix multiply(Matrix m1, Matrix m2) throws MatrixInputMismatchException {
        if (m1.getColumns() != m2.getRows()) throw new MatrixInputMismatchException();
        else {
            Matrix returnM = new Matrix(m1.getRows(), m2.getColumns());
            double val1, val2, sum;
            for (int i = 0; i < m1.getRows(); i++) {
                for (int j = 0; j < m2.getColumns(); j++) {
                    sum = 0;
                    for (int k = 0; k < m1.getColumns(); k++) {
                        val1 = m1.get(i, k); val2 = m2.get(k, j);
                        sum += val1*val2;
                    }
                    returnM.set(i, j, sum);
                }
            }
            return returnM;
        }
    }
}
