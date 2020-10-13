package model;

public enum CourseStatus {

    STATUS_CREATED("Создан"),
    STATUS_LOCKED("Завершен"),
    STATUS_ACTIVED("Активен");

    private String description;

    CourseStatus(String description) {
        this.description = description;
    }

    public String getDescription() {return description;}
}
