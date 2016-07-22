package by.it.novik.jd02_09.beans;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Kate Novik.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", propOrder = {
        "firstName",
        "middleName",
        "lastName",
        "passport",
        "address",
        "phone",
        "email",
        "nickname",
        "password",
        "roll",
        "account"
})
public class User implements Serializable {
    @XmlAttribute(name = "idUser", required = true)
    private int idUser;
    @XmlElement(name = "First_Name", required = true)
    private String firstName;
    @XmlElement(name = "Middle_Name", required = true)
    private String middleName;
    @XmlElement(name = "Last_Name", required = true)
    private String lastName;
    @XmlElement(name = "Passport", required = true)
    private String passport;
    @XmlElement(name = "Address", required = true)
    private String address;
    @XmlElement(name = "Phone", required = true)
    private String phone;
    @XmlElement(name = "Email", required = true)
    private String email;
    @XmlElement(name = "Nickname", required = true)
    private String nickname;
    @XmlElement(name = "Password", required = true)
    private String password;
    @XmlElement(name = "Roll", required = true)
    private ArrayList<Roll> roll;
    @XmlElement(name = "Account", required = true)
    private ArrayList<Account> account;

    public User() {
        super();
    }

    public User(int idUser, String firstName, String middleName, String lastName, String passport,
                String phone, String address, String email, String nickname, String password,
                ArrayList<Roll> listRolls, ArrayList<Account> listAccounts) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.passport = passport;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.roll = listRolls;
        this.account = listAccounts;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Roll> getListRolls() {
        return roll;
    }

    public void setListRolls(ArrayList<Roll> listRolls) {
        this.roll = listRolls;
    }

    public void addRoll(Roll roll) {
        this.roll.add(roll);
    }

    public ArrayList<Account> getListAccounts() {
        return account;
    }

    public void setListAccounts(ArrayList<Account> listAccounts) {
        this.account = listAccounts;
    }

    public void addAccount(Account account) {
        this.account.add(account);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (idUser != user.idUser) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (middleName != null ? !middleName.equals(user.middleName) : user.middleName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (passport != null ? !passport.equals(user.passport) : user.passport != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (nickname != null ? !nickname.equals(user.nickname) : user.nickname != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (roll != null ? !roll.equals(user.roll) : user.roll != null) return false;
        return account != null ? account.equals(user.account) : user.account == null;

    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (roll != null ? roll.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passport='" + passport + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", listRolls=" + roll +
                ", listAccounts=" + account +
                '}' + '\n';
    }


}
