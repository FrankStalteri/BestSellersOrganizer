/*
 * Frank Stalteri
 * CSC 236
 * Lab 3
 */
import java.util.Comparator;

public class Book implements Comparable<Book> {
	
	private String title;
	private String firstName;
	private String lastName;
	private String publisher;
	public Date date;
	public String category;
	public String name;
	public String titleName;
	
	// constructor for initializing a book object
	Book(String title, String firstName, String lastName, String publisher, Date date, String category) {
		
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.publisher = publisher;
		this.date = date;
		this.category = category;
		this.name = firstName + " " + lastName;
		this.titleName = title;
	}
	// empty constructor
	Book() {
		
	}
	// returns a nicely formatted output
	public String toString() {
		
		return "Title: " + title + "\n" + "Name: " + name + 
				"\n" + "Publisher: " + publisher + "\n" + "Date: " + date + 
				"\n" + "Category: " + category;
	}
	// compares the last name, first name, then title (natural order)
	@Override
	public int compareTo(Book o) {
		
		if (this.lastName.equals(o.lastName))
			return this.lastName.compareTo(o.lastName);
		
		if (this.firstName.equals(o.firstName))
			return this.firstName.compareTo(o.firstName);
		
		else 
			return this.title.compareTo(o.title);
	}
	// checks if first name, last name, and title are equal
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		else {
			if (o == null || o.getClass() != this.getClass()) {
				return false;
			}
			else {
				Book b = (Book) o;
				return (this.lastName.equals(b.lastName) && this.firstName.equals(b.firstName) && this.title.equals(b.title));
			}
		}
	}
	// returns list sorted by title
	public static Comparator<Book> titleComparator() {
		return new Comparator<Book>() {
			public int compare(Book one, Book two) {
				return (one.title.compareTo(two.title));
			}
		};
	}
	// returns list sorted by date
	public static Comparator<Book> dateComparator() {
		return new Comparator<Book>() {
			public int compare(Book one, Book two) {
				return one.date.compareTo(two.date);
			}
		};
	}
}
