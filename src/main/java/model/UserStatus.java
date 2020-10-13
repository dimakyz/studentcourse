package model;

public enum UserStatus {

    STATUS_CREATED("Зачислен"),
    STATUS_LOCKED("Отчислен"),
    STATUS_ACTIVED("Обучается");

    private String description;

    UserStatus(String description) {
        this.description = description;
    }

    public String getDescription() {return description;}

}
