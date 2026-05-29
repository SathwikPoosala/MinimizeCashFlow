# Minimize Cash Flow

## Overview

This project solves the **Minimize Cash Flow** problem.

When multiple people lend and borrow money from each other, the resulting transactions can become complicated. Instead of settling every transaction individually, this solution calculates the net amount each person owes or should receive and generates a simplified set of transactions.

The goal is to settle all debts with the minimum possible number of money transfers.

---

## Problem Example

### Original Transactions

```text
Tom -> Jerry : 1000
Jerry -> Spike : 1000
Spike -> Tom : 500
```

### Net Balances

```text
Tom   : -500
Jerry : 0
Spike : +500
```

Instead of performing all three transactions, we can directly settle the debt:

```text
Tom -> Spike : 500
```

This reduces unnecessary intermediate payments.

---

## Logic Used

The main idea is to calculate the **net balance** of every person.

* If a person's balance is negative, they need to pay money.
* If a person's balance is positive, they need to receive money.
* If the balance is zero, they are already settled.

After finding the balances, debtors and creditors are matched directly until everyone's balance becomes zero.

This removes unnecessary transactions and simplifies the settlement process.

---

## Algorithm Flow

### Step 1: Calculate Net Balance

For every transaction:

```text
payer balance -= amount
receiver balance += amount
```

Example:

```text
Tom pays Jerry 1000

Tom    = -1000
Jerry  = +1000
```

After processing all transactions, we know exactly who owes money and who should receive money.

---

### Step 2: Separate People

Create two lists:

**Debtors**

```text
People with negative balance
```

**Creditors**

```text
People with positive balance
```

Example:

```text
Debtors:
Tom -> 500

Creditors:
Spike -> 500
```

---

### Step 3: Settle Debts

Use two pointers:

* One points to the current debtor.
* One points to the current creditor.

Transfer:

```text
min(debt, credit)
```

Update both balances and continue until all balances become zero.

---

## Dry Run

### Input

```text
Alice -> Bob : 4000
Bob -> Charlie : 2000
Charlie -> David : 1000
David -> Alice : 500
```

### Net Balances

```text
Alice   = -3500
Bob     = +2000
Charlie = +1000
David   = +500
```

### Optimized Settlement

```text
Alice -> Bob : 2000
Alice -> Charlie : 1000
Alice -> David : 500
```

All balances become zero.

---

## Time Complexity

### Balance Calculation

```text
O(N)
```

where N is the number of transactions.

### Debt Settlement

```text
O(P + C)
```

where:

* P = Number of debtors
* C = Number of creditors

### Overall Complexity

```text
O(N)
```

---

## Space Complexity

```text
O(M)
```

where M is the number of unique people involved in transactions.

---

## Data Structures Used

* HashMap
* ArrayList
* Greedy Approach
* Two Pointer Technique

---

## Conclusion

This solution simplifies a complex network of debts by converting all transactions into net balances and directly matching debtors with creditors. The approach is efficient, easy to understand, and minimizes unnecessary money transfers.
