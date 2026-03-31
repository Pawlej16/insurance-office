public class Policy {

    private String policyNumber;
    private String clientName;
    private double basePremium;
    private int riskLevel;
    private double vehicleValue;
    private boolean hasAlarm;
    private boolean claimFreeClient;

    private static int createdPolicyCount = 0;
    private static final double ADMINISTRATIVE_FEE = 120.0;

    public Policy(String policyNumber, String clientName, double basePremium, int riskLevel, double vehicleValue, boolean hasAlarm, boolean claimFreeClient) {

        setPolicyNumber(policyNumber);
        setClientName(clientName);
        setBasePremium(basePremium);
        this.riskLevel = riskLevel;
        this.vehicleValue = vehicleValue;
        this.hasAlarm = hasAlarm;
        this.claimFreeClient = claimFreeClient;

        createdPolicyCount++;
    }

    private void setPolicyNumber(String policyNumber) {
        if (policyNumber == null || policyNumber.isEmpty()) {
            throw new IllegalArgumentException("Policy number cannot be null or empty!");
        }
        this.policyNumber = policyNumber;
    }

    private void setClientName(String clientName) {
        if (clientName == null || clientName.isEmpty()) {
            throw new IllegalArgumentException("Client name cannot be null or empty!");
        }
        this.clientName = clientName;
    }

    private void setBasePremium(double basePremium) {
        if (basePremium <= 0) {
            throw new IllegalArgumentException("Base premium must be greater than zero!");
        }
        this.basePremium = basePremium;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public double getBasePremium() {
        return basePremium;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public double getVehicleValue() {
        return vehicleValue;
    }

    public boolean hasAlarm() {
        return hasAlarm;
    }

    public boolean isClaimFreeClient() {
        return claimFreeClient;
    }

    public static int getCreatedPolicyCount() {
        return createdPolicyCount;
    }

    public static double getAdministrativeFee() {
        return ADMINISTRATIVE_FEE;
    }

    public double calculateFinalPremium(double basePremium, double ADMINISTRATIVE_FEE, int riskLevel, double vehicleValue, boolean hasAlarm, boolean claimFreeClient) {
        double premium = ADMINISTRATIVE_FEE + basePremium;
    }
}