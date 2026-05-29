import java.util.*;

public class MinimizeCashFlow {

    static class PersonBalance {
        String name;
        long amount;

        PersonBalance(String name, long amount) {
            this.name = name;
            this.amount = amount;
        }
    }

    public static List<List<Object>> minimizeCashFlow(List<List<Object>> transactions) {

        Map<String, Long> balanceMap = new HashMap<>();

        // Calculate net balance
        for (List<Object> transaction : transactions) {
            String from = (String) transaction.get(0);
            String to = (String) transaction.get(1);
            long amount = ((Number) transaction.get(2)).longValue();

            balanceMap.put(from,
                    balanceMap.getOrDefault(from, 0L) - amount);

            balanceMap.put(to,
                    balanceMap.getOrDefault(to, 0L) + amount);
        }

        List<PersonBalance> debtors = new ArrayList<>();
        List<PersonBalance> creditors = new ArrayList<>();

        // Separate debtors and creditors
        for (Map.Entry<String, Long> entry : balanceMap.entrySet()) {
            long balance = entry.getValue();

            if (balance < 0) {
                debtors.add(
                        new PersonBalance(entry.getKey(), -balance));
            } else if (balance > 0) {
                creditors.add(
                        new PersonBalance(entry.getKey(), balance));
            }
        }

        List<List<Object>> result = new ArrayList<>();

        int i = 0, j = 0;

        while (i < debtors.size() && j < creditors.size()) {

            PersonBalance debtor = debtors.get(i);
            PersonBalance creditor = creditors.get(j);

            long settledAmount =
                    Math.min(debtor.amount, creditor.amount);

            result.add(Arrays.asList(
                    debtor.name,
                    creditor.name,
                    settledAmount
            ));

            debtor.amount -= settledAmount;
            creditor.amount -= settledAmount;

            if (debtor.amount == 0)
                i++;

            if (creditor.amount == 0)
                j++;
        }

        return result;
    }

    public static void main(String[] args) {

        List<List<Object>> transactions = new ArrayList<>();

        transactions.add(Arrays.asList("Tom", "Jerry", 1000));
        transactions.add(Arrays.asList("Jerry", "Spike", 1000));
        transactions.add(Arrays.asList("Spike", "Tom", 500));

        List<List<Object>> result =
                minimizeCashFlow(transactions);

        for (List<Object> t : result) {
            System.out.println(
                    t.get(0) + " pays " +
                    t.get(1) + " ₹" +
                    t.get(2)
            );
        }
    }
}