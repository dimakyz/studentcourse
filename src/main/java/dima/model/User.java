package dima.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

//Параметры студента
public class User implements Identified<UUID>{
    //Уникальный Id студента
    private UUID id;
    //Дата рождения студента
    private LocalDate birthday;
    //Статус студента
    private UserStatus userStatus;
    //имя студента
    private String username;
    //Пароль студента
    private String password;
    //email студента
    private String email;

    public User(UUID uuid, LocalDate birthday, String username, String password, String email) {
        this.id = uuid;
        this.birthday = birthday;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserStatus getUserStatus() {return userStatus;}

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() { return Period.between(birthday, LocalDate.now()).getYears(); }

    public void setAge(LocalDate birthday) { this.birthday = birthday; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + getAge() +
                ", userStatus=" + userStatus +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
