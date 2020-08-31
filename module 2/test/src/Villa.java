public class Villa extends Services {
    public static int numVilla = 0;
    private int numVilaTemp;
    private  String villaId;
    private double poolArea;
    private int numFloor;

    public String getVillaId() {
        return villaId;
    }

    public int getNumVilaTemp() {
        return numVilaTemp;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public int getNumFloor() {
        return numFloor;
    }

    public Villa(String villaId, String serviceName, double usesArea, double rentCost, int maxPeople, int rentHour, int rentDay, int rentMonth, int rentYear, double poolArea, int numFloor) {
        super(serviceName, usesArea, rentCost, maxPeople, rentHour, rentDay, rentMonth, rentYear);
        this.poolArea = poolArea;
        this.numFloor = numFloor;
        this.numVilaTemp = ++numVilla;
        this.villaId = villaId;
    }

    @Override
    public String showInfor() {
        return "Villa ID: SVVL-" + villaId + "\n" +
                "Name: " + serviceName + "\n" +
                "Area: " + usesArea + "\n" +
                "Renting cost: " + rentCost + "\n" +
                "Maximun People: " + maxPeople + "\n" +
                "Type of Renting: " + rentHour + "(h) " + rentDay + "(days) " + rentMonth + "(months) " + rentYear + "(years)\n" +
                "Pool's Area" + poolArea + "\n" +
                "Amount of Floor: " + numFloor;
    }
}