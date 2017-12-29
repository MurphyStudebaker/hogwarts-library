/**This Movie class is derived from ReservableItem and includes instance variables
for a film's title, release year, and runime in minutes. It has no additional
methods other than standard mutator and accessors.*/
public class Movie extends ReservableItem {
  private String title;
  private int releaseYear;
  private int runtime; //minutes

  public Movie(){ //empty constructor
    super();
    title = null;
    releaseYear = 0;
    runtime = 0;
  }

  public Movie (String t, int y, int r, int bc){ //preferred constructor
    super(bc);
    title = t;
    releaseYear = y;
    runtime = r;
  }

  //getters and setters
  public void setTitle(String t)
  { title = t;}
  public void setReleaseYear(int y)
  { releaseYear = y;}
  public void setRuntime(int r)
  { runtime = r;}
  public String getTitle()
  { return title;}
  public int getReleaseYear()
  { return releaseYear;}
  public int getRuntime()
  { return runtime;}

  /**toString prints the title, release year, runtime, and information within
  the Object's parent class*/
  public String toString(){
    return "Title: "+title+"\nRelease Year: "+releaseYear+"\nRuntime: "+" minutes"
    +"\n"+super.toString();
  }
}
