package by.tms.antonfedoseev.homework;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class homework15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your last name: ");
        String userLastName = scanner.nextLine();

        System.out.println("Enter yor name: ");
        String userName = scanner.nextLine();

        System.out.println("Enter your sex: ");
        String userSex = scanner.nextLine();

        System.out.println("Enter your date of berth: ");
        LocalDate userDateOfBerth = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.println("Enter passport number: ");
        String userPassportNumber = scanner.nextLine();

        System.out.println("Enter identification number: ");
        String userIdentificationNumber = scanner.nextLine();

        System.out.println("Enter date of issue: ");
        LocalDate userDateOfIssue = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.println("Enter date of expiry: ");
        LocalDate userDateOfExpiry = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));


        BlrPassport blrPassport = new BlrPassport(userLastName,userName,userSex,userDateOfBerth,userPassportNumber,
                userIdentificationNumber,userDateOfIssue,userDateOfExpiry);
        System.out.println(blrPassport);
        System.out.println("Passport expiry :" + blrPassport.isExpired(LocalDate.now(ZoneId.of("Europe/Minsk"))));



    }
}
