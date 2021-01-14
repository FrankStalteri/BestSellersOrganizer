/*
 * Frank Stalteri
 * CSC 236
 * Lab 3
 */
import java.util.Iterator;
import java.util.Scanner;

public class BestSellers<T> implements Iterable<T> {
	
	SortedArrayCollection<T> list;

	BestSellers(SortedArrayCollection<T> list) {
		this.list = list;
	}
	
	BestSellers() {
		SortedArrayCollection<Book> list = new SortedArrayCollection<Book>();
		this.list = (SortedArrayCollection<T>) list;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int index = -1;
			
			@Override
			public boolean hasNext() {
				return (index < (list.size() - 1));
			}

			@Override
			public T next() {
				if (!hasNext()) {
					throw new IndexOutOfBoundsException("No more elements.");
				}
				index++;
				return list.elements[index];
			}
		};
	}
	// adds book to list by option 1
	public void add() {
		// gets new book information
		Book b = getData();
		T book = (T) b;
		list.add(book);
	}
	// adds book by file
	public void add(Book b) {
		//b = getData();
		T book = (T) b;
		list.add(book);
	}
	// gets the info before adding to list
	private Book getData() {
		Date d;
		Scanner kb = new Scanner(System.in);
		Book book;
		System.out.println("Enter book information. Enter Year, Month, Day in this order and as seperate lines.");
		String title, firstName, lastName, publisher, date, category;
		String month, day, year;
		
		title = kb.nextLine();
		firstName = kb.nextLine();
		lastName = kb.nextLine();
		publisher = kb.nextLine();
		year = kb.nextLine();
		month = kb.nextLine();
		day = kb.nextLine();
		category = kb.nextLine();
		
		d = new Date(year, month, day);
		book = new Book(title, firstName, lastName, publisher, d, category);
		
		return book;
	}
	// sorts the list by title order
	public void displayByTitleOrder(BestSellers<Book> best) {
		SortedArrayCollection<Book> list = new SortedArrayCollection<Book>(Book.titleComparator());
		BestSellers<Book> best2 = new BestSellers<Book>();
		// assign the new list to the new best container
		best2.list = list;
		Iterator<Book> it = best.iterator();
		
		while (it.hasNext()) {
			Book b = it.next();
			best2.add(b);
		}
		// display new list
		Iterator<Book> it2 = best2.iterator();
		while (it2.hasNext()) {
			Book b = it2.next();
			System.out.println(b + "\n");
		}
	}
	// sorts list by date
	public void displayByDateOrder(BestSellers<Book> best) {
		SortedArrayCollection<Book> list = new SortedArrayCollection<Book>(Book.dateComparator());
		BestSellers<Book> best2 = new BestSellers<Book>();
		// assign the new list to the new best container
		best2.list = list;
		Iterator<Book> it = best.iterator();
		
		// adds to new list with comparator
		while (it.hasNext()) {
			Book b = it.next();
			best2.add(b);
		}
		// displays new list
		Iterator<Book> it2 = best2.iterator();
		while (it2.hasNext()) {
			Book b = it2.next();
			System.out.println(b + "\n");
		}
	}
	// sorts by natural order
	public void displayByNaturalOrder(BestSellers<Book> best) {
		Iterator<Book> it = best.iterator();
		
		while (it.hasNext()) {
			Book b = it.next();
			System.out.println(b + "\n");
		}
	}
	// displays the authors found 
	public void searchByAuthor(String s, BestSellers<Book> best) {
		Iterator<Book> it = best.iterator();
		Book b;
		// dummy variable to catch if none were found
		int count = 0;
		
		while (it.hasNext()) {
			b = it.next();
			if (b.name.toLowerCase().contains(s.toLowerCase().trim())) {
				System.out.println(b + "\n");
				count++;
			}
		}
		// if none were found, tell user so
		if (count == 0) {
			System.out.println("Author " + s + " not found.");
		}
	}
	// displays the titles found
	public void searchByTitle(String t, BestSellers<Book> best) {
		Iterator<Book> it = best.iterator();
		Book b;
		// dummy variable to catch if none were found
		int count = 0;
		
		while (it.hasNext()) {
			b = it.next();
			if (b.titleName.toLowerCase().contains(t.toLowerCase().trim())) {
				System.out.println(b + "\n");
				count++;
			}
		}
		// if none were found, tell user so
		if (count == 0) {
			System.out.println("Title " + t + " not found.");
		}
	}
	public void displayFictionBooks(String f, BestSellers<Book> best) {
		Iterator<Book> it = best.iterator();
		Book b;
		// dummy variable to catch if none were found
		int count = 0;
		
		while (it.hasNext()) {
			b = it.next();
			if (b.category.contains(f)) {
				System.out.println(b + "\n");
				count++;
			}
		}
		// if none were found, tell user so
		if (count == 0) {
			System.out.println("Fiction books weren't found.");
		}
	}
	public void displayNonFictionBooks(String nf, BestSellers<Book> best) {
		Iterator<Book> it = best.iterator();
		Book b;
		// dummy variable to catch if none were found
		int count = 0;
		
		while (it.hasNext()) {
			b = it.next();
			if (b.category.contains(nf)) {
				System.out.println(b + "\n");
				count++;
			}
		}
		// if none were found, tell user so
		if (count == 0) {
			System.out.println("Non-Fiction books weren't found.");
		}
	}
	public void displayYearRanges(int y, int y2, BestSellers<Book> best) {
		Iterator<Book> it = best.iterator();
		Book b;
		// dummy variable to catch if none were found
		int count = 0;
		
		while (it.hasNext()) {
			b = it.next();
			if (b.date.yearInteger >= y && b.date.yearInteger <= y2) {
				System.out.println(b + "\n");
				count++;
			}
		}
		// if none were found, tell user so
		if (count == 0) {
			System.out.println("Book weren't found in year ranges: " + y + " " + y2);
		}
	}
	public void displayMonthAndYearRange(int m, int y, BestSellers<Book> best) {
		Iterator<Book> it = best.iterator();
		Book b;
		// dummy variable to catch if none were found
		int count = 0;
		
		while (it.hasNext()) {
			b = it.next();
			if (b.date.yearInteger == y && b.date.monthInteger == m) {
				System.out.println(b + "\n");
				count++;
			}
		}
		// if none were found, tell user so
		if (count == 0) {
			System.out.println("Book weren't found in month and year ranges: " + m + " " + y);
		}
	}
}
