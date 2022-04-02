import lin.alg.lib.structures.Function;

public class Main {
    public static void main(String[] args) {
        Function function = new Function() {
            @Override
            public double compute(double x) {
                return x * Math.exp(x);
            }
        };

        System.out.println(function.solve(10, 5));
        System.out.println(function.calculateDerivativeAtPoint(10));
    }
}
