package lv.ctco.notepad;

public class Person extends Record {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String askGender() {
        return gender;
    }

    public void askGender(String phone) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        return firstName.contains(str)
                || lastName.contains(str)
                || phone.contains(str)
                || email.contains(str)
                ||gender.contains(str);

    }

    @Override
    public void askData() {
        firstName = Main.askString("First Name");
        lastName = Main.askString("Last Name");
        phone = Main.askString("Phone");
        email = Main.askString("Email");
        gender = Main.askString("Gender");

    }


}
