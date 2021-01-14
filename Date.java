import java.util.Comparator;

/*
 * Frank Stalteri
 * CSC 236
 * Lab 3
 */
public class Date implements Comparable<Date> {
	
	private String year;
	private String month;
	private String day;
	private String date;
	public int yearInteger;
	public int monthInteger;
	public int dayInteger;
	
	Date(String year, String month, String day) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.dayInteger = Integer.parseInt(day);
		this.yearInteger = Integer.parseInt(year);
		this.monthInteger = Integer.parseInt(month);
		
		date = month + "/" + day + "/" + year;
	}
	// empty constructor
	Date () {
		
	}
	// compares the day, month, and year
	@Override
	public int compareTo(Date o) {
		
		if (this.yearInteger < o.yearInteger) {
			return -1;
		}
		else if (this.yearInteger > o.yearInteger) {
			return 1;
		}
		else {
			if (this.yearInteger == o.yearInteger) {
				if (this.monthInteger < o.monthInteger) {
					return -1;
				}
				else if (this.monthInteger > o.monthInteger) {
					return 1;
				}
				else {
					if (this.monthInteger == o.monthInteger) {
						if (this.dayInteger < o.dayInteger) {
							return -1;
						}
						else if (this.dayInteger > o.dayInteger) {
							return 1;
						}
						else {
							return 0;
						}
					}
				}
			}
			return 0;
		}
		
	}
	// checks year, month, and day
	public boolean equals(Object o) {
		boolean isEqual = false;
		
		if (o == null || !(o instanceof Date)) {
			return false;
		}
		Date d = (Date) o;
		
		if (year.equals(d.year) && month.equals(d.month) && day.equals(d.day)) {
			isEqual = true;
		}
		return isEqual;
	}
	// returns nicely formatted date
	public String toString() {
		return date;
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
