package entity;

import java.util.Objects;

public class Student {
    private int id;
    private String firstName;
    private String secoundName;
    private String patronymic;
    private int teamId;

    public Student() {
    }

    public Student(int id, String firstName, String secoundName, String patronymic, int teamId) {
        this.id = id;
        this.firstName = firstName;
        this.secoundName = secoundName;
        this.patronymic = patronymic;
        this.teamId = teamId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecoundName() {
        return secoundName;
    }

    public void setSecoundName(String secoundName) {
        this.secoundName = secoundName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (teamId != student.teamId) return false;
        if (!Objects.equals(firstName, student.firstName)) return false;
        if (!Objects.equals(secoundName, student.secoundName)) return false;
        return Objects.equals(patronymic, student.patronymic);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secoundName != null ? secoundName.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + teamId;
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secoundName='" + secoundName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", teamId='" + teamId + '\'' +
                '}';
    }
}
