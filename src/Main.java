import java.util.Scanner;

public class Main {
    static byte a;
    static byte b;
    int result;
    static boolean flag = true;


    public static void main(String[] args) {



        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, I'm Simple Calculator. Please enter what I need to calculate: ");
        while (flag == true) {

            String calc1 = scan.nextLine(); // вводим пример, который нужно решить
            String calc = calc1.replaceAll("\\s",""); // убираем из строки пробелы, если они есть
            if (calc.contains("+")) {
                sum(calc);
            } else if (calc.contains("-")) {
                diff(calc);
            } else if (calc.contains("*")) {
                multy(calc);
            } else if (calc.contains("/")) {
                div(calc);
            } else {
                System.out.println("There's wrong symbols");
            }
            System.out.println("One more?(y/n)");
            String answer = scan.nextLine();
            if (answer.equals("n")){
                flag = false;
            }
        }

    }
    //Метод вычисления суммы
    static void sum(String str) {
        String [] operands = str.split("\\+");

        try {
            a = Byte.parseByte(operands[0]);
            b = Byte.parseByte(operands[1]);
        } catch (NumberFormatException e) {
            a = romeToArab(operands[0]);
            b = romeToArab(operands[1]);
        }

        if (checknumbers(a,b)){
            System.out.println(a+b);
        } else {
            System.out.println("I can't calculate this");
        }

    }
    //Метод вычисления разности
    static void diff(String str) {
        String [] operands = str.split("\\-");
        try {
            a = Byte.parseByte(operands[0]);
            b = Byte.parseByte(operands[1]);
        } catch (NumberFormatException e) {
            a = romeToArab(operands[0]);
            b = romeToArab(operands[1]);
        }

        if (checknumbers(a,b)){
            System.out.println(a-b);
        } else {
            System.out.println("I can calculate just from 1 to 10");
        }
    }
    //Метод вычисления произведения
    static void multy(String str) {
        String [] operands = str.split("\\*");
        try {
            a = Byte.parseByte(operands[0]);
            b = Byte.parseByte(operands[1]);
        } catch (NumberFormatException e) {
            a = romeToArab(operands[0]);
            b = romeToArab(operands[1]);
        }

        if (checknumbers(a,b)){
            System.out.println(a*b);
        } else {
            System.out.println("I can calculate just from 1 to 10");
        }
    }
    //Метод вычисления частного
    static void div(String str) {
        String [] operands = str.split("\\/");
        try {
            a = Byte.parseByte(operands[0]);
            b = Byte.parseByte(operands[1]);
        } catch (NumberFormatException e) {
            a = romeToArab(operands[0]);
            b = romeToArab(operands[1]);
        }

        if (checknumbers(a,b)){
            System.out.println(a*b);
        } else {
            System.out.println("I can calculate just from 1 to 10");
        }
    }
    // Метод проверки соответствия чисел указанному диапазону
    static boolean checknumbers(int x, int y){
       return x <= 10 && x >= 1 && y >= 1 && y <= 10;
    }
    // Метод перевода римских цифр в арабские
    static byte romeToArab(String s){
        byte arab = 0;
        switch (s){
            case "I":
                arab = 1;
                break;
            case "II":
                arab = 2;
                break;
            case "III":
                arab = 3;
                break;
            case "IV":
                arab = 4;
                break;
            case "V":
                arab = 5;
                break;
            case "VI":
                arab = 6;
                break;
            case "VII":
                arab = 7;
                break;
            case "VIII":
                arab = 8;
                break;
            case "IX":
                arab = 9;
                break;
            case "X":
                arab = 10;
                break;
            default:
                System.out.println("One of numbers is not rome num");
                break;
        }
        return arab;
    }

}
