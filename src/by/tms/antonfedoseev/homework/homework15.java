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
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Enter your last name: ");
                String userLastName = scanner2.nextLine();

                System.out.println("Enter yor name: ");
                String userName = scanner2.nextLine();

                System.out.println("Enter your gender (MAN, WOMAN, THEY): ");
                Gender userGender = Gender.valueOf(scanner2.nextLine());

                System.out.println("Enter your date of berth (00.00.0000): ");
                LocalDate userDateOfBerth = LocalDate.parse(scanner2.nextLine(),
                        DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                System.out.println("Enter passport number: ");
                String userPassportNumber = scanner2.nextLine();

                System.out.println("Enter identification number: ");
                String userIdentificationNumber = scanner2.nextLine();

                System.out.println("Enter date of issue (00.00.0000): ");
                LocalDate userDateOfIssue = LocalDate.parse(scanner2.nextLine(),
                        DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                System.out.println("Enter date of expiry (00.00.0000): ");
                LocalDate userDateOfExpiry = LocalDate.parse(scanner2.nextLine(),
                        DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                BlrPassport blrPassport = new BlrPassport(userLastName, userName, userGender, userDateOfBerth,
                        userPassportNumber, userIdentificationNumber, userDateOfIssue, userDateOfExpiry);

                System.out.println(blrPassport);
                System.out.println("Passport expiry :" +
                        blrPassport.isExpired(LocalDate.now(ZoneId.of("Europe/Minsk"))));
            }
            case 2 -> {
                System.out.println("Enter string of bad words (word, word, word, ): ");
                Scanner scanner1 = new Scanner(System.in);
                String userBW = scanner1.nextLine();
                TextBlackListFilter filter = new TextBlackListFilter(userBW);
                System.out.println("Enter string to check: ");
                String userText = scanner1.nextLine();

                System.out.println("Are there any bad words?");
                System.out.println(filter.hasBadWords(userText));

                System.out.println("How many are there?");
                System.out.println(filter.getCountBadWords(userText));

                System.out.println("String with hidden bad words: ");
                System.out.println(filter.hideBadWords(userText));
            }
            case 0 -> {
                System.exit(0);
            }
        }
    }
}
