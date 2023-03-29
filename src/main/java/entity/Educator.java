package entity;

import java.util.Objects;

public class Educator {

    private int id;
    private String firstName;
    private String secoundName;
    private String patronymic;
    private int directionId;

    public Educator() {
    }

    public Educator(int id, String firstName, String secoundName, String patronymic, int directionId) {
        this.id = id;
        this.firstName = firstName;
        this.secoundName = secoundName;
        this.patronymic = patronymic;
        this.directionId = directionId;
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

    public int getDirectionId() {
        return directionId;
    }

    public void setDirectionId(int directionId) {
        this.directionId = directionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Educator educator = (Educator) o;

        if (id != educator.id) return false;
        if (directionId != educator.directionId) return false;
        if (!Objects.equals(firstName, educator.firstName)) return false;
        if (!Objects.equals(secoundName, educator.secoundName))
            return false;
        return Objects.equals(patronymic, educator.patronymic);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secoundName != null ? secoundName.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + directionId;
        return result;
    }

    @Override
    public String toString() {
        return "Educator{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secoundName='" + secoundName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", directionId=" + directionId +
                '}';
    }
}
