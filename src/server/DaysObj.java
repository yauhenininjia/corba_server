package server;

import DaysApp.*;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by ninjia on 19.11.16.
 */
public class DaysObj extends DayServicePOA {
    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    // implement add() method
    public int add(String firstDate, String lastDate) {
        int daysCount = 0;

        try {
            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");
            DateTime start = formatter.parseDateTime(firstDate);
            DateTime finish = formatter.parseDateTime(lastDate);
            daysCount = Days.daysBetween(start, finish).getDays();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        return daysCount;
    }

    // implement shutdown() method
    public void shutdown() {
        orb.shutdown(false);
    }
}
