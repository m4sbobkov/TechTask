import java.util.Scanner;

public class Main {
    static byte a;
    static byte b;
    static boolean flag = true;
    static boolean isRome = true; // переменная, чтобы определить пример записан в виде римских цифр или арабских


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, I'm Simple Calculator. Please enter what I need to calculate: ");


        while (flag) {

            String calc1 = scan.nextLine(); // вводим пример, который нужно решить
            String calc = calc1.replaceAll("\\s", ""); // убираем из строки пробелы, если они есть
            try {
                calculate(calc);
            } catch (NotArithmeticOperationException e) {
                e.printStackTrace();
                flag = false;
            }

            System.out.println("One more?(y/n)");
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("n")) {
                flag = false;
            }
        }

    }

    // Сама функция калькулятора
    static void calculate(String calc) throws NotArithmeticOperationException {
        if (calc.contains("+")) {
            sum(calc);
        } else if (calc.contains("-")) {
            diff(calc);
        } else if (calc.contains("*")) {
            multy(calc);
        } else if (calc.contains("/")) {
            div(calc);
        } else {
            throw new NotArithmeticOperationException(calc + " is not arithmetic operation");
        }
    }


    //Метод вычисления суммы
    static void sum(String str) {
        String[] operands = str.split("\\+");

        try {
            a = Byte.parseByte(operands[0]);
            b = Byte.parseByte(operands[1]);
            isRome = false;
        } catch (NumberFormatException e) {
            try {
                a = RomeNumber.valueOf(operands[0]).getValue();
                b = RomeNumber.valueOf(operands[1]).getValue();
                isRome = true;
            } catch (IllegalArgumentException ex) {

                throw new RuntimeException("I can't calculate rome numbers with arabian", ex);
            }
        }

        try {
            checkNumbers(a, b);
        } catch (WrongNumberException ex) {
            ex.printStackTrace();
            flag = false;
        }
        if (!isRome) {
            System.out.println(a + b);
        } else {
            try {
                checkNegativeRomeNumber(RomeNumber.fromValue((byte) (a + b)));
            } catch (NegativeRomeNumberException e) {
                e.printStackTrace();
                flag = false;
            }
        }


    }

    //Метод вычисления разности
    static void diff(String str) {
        String[] operands = str.split("-");
        try {
            a = Byte.parseByte(operands[0]);
            b = Byte.parseByte(operands[1]);
            isRome = false;
        } catch (NumberFormatException e) {
            try {
                a = RomeNumber.valueOf(operands[0]).getValue();
                b = RomeNumber.valueOf(operands[1]).getValue();
                isRome = true;
            } catch (IllegalArgumentException ex) {

                throw new RuntimeException("I can't calculate rome numbers with arabian", ex);

            }
        }

        try {
            checkNumbers(a, b);

        } catch (WrongNumberException ex) {
            ex.printStackTrace();
            flag = false;
        }
        if (!isRome) {
            System.out.println(a - b);
        } else {
            try {
                checkNegativeRomeNumber(RomeNumber.fromValue((byte) (a - b)));
            } catch (NegativeRomeNumberException e) {
                e.printStackTrace();
                flag = false;
            }
        }
    }

    //Метод вычисления произведения
    static void multy(String str) {
        String[] operands = str.split("\\*");
        try {
            a = Byte.parseByte(operands[0]);
            b = Byte.parseByte(operands[1]);
            isRome = false;
        } catch (NumberFormatException e) {
            try {
                a = RomeNumber.valueOf(operands[0]).getValue();
                b = RomeNumber.valueOf(operands[1]).getValue();
                isRome = true;
            } catch (IllegalArgumentException ex) {

                throw new RuntimeException("I can't calculate rome numbers with arabian", ex);
            }
        }

        try {
            checkNumbers(a, b);

        } catch (WrongNumberException ex) {
            ex.printStackTrace();
        }
        if (!isRome) {
            System.out.println(a * b);
        } else {
            try {
                checkNegativeRomeNumber(RomeNumber.fromValue((byte) (a * b)));
            } catch (NegativeRomeNumberException e) {
                e.printStackTrace();
                flag = false;
            }
        }
    }

    //Метод вычисления частного
    static void div(String str) {
        String[] operands = str.split("/");
        try {
            a = Byte.parseByte(operands[0]);
            b = Byte.parseByte(operands[1]);
            isRome = false;
        } catch (NumberFormatException e) {
            try {
                a = RomeNumber.valueOf(operands[0]).getValue();
                b = RomeNumber.valueOf(operands[1]).getValue();
                isRome = true;
            } catch (IllegalArgumentException ex) {

                throw new RuntimeException("I can't calculate rome numbers with arabian", ex);
            }
        }


        try {
            checkNumbers(a, b);

        } catch (WrongNumberException ex) {
            ex.printStackTrace();
        }
        if (!isRome) {
            System.out.println(a / b);
        } else {
            try {
                checkNegativeRomeNumber(RomeNumber.fromValue((byte) (a / b)));
            } catch (NegativeRomeNumberException e) {
                e.printStackTrace();
                flag = false;
            }

        }
    }

    // Метод проверки соответствия чисел указанному диапазону
    static void checkNumbers(int x, int y) throws WrongNumberException {
        if (!(x <= 10 && x >= 1 && y >= 1 && y <= 10)) {
            throw new WrongNumberException("I can calculate just from 1 to 10");
        }
    }

    // Метод перевода римских цифр в арабские, до того как решил сделать через enum

    /**
     * static byte romeToArab(String s) throws WrongNumberException{
     * //        byte arab = 0;
     * //
     * //
     * //
     * //        switch (s){
     * //            case "I":
     * //                arab = 1;
     * //                break;
     * //            case "II":
     * //                arab = 2;
     * //                break;
     * //            case "III":
     * //                arab = 3;
     * //                break;
     * //            case "IV":
     * //                arab = 4;
     * //                break;
     * //            case "V":
     * //                arab = 5;
     * //                break;
     * //            case "VI":
     * //                arab = 6;
     * //                break;
     * //            case "VII":
     * //                arab = 7;
     * //                break;
     * //            case "VIII":
     * //                arab = 8;
     * //                break;
     * //            case "IX":
     * //                arab = 9;
     * //                break;
     * //            case "X":
     * //                arab = 10;
     * //                break;
     * //            default:
     * //                throw new WrongNumberException("Sorry "+ s + " is not a number or I don't know it");
     * //        }
     * //        return arab;
     * //    }
     */

    static void checkNegativeRomeNumber(RomeNumber x) throws NegativeRomeNumberException {
        if (x == null) {
            throw new NegativeRomeNumberException("There is no negative rome numbers");
        } else {
            System.out.println(x);
        }
    }

}
