package Models;

public class Villa extends Services{
    @Override
    void showInfo() {

    }
    double poolArea;
    String roomStandard;
    String otherExclusives;
    int floors;

    public Villa() {
    }

    public Villa(String id, String serviceType, double usageArea, double rentCost, int guestAmount, String rentType, double poolArea, String roomStandard, String otherExclusives, int floors) {
        super(id, serviceType, usageArea, rentCost, guestAmount, rentType);
        this.poolArea = poolArea;
        this.roomStandard = roomStandard;
        this.otherExclusives = otherExclusives;
        this.floors = floors;
    }

    public Villa(double poolArea, String roomStandard, String otherExclusives, int floors) {
        this.poolArea = poolArea;
        this.roomStandard = roomStandard;
        this.otherExclusives = otherExclusives;
        this.floors = floors;
    }
    
}
