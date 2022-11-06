public class Main {
    public static void main(String[] args) {
        //Задача №1
        int salary = 15000;
        int total = 0;
        int month = 0;
        while (total < 2_459_000) {
            total += salary;
            month++;
            System.out.println("Месяц: " + month + " сумма накопление равна " + total + "рублей");
        }
        //Задача №2
        int number = 1;
        while (number <= 10) {
            System.out.print(number++ + " ");
        }
        System.out.println();
        for (int i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
        //Задача №3
        int totalStrength = 12_000_000;
        int fertility = totalStrength / 1000 * 17; //204 000
        int mortality = totalStrength / 1000 * 8; // 96 000
        for (int years = 1; years <= 10; years++) {
            System.out.println("год : " + years + " численность населения составляет  = " + (totalStrength += fertility - mortality));
        }
        //Задача №4
        int depositSum = 15000;
        int month_1 = 0;
        while (depositSum <= 12_000_000) {
            depositSum += depositSum / 100 * 0.7;
            System.out.println("месяц: " + month_1++ + " сумма накоплений " + depositSum);
        }
        System.out.println("всего месяцев надо :" + month_1);
        //Задача №5
        int depositSum_1 = 15000;
        int month_2 = 0;
        while (depositSum_1 <= 12_000_000) {
            depositSum_1 += depositSum_1 / 100 * 0.7;
            month_2++;
            if (month_2 % 6 == 0) {
                System.out.println("месяц: " + month_2 + " сумма накоплений " + depositSum_1);
            }
        }
        //Задача №6
        int salaryVasilyu = 15000;
        int monthVasilyu = 9 * 12;
        for (int i = 0; i < monthVasilyu; i++) {
            salaryVasilyu += salaryVasilyu / 100 * 0.7;
            if (i % 6 == 0) {
                System.out.println("месяц: " + i + " сумма накоплений: " + salaryVasilyu);
            }
        }
        //Задача №7
        int friday = 4;
        for (int i = 1; i < 31; i++) {
            if (i % 7 == 4) {
                System.out.println(i + " friday");
            }
        }
        //Задача №8
        int comet = 79;
        int year = 2022;
        for (int i = 0; i < year + 100; i++) {
            if (i > (year - 200) || i > (year + 100))
                if (i % comet == 0) {
                    System.out.println(i);
                }
        }
        //Задача №9
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.println(2 + " * " + (i/2) +  " = " + i);
            }
        }
    }
}