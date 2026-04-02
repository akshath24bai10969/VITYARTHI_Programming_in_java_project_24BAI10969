public class ICUWard extends Ward {
    private boolean hasVentilatorAccess;

    public ICUWard(String wardId, String wardName, int totalBeds, boolean hasVentilatorAccess) {
        super(wardId, wardName, totalBeds);
        this.hasVentilatorAccess = hasVentilatorAccess;
    }

    @Override
    public double getDailyCost() {
        return hasVentilatorAccess ? 5000.00 : 3500.00; 
    }
}