import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class Statement {

    public static final String HEADER = "   date    |  credit  |  debit   | balance";

    private final List<StatementLine> statementLines = new LinkedList<>();

    public void addLineContaining(Transaction transaction, Amount currentBalance) {
        statementLines.add(0, new StatementLine(transaction, currentBalance));
    }

    public void printTo(PrintStream printer) {
        printer.println(HEADER);
        printStatementLines(printer);
    }

    private void printStatementLines(PrintStream printer) {
        for (StatementLine statementLine : statementLines) {
            statementLine.printTo(printer);
        }
    }

}
