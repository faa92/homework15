package by.tms.antonfedoseev.homework;

import java.time.LocalDate;

public class BlrPassport {
    public static final int LENGTH_ID_NUMBER_BLR = 14;
    public static final int LENGTH_PASSPORT_NUMBER = 9;
    private final String lastName;
    private final String name;
    private final Gender gender;
    private final LocalDate dateOfBirth;
    private final String passportNumber;
    private final String identificationNumber;
    private final LocalDate dateOfIssue;
    private final LocalDate dateOfExpiry;

    public BlrPassport(String lastName, String name, Gender gender, LocalDate dateOfBirth, String passportNumber,
                       String identificationNumber, LocalDate dateOfIssue, LocalDate dateOfExpiry) {
        if (isValidPassport(lastName, name, passportNumber, identificationNumber, dateOfIssue, dateOfExpiry)) {
            this.lastName = lastName;
            this.name = name;
            this.gender = gender;
            this.dateOfBirth = dateOfBirth;
            this.passportNumber = passportNumber;
            this.identificationNumber = identificationNumber;
            this.dateOfIssue = dateOfIssue;
            this.dateOfExpiry = dateOfExpiry;
        } else {
            throw new IllegalArgumentException("Invalid information");
        }
    }
    public boolean isValidPassport(String lastName, String name, String passportNumber,
                                   String identificationNumber, LocalDate dateOfIssue, LocalDate dateOfExpiry) {
        return isValidNameAndLastName(name, lastName) && isValidPassNumber(passportNumber) &&
                isValidDataUse(dateOfIssue, dateOfExpiry) && isValidIDNumber(identificationNumber);

    }

    public boolean isValidPassNumber(String passportNumber) {
        if (passportNumber.length() != LENGTH_PASSPORT_NUMBER) {
            throw new IllegalArgumentException("Invalid passport number");
        }
        return passportNumber.matches("(AB|BM|HB|KH|MP|MC|KB|PP|SP|DP)\\d{7}");
    }
    public boolean isValidIDNumber(String identificationNumber) {
        if (identificationNumber.length() != LENGTH_ID_NUMBER_BLR) {
            throw new IllegalArgumentException("Invalid ID number");
        }
        return identificationNumber.matches("\\d{7}[ABCKEMH]\\d{3}(PB|BA|BI)\\d");
    }
    public boolean isValidNameAndLastName(String name, String lastName) {
        return name.matches("[a-zA-Z]") && lastName.matches("[a-zA-Z]");
    }
    public boolean isValidDataUse(LocalDate dateOfIssue, LocalDate dateOfExpiry) {
        return (dateOfIssue.isBefore(dateOfExpiry));
    }
    public boolean isExpired(LocalDate now) {
        return now.isAfter(dateOfExpiry);
    }
    public String toString() {
        return "Belarusian Passport: \n" +
                "Last name - " + lastName + "\n" +
                "Name - " + name + "\n" +
                "Gender - " + gender + "\n" +
                "Date of berth - " + dateOfBirth + "\n" +
                "Passport number - " + passportNumber + "\n" +
                "Identification number - " + identificationNumber + "\n" +
                "Date of issue - " + dateOfIssue + "\n" +
                "Date of expiry - " + dateOfExpiry;
    }
}


