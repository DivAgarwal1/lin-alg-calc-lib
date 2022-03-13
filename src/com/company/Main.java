package com.company;

public class Main {
    public static void main(String[] args) {
        double jerk = 3;
        double initAccel = 0;
        Function accelration = new Function(new double[]{
                jerk, initAccel
        });
        accelration.print();
        Function velocity = LinAlgLib.takeIntegral(accelration, common_bound, val_of_old_function_at_common_bound);
    }
}
