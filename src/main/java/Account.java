import java.io.PrintStream;
import java.util.Date;

public class Account {

    private final Statement statement;
    private Amount balance = Amount.amountOf(0);

    public Account(Statement statement) {
        this.statement = statement;
    }

    public void deposit(Amount value, Date date) {
        registerTransaction(value, date);
    }

    public void withdrawal(Amount value, Date date) {
        registerTransaction(value.negative(), date);
    }
    //Imprime el estado con lo que enviamos al main
    public void printStatement(PrintStream printer) {
        statement.printTo(printer);
    }
    //Este es el que generara el registro de las transacciones
    private void registerTransaction(Amount value, Date date) {
        Transaction transaction = new Transaction(value, date);
        Amount balanceAfterTransaction = transaction.balanceAfterTransaction(balance);
        balance = balanceAfterTransaction;
        statement.addLineContaining(transaction, balanceAfterTransaction);
    }
}
