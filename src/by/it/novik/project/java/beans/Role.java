package by.it.novik.project.java.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Kate Novik.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Role implements Serializable {

    @XmlAttribute(name="idRole",required = true)
    private int idRole;
    @XmlAttribute(name="nameRole",required = true)
    private String role;

    public Role() {
        super();
    }

    public Role(int idRole, String role) {
        this.idRole = idRole;
        this.role = role;
    }

    public Role (Role role) {
        this.idRole = role.getIdRole();
        this.role = role.getRole();
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (idRole != role1.idRole) return false;
        return role != null ? role.equals(role1.role) : role1.role == null;

    }

    @Override
    public int hashCode() {
        int result = idRole;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", role='" + role + '\'' +
                '}' + '\n';
    }
}
