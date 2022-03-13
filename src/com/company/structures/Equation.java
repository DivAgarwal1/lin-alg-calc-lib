package com.company.structures;

public class Equation {
    private final Function function;
    private final double val;

    public Equation(Function function, double val) {
        this.function = function;
        this.val = val;
    }

    public Function getFunction() {
        return function;
    }

    public double getVal() {
        return val;
    }
}
