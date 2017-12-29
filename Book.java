/**The Book is a derived class from ReservableItem and adds instance variables for
the book's title, author, page count, and ISBN number. It adds no additional
functional methods. */
public class Book extends ReservableItem {
  private String title;
  private String author;
  private int pageCount;
  private int ISBN;

  public Book (){ //empty constructor
    super();
    title = null;
    author = null;
    pageCount = 0;
    ISBN = 0;
  }

  public Book (String t, String a, int pc, int i, int bc){ //preferred constructor
    super(bc);
    title = t;
    author = a;
    pageCount = pc;
    ISBN = i;
  }

  //getters and setters
  public String getTitle()
  { return title;}
  public String getAuthor()
  { return author;}
  public int getPageCount()
  { return pageCount;}
  public int getISBN()
  { return ISBN;}
  public void setTitle(String t)
  { title = t;}
  public void setAuthor(String a)
  { author = a;}
  public void setPageCount(int pc)
  { pageCount = pc;}
  public void setISBN(int isbn)
  { ISBN = isbn;}

  /**The toString method prints all instance variables and the information from
  the parent class*/
  public String toString(){
    return "Title: "+title+"\nAuthor: "+author+"\nISBN: "+ISBN+"\nPageCount: "+
    pageCount + "\n" + super.toString();
  }
}
