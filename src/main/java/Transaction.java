import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Utils.DateConverter.DATE_FORMAT;
import static org.apache.commons.lang3.StringUtils.rightPad;

public class Transaction {

    private static final String EMPTY_VALUE = "          ";

    private SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    private Amount value;
    private Date date;


    public Transaction(Amount value, Date date) {
        this.value = value;
        this.date = date;
    }

    //Metodo que devolvera el nuevo valor
    public Amount balanceAfterTransaction(Amount currentBalance) {
        return currentBalance.addTheValue(value);
    }

    //Metodo para imprimir
    public void printTo(PrintStream printer, Amount currentBalance) {
        StringBuilder builder = new StringBuilder();
        addDateTo(builder);
        addValueTo(builder);
        addCurrentBalanceTo(builder, currentBalance);
        printer.println(builder);
    }
    private void addCurrentBalanceTo(StringBuilder builder, Amount currentBalance) {
        builder.append("| ")
                .append(currentBalance.moneyRepresentation());
    }

    private void addValueTo(StringBuilder builder) {
        if (value.isGreaterThan(Amount.amountOf(0))) {
            addCreditTo(builder);
            return;
        }
        addDebitTo(builder);
    }

    private void addDebitTo(StringBuilder builder) {
        builder.append(EMPTY_VALUE)
                .append("|")
                .append(valueToString());
    }

    private void addCreditTo(StringBuilder builder) {
        builder.append(valueToString())
                .append("|")
                .append(EMPTY_VALUE);
    }

    private String valueToString() {
        String stringValue = " " + value.absoluteValue().moneyRepresentation();
        return rightPad(stringValue, 10);
    }

    private void addDateTo(StringBuilder builder) {
        builder.append(sdf.format(date));
        builder.append(" |");
    }

}
