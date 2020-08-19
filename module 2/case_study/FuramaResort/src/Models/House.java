package Models;

public class House extends Services {
    private String roomStandard;
    private String otherExclusives;
    private int floors;

    public House() {
    }

    public House(String id, String serviceType, double usageArea, double rentCost, int guestAmount, String rentType) {
        super(id, serviceType, usageArea, rentCost, guestAmount, rentType);
    }

    @Override
    public String showInfo() {
        return "House{" +
                "roomStandard='" + roomStandard + '\'' +
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
