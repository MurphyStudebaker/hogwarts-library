import java.util.GregorianCalendar;

/**Periodical is a derived class of ReservableItem. It adds the instance variables
title and releaseDate, but has no additional functional methods.*/
public class Periodical extends ReservableItem {
  private String title;
  private GregorianCalendar releaseDate;

  public Periodical(){ //empty constructor
    super();
    title = null;
    releaseDate = null;
  }

  public Periodical(String t, GregorianCalendar d, int bc){ //preferred constructor
    super(bc);
    title = t;
    releaseDate = d;
  }

  public Periodical(Periodical other){ //copy constructor
    super();
    this.title = other.getTitle();
    this.releaseDate = other.getReleaseDate();
  }

  /**Getters and setters for all instance variables*/
  public String getTitle()
  { return title; }
  public GregorianCalendar getReleaseDate()
  { return releaseDate; }
  public void setTitle(String t)
  { title = t;}
  public void setReleaseDate(GregorianCalendar d)
  { releaseDate = d;}

/**The equals method compares this Periodical with an instance of another Periodical
object. It returns true only if all instance variables match.
@param Periodical is the object to be compared*/
  public boolean equals(Periodical p){
    return (p.getTitle().equals(this.title)
    && p.getReleaseDate() == this.releaseDate);
  }
  /**The toString method prints all instance variables and the information from
  the parent class*/
  public String toString(){
    return "Title: "+title+"\nRelease: "+releaseDate+"\n"+super.toString();
  }
}
