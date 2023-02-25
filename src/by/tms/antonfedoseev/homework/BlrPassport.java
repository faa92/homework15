package by.tms.antonfedoseev.homework;

public class BlrPassport {
    private String lastName;
    private String name;
    private String sex;
    private String dateOfBirth;
    private String passportNumber;
    private String identificationNumber;
    private String dateOfIssue;
    private String dateOfExpiry;

    public BlrPassport(String lastName, String name, String sex, String dateOfBirth,
                       String passportNumber, String identificationNumber, String dateOfIssue, String dateOfExpiry) {
        this.lastName = lastName;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.passportNumber = passportNumber;
        this.identificationNumber = identificationNumber;
        this.dateOfIssue = dateOfIssue;
        this.dateOfExpiry = dateOfExpiry;
    }


}


