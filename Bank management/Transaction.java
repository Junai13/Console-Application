package bankapp;

public class Transaction {
    public enum Type {
        DEPOSIT,
        WITHDRAWAL
    }
    public enum Status {
        SUCCESS,
        FAILURE
    }
    private long amount;
    private Type type;
    private Status status;
    private long currentBalance;
    public Transaction(long amount, Status status, Type type, long currentBalance) {
        this.amount = amount;
        this.status = status;
        this.type = type;
        this.currentBalance = currentBalance;
    }
    public void setAmount(long amount) {
        this.amount = amount;
    }
    public long getAmount() {
        return this.amount;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public Type getType() {
        return this.type;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Status getStatus() {
        return this.status;
    }

    public void setCurrentBalance(long balance) {

        this.currentBalance = balance;
    }

    public long getCurrentBalance() {

        return this.currentBalance;
    }

}
