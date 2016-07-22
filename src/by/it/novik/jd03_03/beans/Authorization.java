package by.it.novik.jd03_03.beans;

/**
 * Created by Kate Novik.
 */
//Класс DTO
public class Authorization {
    //Логин пользователя
    private String nickname;
    //Пароль пользователя
    private String password;

    public Authorization (){}

    public String getNickname() {
        return nickname;
    }

    public Authorization(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authorization that = (Authorization) o;

        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        return password != null ? password.equals(that.password) : that.password == null;

    }

    @Override
    public int hashCode() {
        int result = nickname != null ? nickname.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Authorization{" +
                "nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
