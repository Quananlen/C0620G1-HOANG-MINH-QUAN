package model;

public class Service {
    private String id;
    private String name;
    private String area;
    private String floor;
    private String maxAmount;
    private String rentCost;
    private String serviceTypeId;
    private String rentTypeID;
    private String status;

    public Service(String id, String name, String area, String floor, String maxAmount, String rentCost, String serviceTypeId, String rentTypeID, String status) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.floor = floor;
        this.maxAmount = maxAmount;
        this.rentCost = rentCost;
        this.serviceTypeId = serviceTypeId;
        this.rentTypeID = rentTypeID;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(String maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getRentCost() {
        return rentCost;
    }

    public void setRentCost(String rentCost) {
        this.rentCost = rentCost;
    }

    public String getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(String serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getRentTypeID() {
        return rentTypeID;
    }

    public void setRentTypeID(String rentTypeID) {
        this.rentTypeID = rentTypeID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
