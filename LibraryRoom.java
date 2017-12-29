/**The LibraryRoom class is derived from ReservableItem and includes instance
variables for a room's room number, capacity, and whether or not the room has a
computer. It adds no additional functional methods.*/
public class LibraryRoom extends ReservableItem {
  private int roomNumber;
  private int capacity;
  private boolean hasComputer;

  public LibraryRoom(){ //empty constructor
    super();
    roomNumber = 0;
    capacity = 0;
    hasComputer = false;
  }

  public LibraryRoom(int rn, int c, boolean comp, int bc){ //preferred constructor
    super(bc);
    roomNumber = rn;
    capacity = c;
    hasComputer = comp;
  }

  public LibraryRoom(LibraryRoom lr){ //copy constructor
    super();
    roomNumber = lr.getRoomNumber();
    capacity = lr.getCapacity();
    hasComputer = lr.hasComputer();
  }

  //getters and setters
  public void setRoomNumber(int rn)
  { roomNumber = rn;}
  public void setCapacity(int c)
  { capacity = c;}
  public void setComputer(boolean hc)
  { hasComputer = hc;}
  public int getRoomNumber()
  { return roomNumber;}
  public int getCapacity()
  { return capacity;}
  public boolean hasComputer()
  { return hasComputer;}

  public boolean equals (LibraryRoom other){
    return (roomNumber == other.getRoomNumber() && capacity == other.getCapacity()
    && hasComputer == other.hasComputer());
  }

  /**The toString method prints all instance variables and the information from
  the parent class*/
  public String toString(){
    return "Room Number: "+roomNumber+"\nCapacity: "+capacity+
    "\nComputer Available: "+hasComputer + "\n"+super.toString();
  }
}
