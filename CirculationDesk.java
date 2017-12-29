import java.util.Scanner;
import java.util.GregorianCalendar;
/**The CirculationDesk class handles all interfacing with the user. The menu is
called when constructed, and repeats after every task is executed until the user
decides to quit.*/
public class CirculationDesk {
  LibraryCatalog theCatalog;
  Scanner userInput = new Scanner(System.in);

  public CirculationDesk(){ //constructor
    theCatalog = new LibraryCatalog();
    System.out.println("Welcome to the Hogwarts Library!");
    initialize();
  }

/**The initialize method prints the main menu.*/
  public void initialize(){
    System.out.println("Select an option: ");
    System.out.println("1. Add an item to database");
    System.out.println("2. Look up an item's status");
    System.out.println("3. Add or remove a student");
    System.out.println("4. Check out an item");
    System.out.println("5. Return an item");
    System.out.println("6. List items");
    System.out.println("7. Restricted Section");
    System.out.println("8. Quit");
    int response = userInput.nextInt();
    while (response != 8)
    {
        if (response == 1)
          addItem();
        else if (response == 2)
          checkStatus();
        else if (response == 3)
          studentRegistration();
        else if (response == 4)
          checkOutItem();
        else if (response == 5)
          returnAnItem();
        else if (response == 6)
          listItems();
        else if (response == 7)
          restrictedSection();
        else if (response == 8)
          break;
        else
          System.out.println("Error: Invalid input.");
    }
    theCatalog.save(theCatalog);
    System.exit(0);
  }

/**The checkStatus method gets the barcode of the item and passes it to the
LibraryCatalog's getStatus method. */
  public void checkStatus(){
    System.out.println("Enter the item's barcode: ");
    int theBarcode = userInput.nextInt();
    theCatalog.getStatus(theBarcode);
    initialize();
  }

/**The listItems method gets the type of item desired to be listed, and calls
the apropriate LibraryCatalog print method */
  public void listItems(){
    System.out.println("Select which items you would like to list:");
    System.out.println("1. All books");
    System.out.println("2. All movies");
    System.out.println("3. All periodicals");
    System.out.println("4. All rooms");
    int selection = userInput.nextInt();
    if (selection == 1)
      theCatalog.printBooks();
    else if (selection == 2)
      theCatalog.printMovies();
    else if (selection == 3)
      theCatalog.printPeriodicals();
    else if (selection == 4)
      theCatalog.printRooms();
    else
      System.out.println("Error: Invalid input.");
    initialize();
  }

/**The returnAnItem method gets the barcode of the item and the ID of the student
and passes both into the LibraryCatalog's returnItem method*/
  public void returnAnItem(){
    System.out.println("Enter item's barcode: ");
    int barcode = userInput.nextInt();
    System.out.println("Enter return student's ID: ");
    Student student = theCatalog.locateStudent(userInput.nextInt());
    GregorianCalendar today = new GregorianCalendar(1997, 9, 1);
    theCatalog.locateItem(barcode).returnItem(today, student);
    initialize();
  }

/**The checkOutItem method gets the item's barcode and ID of the students and passes
both to LibraryCatalog*/
  public void checkOutItem(){
    System.out.println("Enter item's barcode: ");
    int barcode = userInput.nextInt();
    System.out.println("Enter student's ID: ");
    Student student = theCatalog.locateStudent(userInput.nextInt());
    GregorianCalendar today = new GregorianCalendar(1997, 9, 1);
    theCatalog.locateItem(barcode).checkOut(today, student);
    initialize();
  }

/**The studentRegistration method gets all information needed to register
and unregister a student and passes them to LibraryCatalog */
  public void studentRegistration(){
    System.out.println("Select an option: ");
    System.out.println("1. Register a new student");
    System.out.println("2. Un-register an old student");
    int selection = userInput.nextInt();
    if (selection == 1)
    {
      System.out.println("Enter the student's first name: ");
      userInput.nextLine();
      String fname = userInput.nextLine();
      System.out.println("Enter the student's last name: ");
      String lname = userInput.nextLine();
      System.out.println("Enter the student's phone number: ");
      int phone = userInput.nextInt();
      theCatalog.newStudent(fname, lname, phone);
    }
    else if (selection == 2)
    {
      System.out.println("Enter the student ID: ");
      theCatalog.removeStudent(userInput.nextInt());
    }
    initialize();
  }

/**The restrictedSection method prints the menu of actions that should only be
accessed by faculty or staff */
  public void restrictedSection(){
    System.out.println("Select an option: ");
    System.out.println("1. Remove an item from database");
    System.out.println("2. List all students");
    System.out.println("3. Delete all data");
    int selection = userInput.nextInt();
    if (selection == 1)
      removeItem();
    if (selection == 2)
      theCatalog.printStudents();
    else if (selection == 3)
      theCatalog.deleteData();
    initialize();
  }

/**The removeItem method gets the barcode of the item and passes it to LibraryCatalog */
  public void removeItem(){
    System.out.println("Select item you would like to remove: ");
    System.out.println("1. Book");
    System.out.println("2. Movie");
    System.out.println("3. Periodical");
    System.out.println("4. Room");
    int selection = userInput.nextInt();
    System.out.println("Enter the item's barcode: ");
    int theBarcode = userInput.nextInt();
    if (selection == 1)
    {
      theCatalog.bookDB.remove(theCatalog.locateItem(theBarcode));
    }
    else if (selection == 2)
    {
      theCatalog.movieDB.remove(theCatalog.locateItem(theBarcode));
    }
    else if (selection == 3)
    {
      theCatalog.periodicalDB.remove(theCatalog.locateItem(theBarcode));
    }
    else if (selection == 4)
    {
      theCatalog.roomDB.remove(theCatalog.locateItem(theBarcode));
    }
    else
      System.out.println("Error: Invalid input.");
    initialize();
  }

/**The addItem method gets all information needed depending on the type selected
and adds it to the appropriate LibraryCatalog ArrayList */
  public void addItem(){
    System.out.println("Select item you would like to add: ");
    System.out.println("1. Book");
    System.out.println("2. Movie");
    System.out.println("3. Periodical");
    System.out.println("4. Room");
    int selection = userInput.nextInt();
    if (selection == 1)
    {
      System.out.println("Book title: ");
      userInput.nextLine();
      String title = userInput.nextLine();
      System.out.println("Author: ");
      String author = userInput.nextLine();
      System.out.println("Page count: ");
      int pc = userInput.nextInt();
      System.out.println("ISBN: ");
      int theISBN = userInput.nextInt();
      System.out.println("Barcode: ");
      int barcode = userInput.nextInt();
      Book theBook = new Book(title, author, pc, theISBN, barcode);
      theCatalog.bookDB.add(theBook);
    }
    else if(selection ==2)
    {
      System.out.println("Movie title: ");
      String title = userInput.nextLine();
      System.out.println("Release year: ");
      int ry = userInput.nextInt();
      System.out.println("Runtime (minutes): ");
      int rt = userInput.nextInt();
      System.out.println("Barcode: ");
      int bc = userInput.nextInt();
      Movie theMovie = new Movie(title, ry, rt, bc);
      theCatalog.movieDB.add(theMovie);
    }
    else if (selection == 3)
    {
      System.out.println("Periodical title: ");
      String title = userInput.nextLine();
      System.out.println("Release Date (dd,mm,yyy): ");
      int day = userInput.nextInt();
      int month = userInput.nextInt();
      int year = userInput.nextInt();
      GregorianCalendar theDate = new GregorianCalendar(year, month, day);
      System.out.println("Barcode: ");
      int bc = userInput.nextInt();
      Periodical thePeriodical = new Periodical(title, theDate, bc);
    }
    else if (selection == 4)
    {
      System.out.println("Room number: ");
      int rn = userInput.nextInt();
      System.out.println("Capacity: ");
      int capacity = userInput.nextInt();
      System.out.println("Barcode: ");
      int bc = userInput.nextInt();
      System.out.println("Does the room have a computer? (yes or no)");
      String hasCompString = userInput.nextLine();
      boolean hasComp = false;
      LibraryRoom theRoom;
      if (hasCompString.equalsIgnoreCase("yes"))
      {
        theRoom = new LibraryRoom(rn, capacity, true, bc);
        theCatalog.roomDB.add(theRoom);
      }
      else if (hasCompString.equalsIgnoreCase("no"))
      {
        theRoom = new LibraryRoom(rn, capacity, false, bc);
        theCatalog.roomDB.add(theRoom);
      }
      else
      {
        System.out.print("Error: Invalid answer.");
      }
      initialize();
    }
    else
      System.out.println("Error: Invalid selection.");
    initialize();

  }
}
