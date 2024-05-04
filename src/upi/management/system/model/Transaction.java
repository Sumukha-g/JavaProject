package upi.management.system.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private String upiid;
    private String accountNumber;
    private String transactionType;
    private String receiverIdentifier;
    private BigDecimal amount;
    private LocalDateTime transactionDate;

    public Transaction(String upiid, String accountNumber, String transactionType, String receiverIdentifier, BigDecimal amount, LocalDateTime transactionDate) {
        this.upiid = upiid;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.receiverIdentifier = receiverIdentifier;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public String getUpiid() {
        return upiid;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getReceiverIdentifier() {
        return receiverIdentifier;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "upiid='" + upiid + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", receiverIdentifier='" + receiverIdentifier + '\'' +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}