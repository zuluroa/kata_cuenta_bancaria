package Utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    public static final String DATE_FORMAT = "dd/MM/yyyy";

    public static Date date(String dateString){
        SimpleDateFormat formato = new SimpleDateFormat(DATE_FORMAT);
        Date fecha = null;
        try {
            fecha = formato.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fecha;
    }

}
