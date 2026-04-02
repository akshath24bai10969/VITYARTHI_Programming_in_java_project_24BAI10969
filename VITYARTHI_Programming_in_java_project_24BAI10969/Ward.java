public abstract class Ward {
    protected String wardId;
    protected String wardName;
    protected int availableBeds;

    public Ward(String wardId, String wardName, int totalBeds) {
        this.wardId = wardId;
        this.wardName = wardName;
        this.availableBeds = totalBeds;
    }

    public String getWardId() { return wardId; }
    public String getWardName() { return wardName; }
    public int getAvailableBeds() { return availableBeds; }

    public abstract double getDailyCost();

    public boolean allocateBed() {
        if (availableBeds > 0) {
            availableBeds--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return wardName + " (ID: " + wardId + ") | Beds Available: " + availableBeds + " | Cost/Day: $" + getDailyCost();
    }
}