package finalExersise;

import java.util.Scanner;

public class ViewCalculator {

    private ICalculableFactory calculableFactory;

    public ViewCalculator(ICalculableFactory calculableFactory) {
        this.calculableFactory = calculableFactory;
    }

    public void start() {
        org.example.CalcLogger calcLog = new org.example.CalcLogger();
        calcLog.createLog("Программа запущена");
        while (true) {

            int argReal = promptInt("Введите вещественную часть комплексного числа: ");
            int argImaginary = promptInt("Введите мнимую часть комплексного числа: ");
            Calculable calculator = calculableFactory.create(argReal, argImaginary);
            calcLog.createLog(argReal, argImaginary);
            while (true) {
                String cmd = prompt("Введите команду (*, +, /, =) : ");
                if (cmd.equals("*")) {
                    int argReal2 = promptInt("Введите вещественную часть второго комплексного числа: ");
                    int argImaginary2 = promptInt("Введите мнимую часть второго комплексного числа: ");
                    calculator.multi(argReal2,argImaginary2);
                    calcLog.createLog(cmd);
                    calcLog.createLog(argReal2, argImaginary2);
                    continue;
                }
                if (cmd.equals("+")) {
                    int argReal2 = promptInt("Введите вещественную часть второго комплексного числа: ");
                    int argImaginary2 = promptInt("Введите мнимую часть второго комплексного числа: ");
                    calculator.sum(argReal2,argImaginary2);
                    calcLog.createLog(cmd);
                    calcLog.createLog(argReal2, argImaginary2);
                    continue;
                }
                if (cmd.equals("/")) {
                    int argReal2 = promptInt("Введите вещественную часть второго комплексного числа: ");
                    int argImaginary2 = promptInt("Введите мнимую часть второго комплексного числа: ");
                    calculator.div(argReal2,argImaginary2);
                    calcLog.createLog(cmd);
                    calcLog.createLog(argReal2, argImaginary2);
                    continue;
                }
                if (cmd.equals("=")) {
                    String result = calculator.getResult();
                    System.out.println("Результат " + result);
                    calcLog.createLog(" = " + result);
                    break;
                }
            }
            String cmd = prompt("Еще посчитать (Y/N)?");
            if (cmd.equalsIgnoreCase("Y")) {
                continue;
            }
            break;
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private int promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }
}
