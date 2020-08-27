package Models;

import java.util.ArrayList;

public class Room extends Services {
    public static ArrayList<Room> arrRoom = new ArrayList<>();

    private String freeService;

    public Room() {
    }

    public Room(String id, String serviceType, double usageArea, double rentCost, int guestAmount, String rentType, String freeService) {
        super(id, serviceType, usageArea, rentCost, guestAmount, rentType);
        this.freeService = freeService;
    }

    @Override
    public String showInfo() {
        return "freeService='" + freeService + '\'' +
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
