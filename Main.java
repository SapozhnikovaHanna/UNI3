public class Main {
    public static void main(String[] args) {
        //Обчислення факторіалу
        FactorialCalculator factorialCalculator = new FactorialCalculator();
        int n = 5;
        int recursionResult = factorialCalculator.recursionExecute(n);
        int cycleResult = factorialCalculator.cycleExecute(n);
        assert recursionResult == cycleResult : "Різні значення";
        System.out.println("Факторіал числа " + n + ":");
        System.out.println("Вхідні дані: " + n);
        System.out.println("Рекурсивний результат: " + recursionResult);
        System.out.println("Циклічний результат: " + cycleResult);

        //Обчислення числа Фібоначчі
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
        n = 7;
        recursionResult = fibonacciCalculator.recursionExecute(n);
        cycleResult = fibonacciCalculator.cycleExecute(n);
        assert recursionResult == cycleResult : "Різні значення";
        System.out.println("\nЧисло Фібоначчі на позиції " + n + ":");
        System.out.println("Вхідні дані: " + n);
        System.out.println("Рекурсивний результат: " + recursionResult);
        System.out.println("Циклічний результат: " + cycleResult);

        //Обчислення суми цифр числа
        SumOfDigitsCalculator sumOfDigitsCalculator = new SumOfDigitsCalculator();
        n = 12345;
        int sum = sumOfDigitsCalculator.execute(n);
        System.out.println("\nСума цифр числа " + n + ":");
        System.out.println("Вхідні дані: " + n);
        System.out.println("Сума: " + sum);

        //Обчислення суми без оператора '+'
        SumWithoutPlusOperatorCalculator sumWithoutPlusOperatorCalculator = new SumWithoutPlusOperatorCalculator();
        int a = 10;
        int b = 5;
        int sumWithoutPlus = sumWithoutPlusOperatorCalculator.execute(a, b);
        System.out.println("\nСума чисел " + a + " і " + b + " без оператора '+':");
        System.out.println("Вхідні дані: a = " + a + ", b = " + b);
        System.out.println("Сума: " + sumWithoutPlus);
    }
}
// Клас для обчислення факторіалу
class FactorialCalculator {
    public int recursionExecute(int n) {
        if (n == 0) {
            return 1;
        }
        return n * recursionExecute(n - 1);
    }

    public int cycleExecute(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

// Клас для обчислення числа Фібоначчі
class FibonacciCalculator {
    public int recursionExecute(int n) {
        if (n <= 1) {
            return n;
        }
        return recursionExecute(n - 1) + recursionExecute(n - 2);
    }

    public int cycleExecute(int n) {
        if (n <= 1) {
            return n;
        }
        int fib = 1;
        int prevFib = 1;
        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }
}

// Клас для обчислення суми цифр числа
class SumOfDigitsCalculator {
    public int execute(int n) {
        int sum = sumOfDigits(n);
        assert sumOfDigitsRecursive(n) == sum : "Різні значення";
        return sum;
    }

    private int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumOfDigits(n / 10);
    }

    private int sumOfDigitsRecursive(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + sumOfDigitsRecursive(n / 10);
    }
}

// Клас для обчислення суми без оператора '+'
class SumWithoutPlusOperatorCalculator {
    public int execute(int a, int b) {
        int sum = sumWithoutPlus(a, b);
        assert sumWithoutPlusRecursive(a, b) == sum : "Різні значення";
        return sum;
    }

    private int sumWithoutPlus(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    private int sumWithoutPlusRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return sumWithoutPlusRecursive(sum, carry);
    }
}
