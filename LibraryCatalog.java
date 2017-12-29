import java.util.Random;
import java.util.GregorianCalendar;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**The LibraryCatalog class stores all data and hold all methods that need to
manipulate or access the data. */
public class LibraryCatalog implements Serializable {
  //Change numbers for different data storage
  private final int STUDENTS = 10;
  private final int BOOKS = 5;
  private final int MOVIES = 8;
  private final int PERIODICALS = 24;
  private final int ROOMS = 6;

  public ArrayList<Student> studentDB = new ArrayList(STUDENTS);
  public ArrayList<ReservableItem> bookDB = new ArrayList(BOOKS);
  public ArrayList<ReservableItem> movieDB = new ArrayList(MOVIES);
  public ArrayList<ReservableItem> periodicalDB = new ArrayList(PERIODICALS);
  public ArrayList<ReservableItem> roomDB = new ArrayList(ROOMS);

  private int studentID = 1; //initial value
  private int barcode = 1; //initial value
  private Random generate = new Random();
  private ObjectInputStream inputStream;

  public LibraryCatalog(){
    if(!readData()) //generates data if reading from file fails
      generateData();
  }

//creates a random date for generation
  public GregorianCalendar randomDate(){
    int randomYear = 2000 + generate.nextInt(100);
    int randomMonth = generate.nextInt(12);
    int randomDay = generate.nextInt(31);
    return new GregorianCalendar(randomYear, randomMonth, randomDay);
  }
  /**GenerateData is a method to be run at the beginning of the application
  if the user desires to run a simulation. It can be changed to fit the data needs
  of the user. In this case, it generates Hogwarts specific data.*/
  public void generateData() {
    String[] fnames = {"Harry","Ron","Hermione","Luna","Neville","Ginny",
    "Seamus","Draco","Cho","Cedric"};
    String[] lnames = {"Potter","Weasley","Granger","Lovegood","Longbottom",
  "Weasley","Finnigan","Malfoy","Chang","Diggory"};
    for (int i = 0; i < STUDENTS; ++i) //generates students
    {
      String fname = fnames[generate.nextInt(9)];
      String lname = lnames[generate.nextInt(9)]; //unique
      String email = (lname+studentID+"@hogwarts.edu"); //unique
      int phone = 713 + generate.nextInt(286);
      Student aStudent = new Student(studentID, fname, lname, email, phone);
      studentDB.add(aStudent);
      ++studentID;
    }
    Book fb = new Book("Fantastic Beasts and Where to Find Them","Newt Scamander",
    450, 1, barcode++);
    bookDB.add(0, fb);
    Book q = new Book("Quidditch Through the Ages", "Kennilworthy Whisp", 200, 2,barcode++);
    bookDB.add(1, q);
    Book hah = new Book("Hogwarts: a History", "Bathilda Bagshot", 1200, 3,barcode++);
    bookDB.add(2, hah);
    Book tbb = new Book("The Tales of Beedle the Bard", "Unknown", 60, 4,barcode++);
    bookDB.add(3, tbb);
    Book apm = new Book("Advanced Potion Making","Libatius Borage", 300, 5,barcode++);
    bookDB.add(4, apm);
    Movie ss = new Movie("Sorcerer's Stone", 2001, 120,barcode++);
    movieDB.add(0, ss);
    Movie cs = new Movie("Chamber of Secrets", 2002, 120,barcode++);
    movieDB.add(1, cs);
    Movie poa = new Movie("Prisoner of Azkaban", 2003, 150,barcode++);
    movieDB.add(2, poa);
    Movie gof = new Movie("Goblet of Fire", 2004, 200,barcode++);
    movieDB.add(3, gof);
    Movie oop = new Movie("Order of the Phoenix", 2005, 180,barcode++);
    movieDB.add(4,oop);
    Movie hbp = new Movie("Half-Blood Prince", 2006, 210,barcode++);
    movieDB.add(5,hbp);
    Movie dh1 = new Movie("Deathly Hallows: Part 1", 2010, 200,barcode++);
    movieDB.add(6,dh1);
    Movie dh2 = new Movie("Deathly Hallows: Part 2", 2015, 200,barcode++);
    movieDB.add(7,dh2);
    for (int i = 0; i < (PERIODICALS/2); ++i)
    {
      Periodical quibbler = new Periodical("The Quibbler", randomDate(),barcode++);
      periodicalDB.add(i, quibbler);
    }
    for (int i = (PERIODICALS/2); i < PERIODICALS; ++i)
    {
      Periodical prophet = new Periodical("The Daily Prophet", randomDate(),barcode++);
      periodicalDB.add(i,prophet);
    }
    int RN = 1;
    for (int i = 0; i < ROOMS; ++i)
    {
      int aCapacity = generate.nextInt(30);
      boolean aBool = generate.nextBoolean();
      LibraryRoom aRoom = new LibraryRoom(RN, aCapacity, aBool,barcode++);
      roomDB.add(i,aRoom);
      ++RN;
    }
  }

/**The following print methods print out all of the items in each database*/
  public void printStudents()
  {
     for (int i = 0; i < studentDB.size(); ++i)
     {
       System.out.println(studentDB.get(i));
     }
  }
  public void printBooks(){
    for (int i = 0; i < bookDB.size(); ++i)
    {
      System.out.println(bookDB.get(i));
    }
  }
  public void printMovies(){
    for (int i = 0; i < movieDB.size(); ++i)
    {
      System.out.println(movieDB.get(i));
    }
  }
  public void printPeriodicals(){
    for (int i = 0; i <periodicalDB.size(); ++i)
    {
      System.out.println(periodicalDB.get(i));
    }
  }
  public void printRooms(){
    for (int i = 0; i < roomDB.size(); ++i)
    {
      System.out.println(roomDB.get(i));
    }
  }

//calls the toString method of the item located
  public void getStatus(int bc){
    System.out.println(locateItem(bc));
  }

//uses the unique barcode to return the item match
  public ReservableItem locateItem(int barcode){
    boolean located = false;
    for (int i = 0; i < bookDB.size(); ++i)
    {
      if (bookDB.get(i).getBarcode() == barcode)
      {
        located = true;
        return bookDB.get(i);
      }
    }
    for (int i = 0; i < movieDB.size(); ++i)
    {
      if (movieDB.get(i).getBarcode() == barcode)
      {
        located = true;
        return movieDB.get(i);
      }
    }
    for (int i = 0; i < periodicalDB.size(); ++i)
    {
      if (periodicalDB.get(i).getBarcode() == barcode)
      {
        located = true;
        return periodicalDB.get(i);
      }
    }
    for (int i = 0; i < roomDB.size(); ++i)
    {
      if (roomDB.get(i).getBarcode() == barcode)
      {
        located = true;
        return roomDB.get(i);
      }
    }
    return null;
  }

//uses the studentID to return the Student match
  public Student locateStudent(int id){
    boolean located = false;
    for (int i = 0; i < studentDB.size(); ++i)
    {
      if (studentDB.get(i).getID() == id)
      {
        located = true;
        return studentDB.get(i);
      }
    }
    return null;
  }

/** Pre-condition: student does not have item reserved, removes the student
from database */
  public void removeStudent(int id){
    Student theStudent = locateStudent(id);
    if (theStudent.getReserved() != null)
      System.out.println("Error: Student cannot be un-registered because they have items reserved.");
    else
    {
      for (int i = 0; i <studentDB.size(); ++i)
      {
        if (theStudent.equals(studentDB.get(i)))
          studentDB.remove(i);
      }
    }
  }

  /** Pre-condition: email and ID must be unique, adds a new Student to the database */
  public void newStudent(String fn, String ln, int phone){
    int theID;
    if (studentDB.isEmpty())
      theID = 1;
    else
    {
      theID = studentDB.get(studentDB.size()-1).getID() + 1; //add 1 to previous student's ID
    }
    String theEmail = ln + theID + "@hogwarts.edu";
    Student theStudent = new Student(theID, fn, ln, theEmail, phone);
    studentDB.add(theStudent);
  }

//clears all ArrayLists
  public void deleteData(){
    for (int i = 0; i < studentDB.size(); ++i)
    {
      studentDB.clear();
    }
    for (int i = 0; i < bookDB.size(); ++i)
    {
      bookDB.clear();
    }
    for (int i = 0; i < movieDB.size(); ++i)
    {
      movieDB.clear();
    }
    for (int i = 0; i < periodicalDB.size(); ++i)
    {
      periodicalDB.clear();
    }
    for (int i = 0; i < roomDB.size(); ++i)
    {
      roomDB.clear();
    }
  }

//reads in all Objects from a binary file and repopulates the ArrayLists
  public boolean readData() {
      try
      {
        inputStream = new ObjectInputStream(new FileInputStream("datafile.txt"));
        LibraryCatalog savedData = (LibraryCatalog)inputStream.readObject();
        for (int i = 0; i < studentDB.size(); ++i)
        {
          studentDB.add(savedData.studentDB.get(i));
        }
        for (int i = 0; i <bookDB.size(); ++i)
        {
          bookDB.add(savedData.bookDB.get(i));
        }
        for (int i = 0; i <movieDB.size(); ++i)
        {
          movieDB.add(savedData.movieDB.get(i));
        }
        for (int i = 0; i<periodicalDB.size();++i)
        {
          periodicalDB.add(savedData.periodicalDB.get(i));
        }
        for (int i = 0; i < roomDB.size(); ++i)
        {
          roomDB.add(savedData.roomDB.get(i));
        }
        return true;
      }
      catch (IOException e)
      {
        System.out.println(e.getMessage());
        return false;
      }
      catch (ClassNotFoundException e)
      {
        System.out.println("Error reading data.");
        return false;
      }
    }

//saves all Objects to a binary file
  public void save(LibraryCatalog catalog) {
  try
  {
    ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("datafile.txt"));
    outputStream.writeObject(catalog);
    outputStream.close();
  }
  catch (IOException e)
  {
    System.out.println("Could not save file.");
    System.exit(1);
  }
}

}
