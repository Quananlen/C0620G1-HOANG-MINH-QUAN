import java.io.Serializable;

public abstract class Services implements Serializable {
    public String serviceName;
    public double usesArea;
    public double rentCost;
    public int maxPeople;
    public int rentHour;
    public int rentDay;
    public int rentMonth;
    public int rentYear;

    public String getServiceName() {
        return serviceName;
    }

    public Services(String serviceName, double usesArea, double rentCost, int maxPeople, int rentHour, int rentDay, int rentMonth, int rentYear) {
        this.serviceName = serviceName;
        this.usesArea = usesArea;
        this.rentCost = rentCost;
        this.maxPeople = maxPeople;
        this.rentHour = rentHour;
        this.rentDay = rentDay;
        this.rentMonth = rentMonth;
        this.rentYear = rentYear;
    }

    public String showInfor() {
        return null;
    }
}