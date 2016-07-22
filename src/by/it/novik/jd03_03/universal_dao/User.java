package by.it.novik.jd03_03.universal_dao;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Created by Kate Novik.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", propOrder = {
        "First_Name",
        "Middle_Name",
        "Last_Name",
        "Passport",
        "Address",
        "Phone",
        "Email",
        "Login",
        "Password",
        "FK_Role"
})
public class User implements Serializable {
    @XmlAttribute(name = "ID", required = true)
    private int ID;
    @XmlElement(name = "First_Name", required = true)
    private String First_Name;
    @XmlElement(name = "Middle_Name", required = true)
    private String Middle_Name;
    @XmlElement(name = "Last_Name", required = true)
    private String Last_Name;
    @XmlElement(name = "Passport", required = true)
    private String Passport;
    @XmlElement(name = "Address", required = true)
    private String Address;
    @XmlElement(name = "Phone", required = true)
    private String Phone;
    @XmlElement(name = "Email", required = true)
    private String Email;
    @XmlElement(name = "Login", required = true)
    private String Login;
    @XmlElement(name = "Password", required = true)
    private String Password;
    @XmlElement(name = "Roll", required = true)
    private int FK_Role;

    public User() {
        super();
    }

    public User(int ID, String First_Name, String Middle_Name, String Last_Name, String passport,
                String address, String phone, String login, String email, String password,
                int fk_Role) {
        this.ID = ID;
        this.First_Name = First_Name;
        this.Middle_Name = Middle_Name;
        this.Last_Name = Last_Name;
        this.Passport = passport;
        this.Phone = phone;
        this.Address = address;
        this.Email = email;
        this.Login = login;
        this.Password = password;
        this.FK_Role = fk_Role;
    }

    public User(User user) {
        this.ID = user.getID();
        this.First_Name = user.getFirst_Name();
        this.Middle_Name = user.getMiddle_Name();
        this.Last_Name = user.getLast_Name();
        this.Passport = user.getPassport();
        this.Phone = user.getPhone();
        this.Address = user.getAddress();
        this.Email = user.getEmail();
        this.Login = user.getLogin();
        this.Password = user.getPassword();
        this.FK_Role = user.getFK_Role();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.First_Name = first_Name;
    }

    public String getMiddle_Name() {
        return Middle_Name;
    }

    public void setMiddle_Name(String middle_Name) {
        this.Middle_Name = middle_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.Last_Name = last_Name;
    }

    public String getPassport() {
        return Passport;
    }

    public void setPassport(String passport) {
        this.Passport = passport;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        this.Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public int getFK_Role() {
        return FK_Role;
    }

    public void setFK_Role(int fk_Role) {
        this.FK_Role = fk_Role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (ID != user.ID) return false;
        if (FK_Role != user.FK_Role) return false;
        if (First_Name != null ? !First_Name.equals(user.First_Name) : user.First_Name != null) return false;
        if (Middle_Name != null ? !Middle_Name.equals(user.Middle_Name) : user.Middle_Name != null) return false;
        if (Last_Name != null ? !Last_Name.equals(user.Last_Name) : user.Last_Name != null) return false;
        if (Passport != null ? !Passport.equals(user.Passport) : user.Passport != null) return false;
        if (Address != null ? !Address.equals(user.Address) : user.Address != null) return false;
        if (Phone != null ? !Phone.equals(user.Phone) : user.Phone != null) return false;
        if (Email != null ? !Email.equals(user.Email) : user.Email != null) return false;
        if (Login != null ? !Login.equals(user.Login) : user.Login != null) return false;
        return Password != null ? Password.equals(user.Password) : user.Password == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (First_Name != null ? First_Name.hashCode() : 0);
        result = 31 * result + (Middle_Name != null ? Middle_Name.hashCode() : 0);
        result = 31 * result + (Last_Name != null ? Last_Name.hashCode() : 0);
        result = 31 * result + (Passport != null ? Passport.hashCode() : 0);
        result = 31 * result + (Address != null ? Address.hashCode() : 0);
        result = 31 * result + (Phone != null ? Phone.hashCode() : 0);
        result = 31 * result + (Email != null ? Email.hashCode() : 0);
        result = 31 * result + (Login != null ? Login.hashCode() : 0);
        result = 31 * result + (Password != null ? Password.hashCode() : 0);
        result = 31 * result + FK_Role;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", First_Name='" + First_Name + '\'' +
                ", Middle_Name='" + Middle_Name + '\'' +
                ", Last_Name='" + Last_Name + '\'' +
                ", Passport='" + Passport + '\'' +
                ", Address='" + Address + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                ", FK_Role=" + FK_Role +
                '}' + '\n';
    }
}
