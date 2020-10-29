package dima.model;

import java.util.UUID;

//Параметры студента
public class User implements Identified<UUID>{
    private static final long serialVersionUID = -7931737332645464539L;

    private UUID id;
    private int age;
    private UserStatus userStatus;
    private String username;
    private String password;
    private String email;

    public User(UUID uuid, int age, String username, String password, String email) {
        this.id = uuid;
        this.age = age;
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

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", userStatus=" + userStatus +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
