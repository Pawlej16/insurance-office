public class Main {
    public static void main(String[] args) {

        InsuranceOffice office = new InsuranceOffice("Warsaw Insurance");

        Policy p1 = new Policy("P-101", "Anna Nowak", 500, 3, 70000, true, true);
        Policy p2 = new Policy("P-102", "Jan Kowalski", 400, 5, 30000, false, false);
        Policy p3 = new Policy("P-103", "Maria Zielińska", 650, 2, 45000, true, false);

        office.addPolicy(p1);
        office.addPolicy(p2);
        office.addPolicy(p3);

        System.out.println("=== Insurance Office Summary ===");
        System.out.println("Office name: " + office.getOfficeName());
        System.out.println("Number of policies: " + office.getPolicyCount());
        System.out.println("Total premium: " + office.getTotalPremium());
        System.out.println("Total renewal premium: " + office.getTotalRenewalPremium());
        System.out.println("High-risk policies: " + office.countHighRiskPolicies());

        System.out.println("\n=== Searching for policy P-102 ===");
        Policy found = office.findPolicy("P-102");
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Policy not found");
        }

        System.out.println("\n=== Policies above premium 600 ===");
        for (Policy p : office.getPoliciesAbovePremium(600)) {
            System.out.println(p);
        }

        System.out.println("\n=== Removing policy P-101 ===");
        office.removePolicy("P-101");
        System.out.println("Policies after removal: " + office.getPolicyCount());
    }
}