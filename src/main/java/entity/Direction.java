package entity;

public class Direction {
    private int id;
    private String departmen;
    private String specialization;

    public Direction() {
    }
    public Direction(int id, String departmen, String specialization) {
        this.id = id;
        this.departmen = departmen;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmen() {
        return departmen;
    }

    public void setDepartmen(String departmen) {
        this.departmen = departmen;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
