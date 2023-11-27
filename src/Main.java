import java.time.Year;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
    public static void test1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите год: ");
        int year = sc.nextInt();
        printIsleapYear(year);
    }
    public static void printIsleapYear(int year) {
        if (isLeap(year)) {
            System.out.println(year + " год является високосным!");
        } else {
            System.out.println(year + " год не является високосным!");
        }
    }
    static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
    public static void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите год и операционную систему iOS или Android: ");
        String clientString = sc.nextLine();
        int splitIndex = 0;
        for (int i = 0; i < clientString.length(); i++) {
            if (!Character.isDigit(clientString.charAt(i))) {
                splitIndex = i;
                break;
            }
        }
        String operApp = clientString.substring(splitIndex);
        int yearApp = Integer.parseInt(clientString.substring(0, splitIndex));
        printRecommendedAppVersion(operApp, yearApp);
    }
    public static void printRecommendedAppVersion(String operApp, int yearApp) {
        String iosOper = "iOS";
        String androidOper = "Android";
        String message = "";
        if (operApp.equalsIgnoreCase(iosOper)) {
            if (isDeviceOld(yearApp)) {
                message = "Установите облегченную версию для iOS по ссылке:  https://iOSmini.com";
            } else if (isDeviceNew(yearApp)) {
                message = "Установите полную версию для iOS по ссылке:  https://iOS.com";
            } else {
                message = "Еще не вышло подходящая версия ";
            }
        } else if (operApp.equalsIgnoreCase(androidOper)) {
            if (isDeviceOld(yearApp)) {
                message = "Установите облегченную версию для Android по ссылке: https://miniAndroid.com";
            } else if (isDeviceNew(yearApp)) {
                message = "Установите полную версию для Android по ссылке: https://Android.com";
            } else {
                message = "Еще не вышло подходящая версия ";
            }
        }
        if (!message.isEmpty()) {
            System.out.println(message);
        } else {
            System.out.println("Ошибка! Введите в правельном формате и слитно как в примере");
        }
    }
    static boolean isDeviceOld(int yearApp) {
        int currentYear = Year.now().getValue();
        return yearApp < currentYear;
    }
    static boolean isDeviceNew(int yearApp) {
        int currentYear = Year.now().getValue();
        return yearApp == currentYear;
    }
    public static void test3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите расстояние от нас до точки доставки в км: ");
        int deliveryDistance = sc.nextByte();
        printDeleveriDay(deliveryDistance);
    }
    public static void printDeleveriDay(int deliveryDistance) {
        if (deliveryDistance <= 100) {
            System.out.println("На росстояние - " + deliveryDistance + "км Доставка займет - " + calculateDeleveriDay(deliveryDistance));
        } else {
            System.out.println("На расстояние с выше 100 км доставки нет");
        }
    }
    public static int calculateDeleveriDay(int deliveryDistance) {
        int day = 1;
        if (deliveryDistance > 20) {
            day++;
        }
        if (deliveryDistance > 60) {
            day++;
        }
        return day;
    }
}





