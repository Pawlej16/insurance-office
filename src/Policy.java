import java.util.Objects;

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

    public double calculateFinalPremium() {
        double premium = ADMINISTRATIVE_FEE + basePremium;
        int surcharge = riskLevel * 120;

        if (vehicleValue >= 60000) {
            premium += 200.0;
        }

        if (hasAlarm) {
            premium *= 0.95;
        }

        if (claimFreeClient) {
            premium *= 0.9;
        }

        if (premium < basePremium) {
            premium = basePremium;
        }

        return premium;
    }

    public double calculateRenewalPremium() {

        double current = calculateFinalPremium();
        double renewal = current;

        if (riskLevel == 4) {
            renewal *= 1.10;
        } else if (riskLevel >= 5) {
            renewal *= 1.20;
        }

        if (vehicleValue > 60000) {
            renewal += 150;
        }

        if (claimFreeClient) {
            renewal *= 0.9;
        }

        if (hasAlarm) {
            renewal *= 0.95;
        }

        double minAllowed = current * 0.90;
        if (renewal < minAllowed) {
            renewal = minAllowed;
        }

        double maxAllowed = current * 1.25;
        if (renewal > maxAllowed) {
            renewal = maxAllowed;
        }

        return Math.round(renewal * 100.0) / 100.0;
    }

    public String getRiskSummary() {
        if (riskLevel <= 2) {
            return "Low risk client";
        }
        else if (riskLevel == 3) {
            return "Medium risk client";
        }
        else if (riskLevel == 4) {
            return "High risk client";
        }
        else {
            return "Very high risk client";
        }
    }

    public static int getCreatedPolicyCount() {
        return createdPolicyCount;
    }

    public static double getAdministrativeFee() {
        return ADMINISTRATIVE_FEE;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "number='" + policyNumber + '\'' +
                ", client='" + clientName + '\'' +
                ", finalPremium=" + calculateFinalPremium() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

}