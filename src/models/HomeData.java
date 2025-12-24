package models;

public class HomeData {

    public String houseType;
    public String insulation; 
    public String windows;  
    public String lighting; 
    public String cooling;   
    public String heating;   
    public int applianceAge;
    public String ventilation; 
    public String roofType;

    public HomeData(String houseType, String insulation, String windows,
                    String lighting, String cooling, String heating,
                    int applianceAge, String ventilation, String roofType) {

        this.houseType = houseType;
        this.insulation = insulation;
        this.windows = windows;
        this.lighting = lighting;
        this.cooling = cooling;
        this.heating = heating;
        this.applianceAge = applianceAge;
        this.ventilation = ventilation;
        this.roofType = roofType;
    }
}