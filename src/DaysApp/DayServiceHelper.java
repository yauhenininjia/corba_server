package DaysApp;


/**
* DaysApp/DayServiceHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Day.idl
* Saturday, November 19, 2016 2:27:58 PM MSK
*/

abstract public class DayServiceHelper
{
  private static String  _id = "IDL:DaysApp/DayService:1.0";

  public static void insert (org.omg.CORBA.Any a, DaysApp.DayService that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static DaysApp.DayService extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (DaysApp.DayServiceHelper.id (), "DayService");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static DaysApp.DayService read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_DayServiceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, DaysApp.DayService value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static DaysApp.DayService narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof DaysApp.DayService)
      return (DaysApp.DayService)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      DaysApp._DayServiceStub stub = new DaysApp._DayServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static DaysApp.DayService unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof DaysApp.DayService)
      return (DaysApp.DayService)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      DaysApp._DayServiceStub stub = new DaysApp._DayServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
