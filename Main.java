import java.util.Scanner;

/**
* лас для представлення числа ібоначчі
*/
class FibonacciNumber {
    int index; // номер числа
    long value; // значення числа

    FibonacciNumber(int index, long value) {
        this.index = index;
        this.value = value;
    }

    int getIndex() {
        return index;
    }

    long getValue() {
        return value;
    }
}

public class Main {
    // етод для обчислення n-го числа ібоначчі
    static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // еревірка, чи є число квадратом
    static boolean isSquare(long x) {
        long s = (long) Math.sqrt(x);
        return s * s == x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;

        if (args.length > 0) {
            N = Integer.parseInt(args[0]);
        } else {
            System.out.print("ведіть N: ");
            N = sc.nextInt();
        }

        FibonacciNumber[] numbers = new FibonacciNumber[N];

        System.out.println("\nерші " + N + " чисел ібоначчі:");
        for (int i = 0; i < N; i++) {
            long val = fibonacci(i);
            numbers[i] = new FibonacciNumber(i, val);
            System.out.println("F(" + i + ") = " + val);
        }

        System.out.println("\nисла, які є квадратами:");
        boolean found = false;
        for (int i = 0; i < N; i++) {
            if (isSquare(numbers[i].getValue())) {
                System.out.println("F(" + numbers[i].getIndex() + ") = " + numbers[i].getValue());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Серед перших " + N + " чисел квадратів немає.");
        }
    }
}
