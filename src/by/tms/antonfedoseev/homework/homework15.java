package by.tms.antonfedoseev.homework;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class homework15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Choose task:
                1. Passport
                2. Black list
                0. Exit
                """);
        int task = scanner.nextInt();
        switch (task) {
            case 1 -> {
                System.out.println("Enter your last name: ");
                String userLastName = scanner.nextLine();

                System.out.println("Enter yor name: ");
                String userName = scanner.nextLine();

                System.out.println("Enter your gender (Man or Woman): ");
                String userGender = scanner.nextLine();

                System.out.println("Enter your date of berth (00.00.0000): ");
                LocalDate userDateOfBerth = LocalDate.parse(scanner.nextLine(),
                        DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                System.out.println("Enter passport number: ");
                String userPassportNumber = scanner.nextLine();

                System.out.println("Enter identification number: ");
                String userIdentificationNumber = scanner.nextLine();

                System.out.println("Enter date of issue (00.00.0000): ");
                LocalDate userDateOfIssue = LocalDate.parse(scanner.nextLine(),
                        DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                System.out.println("Enter date of expiry (00.00.0000): ");
                LocalDate userDateOfExpiry = LocalDate.parse(scanner.nextLine(),
                        DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                BlrPassport blrPassport = new BlrPassport(userLastName, userName, userGender, userDateOfBerth,
                        userPassportNumber, userIdentificationNumber, userDateOfIssue, userDateOfExpiry);

                System.out.println(blrPassport);
                System.out.println("Passport expiry :" +
                        blrPassport.isExpired(LocalDate.now(ZoneId.of("Europe/Minsk"))));
            }
            case 2 -> {
                System.out.println("Enter bad words separated by comma");
                String userBadWords = scanner.nextLine();
                String[] inputArrBadWords = userBadWords.split(", ");

                TextBlackListFilter filter = new TextBlackListFilter(inputArrBadWords);
                System.out.println();
            }
            case 0 -> {
                return;
            }

        }
    }
}
