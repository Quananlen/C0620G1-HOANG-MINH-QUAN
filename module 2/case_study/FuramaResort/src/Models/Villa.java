package Models;

public class Villa extends Services{
    private double poolArea;
    private String roomStandard;
    private String otherExclusives;
    private int floors;

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

    @Override
    public String showInfo() {
        return "Villa{" +
                "poolArea=" + poolArea +
                ", roomStandard='" + roomStandard + '\'' +
                ", otherExclusives='" + otherExclusives + '\'' +
                ", floors=" + floors +
                ", id='" + id + '\'' +
                ", ServiceType='" + ServiceType + '\'' +
                ", usageArea=" + usageArea +
                ", rentCost=" + rentCost +
                ", guestAmount=" + guestAmount +
                ", rentType='" + rentType + '\'' +
                '}';
    }
}
