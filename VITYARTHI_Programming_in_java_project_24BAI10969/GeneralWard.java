public class GeneralWard extends Ward {
    public GeneralWard(String wardId, String wardName, int totalBeds) {
        super(wardId, wardName, totalBeds);
    }

    @Override
    public double getDailyCost() {
        return 800.00; 
    }
}