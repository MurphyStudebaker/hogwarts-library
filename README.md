# hogwarts-library
Created originally for my Computer Science II class and improved upon after because Hogwarts is cool. 

This is a library circulation desk browser that generates Hogwarts-specific data (such as students and library contents) for simulation use. However, this can be used without the auto-generation as a framework for any library's data base. 

# LibraryCatalog 
This is the class that holds and manipulates all library data. If you wish to use this program for personal use, you can modify this class
to better fit your needs, or to add additional functionality.

# CirculationDesk
This class handles all user interaction. If additional functionality is desired, it should be added to the menu in this class and then developed within the LibraryCatalog class. 

# ReservableItem 
All other classes in this application (with the exception of the Driver) are derived from this class, which provides all Library Contents with a unique barcode and check out and return methods. If you wish to add an additional type of something for check out, you should define a class derived from this class. 
