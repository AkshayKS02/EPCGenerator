package models;

public class HomeData {

    public String houseType;
    public String wallType;
    public String windows;
    public String lighting;
    public String cooling;
    public String heating;
    public int applianceAge;
    public String ventilationSystem;
    public String roofType;

    public HomeData(String houseType, String wallType, String windows,
                    String lighting, String cooling, String heating,
                    int applianceAge, String ventilationSystem, String roofType) {

        this.houseType = houseType;
        this.wallType = wallType;
        this.windows = windows;
        this.lighting = lighting;
        this.cooling = cooling;
        this.heating = heating;
        this.applianceAge = applianceAge;
        this.ventilationSystem = ventilationSystem;
        this.roofType = roofType;
    }
}
