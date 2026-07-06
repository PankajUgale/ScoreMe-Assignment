import java.util.*;

public class Task1 {

    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {

        // FIX: Initialize result list to avoid NullPointerException
        List<LoanAccount> result = new ArrayList<>();

        // FIX: Handle null input list safely
        if (accounts == null) {
            return result;
        }

        // FIX: Use epsilon for double comparison instead of direct comparison with 0
        final double EPSILON = 0.000001;

        for (LoanAccount account : accounts) {

            // FIX: dueDate may be null for restructured accounts
            if (account.getDueDate() != null &&
                account.getDueDate().before(new Date())) {

                // FIX: Avoid direct comparison with 0 for double values
                if (account.getOutstandingBalance() > EPSILON) {
                    result.add(account);
                }
            }
        }
        return result;
    }
}
