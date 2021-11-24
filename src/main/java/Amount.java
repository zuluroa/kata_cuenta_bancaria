import java.text.DecimalFormat;

public class Amount {
    //Instanciamos la clase DecimalFormat para convertir a decimal nuestro valor
    private DecimalFormat decimalFormat = new DecimalFormat("#.00");

    private int value;

    public Amount(int value) {
        this.value = value;
    }
    //El metodo devolvera un objeto Amount con el valor ingresado
    public static Amount amountOf(int value) {
        return new Amount(value);
    }
    //Se crea la funcion para hacer la sumatoria del nuevo monto con el moto ya guardado en la clase
    public Amount addTheValue(Amount otherAmount) {
        return amountOf(this.value + otherAmount.value);
    }
    //Esta funcion hara la operacion de definir si es mayor que.
    public boolean isGreaterThan(Amount otherAmount) {
        return this.value > otherAmount.value;
    }

    //Agregamos formato decimal al valor
    public String moneyRepresentation() {
        return decimalFormat.format(value);
    }

    public Amount absoluteValue() {
        return amountOf(Math.abs(value));
    }

    //Se resta el valor que se obtiene
    public Amount negative() {
        return amountOf(-value);
    }

}
