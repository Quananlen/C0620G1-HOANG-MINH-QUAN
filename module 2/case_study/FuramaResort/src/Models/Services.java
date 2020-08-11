package Models;

public abstract class Services {
    private String id;
    private String ServiceType;
    private double usageArea;
    private double rentCost;
    private int guestAmount;
    private String rentType;
    abstract void showInfo();

    public Services(String id, String serviceType, double usageArea, double rentCost, int guestAmount, String rentType) {
        this.id = id;
        ServiceType = serviceType;
        this.usageArea = usageArea;
        this.rentCost = rentCost;
        this.guestAmount = guestAmount;
        this.rentType = rentType;
    }

    public Services() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    public double getUsageArea() {
        return usageArea;
    }

    public void setUsageArea(double usageArea) {
        this.usageArea = usageArea;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public int getGuestAmount() {
        return guestAmount;
    }

    public void setGuestAmount(int guestAmount) {
        this.guestAmount = guestAmount;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }
}
