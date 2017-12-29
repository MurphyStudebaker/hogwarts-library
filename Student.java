import java.io.Serializable;

public class Student implements Serializable{
  private int studentID;
  private String fName;
  private String lName;
  private String email;
  private int phone;
  private ReservableItem reserved;

  public Student(){ //empty constructor
    studentID = 000000;
    fName = null;
    lName = null;
    email = null;
    phone = 0000000000;
    reserved = null;
  }

  public Student (int i, String f, String l, String e, int p) //preferred constructor
  {
    studentID = i;
    fName = f;
    lName = l;
    email = e;
    phone = p;
    reserved = null; //no student starts with something checked out
  }

//getters and setters
  public void setID (int i)
  { studentID = i;}
  public void setFName (String f)
  { fName = f;}
  public void setLName (String l)
  { lName = l;}
  public void setEmail (String e)
  { email = e;}
  public void setPhone (int p)
  { phone = p;}
  public void setReserved (ReservableItem s)
  { reserved = s;}

  public int getID()
  { return studentID;}
  public String getFName()
  { return fName;}
  public String getLName()
  { return lName;}
  public String getEmail()
  { return email;}
  public int getPhone()
  { return phone;}
  public ReservableItem getReserved()
  { return reserved;}

  public boolean equals(Student theStudent){
    return ((this.email).equals(theStudent.getEmail())); //most unique element
  }
//prints all instance variables
  public String toString()
  {
    return "Name: "+fName + " "+lName
            + "\nID: "+studentID+"\nEmail: "+email
            + "\nPhone: "+phone+"\nReserved: "+reserved;
  }
}
