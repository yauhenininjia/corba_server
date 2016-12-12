package server;

/**
 * Created by ninjia on 19.11.16.
 */

import WeeksApp.*;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Weeks;
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

public class WeeksObj extends WeekServicePOA {
    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    // implement add() method
    public int add(String firstDate, String lastDate) {
        int weeksCount = 0;

        try {
            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");
            DateTime start = formatter.parseDateTime(firstDate);
            DateTime finish = formatter.parseDateTime(lastDate);
            weeksCount = Weeks.weeksBetween(start, finish).getWeeks();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        return weeksCount;
    }

    // implement shutdown() method
    public void shutdown() {
        orb.shutdown(false);
    }
}
