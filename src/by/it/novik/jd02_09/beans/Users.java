package by.it.novik.jd02_09.beans;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * Created by Kate Novik.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Users", propOrder = {
        "user"
})
public class Users {
    @XmlElement(name="User")
    private ArrayList<User> user = new ArrayList<>();

    public Users() {
        super();
    }

    public ArrayList<User> getListUser() {
        return user;
    }

    public void setListUser(ArrayList<User> listUser) {
        this.user = listUser;
    }

    /**
     * Добавить User в список listUser
     * @param user Объект User
     */
    public void addUser (User user) {this.user.add(user);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        return user != null ? user.equals(users.user) : users.user == null;

    }

    @Override
    public int hashCode() {
        return user != null ? user.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Users{" +
                "listUser=" + user +
                '}';
    }
}
