package Models;

public class Room extends Services {
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


}
