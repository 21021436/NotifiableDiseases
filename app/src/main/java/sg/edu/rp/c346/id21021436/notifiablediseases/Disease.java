package sg.edu.rp.c346.id21021436.notifiablediseases;

public class Disease {
    private String diseaseName;
    private int number;

    public Disease(String diseaseName, int number) {
        this.diseaseName = diseaseName;
        this.number = number;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Disease: " + diseaseName + "\n" +
                "Number: " + number;
    }
}
