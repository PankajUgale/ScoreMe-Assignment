# Task 2 – Diagnose ConcurrentModificationException

## 1. What is the exact cause of ConcurrentModificationException in Java?

ConcurrentModificationException occurs when a collection is structurally modified while it is being iterated, and the modification is not performed through the Iterator itself. Java's fail-fast iterator detects such changes and throws this exception.

## 2. What code pattern at line 142 most likely triggered this error?

The most likely cause is modifying an ArrayList while iterating over it.

Example:

for (Transaction txn : transactions) {
    if (shouldRemove(txn)) {
        transactions.remove(txn);
    }
}

The issue is most likely caused by calling list.remove() while iterating through the same list.

## 3. Provide the minimal code change (one or two lines) that resolves this safely.

Java 8 provides a safe way to remove elements:

transactions.removeIf(this::shouldRemove);

Alternatively:

Iterator<Transaction> iterator = transactions.iterator();

while (iterator.hasNext()) {
    Transaction txn = iterator.next();

    if (shouldRemove(txn)) {
        iterator.remove();
    }
}
