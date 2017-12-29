import java.util.GregorianCalendar;
import java.io.Serializable;

public class ReservableItem implements Serializable {
  private int barcode;
  private GregorianCalendar checkOutDate;
  private GregorianCalendar returnDate;
  private boolean available;
  private Student reservedTo;

  public ReservableItem () { //empty constructor
    barcode = 0;
    checkOutDate = null;
    returnDate = null;
    available = true;
    reservedTo = null;
  }

  public ReservableItem (int bc){ //preferred constructor
    barcode = bc;
    checkOutDate = null;
    returnDate = null;
    available = true;
    reservedTo = null;
  }

/**Pre-requisite: student does not have an item reserved already*/
  public void checkOut (GregorianCalendar today, Student theStudent) {
    if (theStudent.getReserved() == null)
    {
      checkOutDate = today;
      available = false;
      reservedTo = theStudent;
      theStudent.setReserved(this);
    }
    else
      System.out.println("Error: Student already has item checked out.");
  }

  public void returnItem (GregorianCalendar today, Student theStudent) {
    returnDate = today;
    available = true;
    reservedTo = null;
    theStudent.setReserved(null);
  }

//getters and setters
  public boolean isAvailable()
  { return(available);}
  public int getBarcode()
  { return barcode;}
  public Student getStudent()
  { return reservedTo;}

  public String toString() {
    if (available)
    {
      return "Barcode: "+barcode+"\nAvailable: "+available;
    }
    else
    {
      return "Barcode: "+barcode+"\nAvailable: "+available+"\nReserved to: "+
      reservedTo.getFName()+" "+reservedTo.getLName();
    }
  }

}
