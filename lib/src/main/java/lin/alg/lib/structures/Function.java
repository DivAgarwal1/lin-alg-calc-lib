package lin.alg.lib.structures;

public abstract class Function {
    private Function derivative;

    public double compute(double x) {
        return 0;
    };

    public final void manuallySetDerivative(Function derivative) {
        this.derivative = derivative;
    }

    public final Function getManuallySetDerivative() {
        return derivative;
    }

    public final double solve(double guess, double maxRepetitions) {
        double x = guess;
        for (int i = 0; i < maxRepetitions; i++) {
            x = solve(0, x);
        }
        return x;
    }

    private double solve(int count, double x) {
        if (count > 7000) {
            return x;
        }

        double x1 = x - compute(x)/calculateDerivativeAtPoint(x);
        return solve(count + 1, x1);
    }

    public final double calculateDerivativeAtPoint(double x) {
        if (derivative != null) {
            return derivative.compute(x);
        }

        return (compute(x + 0.0000000001) - compute(x)) / 0.0000000001;
    }
}
