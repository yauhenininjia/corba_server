package server;

/**
 * Created by ninjia on 19.11.16.
 */

import DaysApp.*;
import WeeksApp.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;

public class StartServer {
    public static void main(String args[]) {
        try{
            // create and initialize the ORB //// get reference to rootpoa &amp; activate the POAManager
            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // create servant and register it with the ORB
            DaysObj addobj = new DaysObj();
            addobj.setORB(orb);

            // get object reference from the servant
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(addobj);
            DayService href = DayServiceHelper.narrow(ref);

            org.omg.CORBA.Object objRef =  orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            NameComponent path[] = ncRef.to_name( "ABC" );
            ncRef.rebind(path, href);



            WeeksObj weeksObj = new WeeksObj();
            weeksObj.setORB(orb);

            // get object reference from the servant
            org.omg.CORBA.Object weekref = rootpoa.servant_to_reference(weeksObj);
            WeekService weekhref = WeekServiceHelper.narrow(weekref);

            org.omg.CORBA.Object weekobjRef =  orb.resolve_initial_references("NameService");
            NamingContextExt weekncRef = NamingContextExtHelper.narrow(weekobjRef);

            NameComponent weekpath[] = weekncRef.to_name( "DEF" );
            ncRef.rebind(weekpath, weekhref);

            System.out.println("Server is ready and waiting ...");

            // wait for invocations from clients
            for (;;){
                orb.run();
            }
        }

        catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("HelloServer Exiting ...");

    }
}
