package DaysApp;

/**
* DaysApp/DayServiceHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Day.idl
* Saturday, November 19, 2016 2:27:58 PM MSK
*/

public final class DayServiceHolder implements org.omg.CORBA.portable.Streamable
{
  public DaysApp.DayService value = null;

  public DayServiceHolder ()
  {
  }

  public DayServiceHolder (DaysApp.DayService initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DaysApp.DayServiceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DaysApp.DayServiceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DaysApp.DayServiceHelper.type ();
  }

}