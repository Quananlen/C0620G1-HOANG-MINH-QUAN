package Models;

import java.util.ArrayList;

public class House extends Services {
    public static ArrayList<House> arrHouse = new ArrayList<>();

    private String roomStandard;
    private String otherExclusives;
    private int floors;

    public House() {
    }

    public House(String id, String serviceType, double usageArea, double rentCost, int guestAmount, String rentType) {
        super(id, serviceType, usageArea, rentCost, guestAmount, rentType);
    }

    public House(String id, String serviceType, double usageArea, double rentCost, int guestAmount, String rentType, String roomStandard, String otherExclusives, int floors) {
        super(id, serviceType, usageArea, rentCost, guestAmount, rentType);
        this.roomStandard = roomStandard;
        this.otherExclusives = otherExclusives;
        this.floors = floors;
    }

    @Override
    public String showInfo() {
        return "roomStandard='" + roomStandard + '\'' +
                ", otherExclusives='" + otherExclusives + '\'' +
                ", floors=" + floors +
                ", id='" + id + '\'' +
                ", ServiceType='" + ServiceType + '\'' +
                ", usageArea=" + usageArea +
                ", rentCost=" + rentCost +
                ", guestAmount=" + guestAmount +
                ", rentType='" + rentType + '\'';
    }

    @Override
    public int compareTo(Services o) {
        return this.getId().compareTo(o.getId());
    }
}
