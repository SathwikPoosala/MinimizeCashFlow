# Minimize Cash Flow

This project solves the Minimize Cash Flow problem.

When a group of people make payments on behalf of each other, a large number of transactions can be created. Instead of settling every transaction individually, this solution calculates the net balance of each person and generates a simplified set of transactions that settles all debts.

## My Approach

I first calculate the net balance of every person involved in the transactions.

* If a person's balance is negative, they need to pay money.
* If a person's balance is positive, they need to receive money.
* If the balance is zero, they are already settled.

After finding these balances, I separate people into two groups:

1. Debtors (people who need to pay)
2. Creditors (people who need to receive)

Using a greedy approach, I continuously match a debtor with a creditor and settle the maximum possible amount between them. This process continues until all balances become zero.

## Algorithm Flow

1. Traverse all transactions and calculate net balances.
2. Store people with negative balances as debtors.
3. Store people with positive balances as creditors.
4. Match debtors and creditors one by one.
5. Transfer the minimum possible amount between them.
6. Update balances and continue until everyone is settled.

## Data Structures Used

* HashMap for storing net balances
* ArrayList for storing debtors and creditors

## Complexity

Time Complexity: O(N)

Space Complexity: O(M)

Where:

* N = Number of transactions
* M = Number of unique people

## Learning Outcome

This problem helped me understand how real-world debt settlement can be optimized using net balances and greedy matching. It was also a good exercise in working with HashMaps and designing an efficient settlement algorithm.

## Author

Sathwik Poosala
