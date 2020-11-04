package dima.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

//Параметры курса
public class Course implements Identified<Long> {

    //Уникальный Id Куоса
    private Long id;
    //Дата создания курса
    private LocalDateTime createdAt;
    //Дата обновления курса
    private LocalDateTime updatedAt;
    //Дата завершения курса
    private LocalDateTime endTime;
    //Статус курса
    private CourseStatus courseStatus;
    //Название курса
    private String courseName;
    //Список студентов на курсе
    private Set<User> users;

    public Course() {
        this.users = new HashSet<>();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public CourseStatus getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(CourseStatus courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public LocalDateTime getEndTime() {return endTime;}

    public void setEndTime(LocalDateTime endTime) {this.endTime = endTime;}

    @Override
    public String toString() {
        return new StringBuilder().append("Course{").append("id=").append(id).append(", createdAt=").append(createdAt).append(", updatedAt=").append(updatedAt).append(", endTime=").append(endTime).append(", courseStatus=").append(courseStatus).append(", courseName='").append(courseName).append('\'').append(", users=").append(users).append('}').toString();
    }
}
