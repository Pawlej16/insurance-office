import java.util.ArrayList;

public class InsuranceOffice {

    private String officeName;
    private ArrayList<Policy> policies;

    public InsuranceOffice(String officeName) {
        if (officeName == null || officeName.isEmpty()) {
            throw new IllegalArgumentException("Office name cannot be empty!");
        }
        this.officeName = officeName;
        this.policies = new ArrayList<>();
    }

    public String getOfficeName() {
        return officeName;
    }

    public int getPolicyCount() {
        return policies.size();
    }

    public void addPolicy(Policy policy) {
        if (policy == null) {
            throw new IllegalArgumentException("Cannot add null policy!");
        }
        policies.add(policy);
    }

    public boolean removePolicy(String policyNumber) {
        return policies.removeIf(p -> p.getPolicyNumber().equals(policyNumber));
    }

    public Policy findPolicy(String policyNumber) {
        for (Policy p : policies) {
            if (p.getPolicyNumber().equals(policyNumber)) {
                return p;
            }
        }
        return null;
    }

    public double getTotalPremium() {
        double sum = 0;
        for (Policy p : policies) {
            sum += p.calculateFinalPremium();
        }
        return Math.round(sum * 100.0) / 100.0;
    }

    public double getTotalRenewalPremium() {
        double sum = 0;
        for (Policy p : policies) {
            sum += p.calculateRenewalPremium();
        }
        return Math.round(sum * 100.0) / 100.0;
    }

    public int countHighRiskPolicies() {
        int count = 0;
        for (Policy p : policies) {
            if (p.getRiskLevel() >= 4) {
                count++;
            }
        }
        return count;
    }

    public ArrayList<Policy> getPoliciesAbovePremium(double amount) {
        ArrayList<Policy> result = new ArrayList<>();
        for (Policy p : policies) {
            if (p.calculateFinalPremium() > amount) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "InsuranceOffice{" +
                "officeName='" + officeName + '\'' +
                ", policies=" + policies.size() + '}';
    }
}