package Models;

import java.io.Serializable;
import java.util.Comparator;

public abstract class Services implements Serializable, Comparable<Services> {
    protected String id;
    protected String ServiceType;
    protected double usageArea;
    protected double rentCost;
    protected int guestAmount;
    protected String rentType;
    public abstract String showInfo();

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
