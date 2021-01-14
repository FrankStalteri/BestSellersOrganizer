/*
 * Frank Stalteri
 * CSC 236
 * Lab 3
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Enter file name.");
		Scanner kb = new Scanner(System.in);
		String fName = kb.nextLine();
		File f = new File(fName);
		
		menu();
		actions(f);
	}
	public static BestSellers<Book> build(File f) throws FileNotFoundException {
		Date d;
		Book b;
		BestSellers<Book> best = new BestSellers<Book>();
		Scanner read = new Scanner(f);
		read.useDelimiter("\t");
		
		while (read.hasNext()) {
			
			String title = read.next();
			String firstName = read.next();
			String lastName = read.next();
			String publisher = read.next();
			String date = read.next();
			String category = read.nextLine().trim();
			String month, day, year;
			Scanner sRead = new Scanner(date);
			sRead.useDelimiter("/");
			
			month = sRead.next();
			day = sRead.next();
			year = sRead.next();
			d = new Date(year, month, day);
			
			b = new Book(title, firstName, lastName, publisher, d, category);
			best.add(b);
		}
		return best;
	}
	public static void menu() {
		System.out.println("1: Add a best seller to the list.\n2: Print all books in natural order.");
		System.out.println("3: Display books in year range.\n4: Display books in month and year.");
		System.out.println("5: Search for an author.\n6: Search for a title.");
		System.out.println("7: Print all fiction books.\n8: Print all non-fiction books.");
		System.out.println("9: Prints books in order by date.\n10: Print in order by title.");
		
	}
	public static void actions(File f) throws FileNotFoundException {
		
		BestSellers<Book> best = build(f);
		Iterator<Book> it;
		
		Scanner kb = new Scanner(System.in);
		String dec = "N";
		int choice = 0;
		
		// continues until user says no
		while (!dec.equalsIgnoreCase("Y")) {
			System.out.println("Enter choice.");
			choice = kb.nextInt();
			kb.nextLine();
			// error traps the menu choice before continuing
			if (choice <= 0 || choice >= 11) {
				System.out.println("Invalid choice. Retry.");
			}
			else {
				switch (choice) {
				case 1:
					// get book info then perform insertion to list, then print by title order
					
					best.add();
					best.displayByTitleOrder(best);
					break;
				case 2:
					// display all books by natural order
				
					best.displayByNaturalOrder(best);
					break;
				case 3:
					// search by year range
					
					System.out.println("Enter two years");
					int y1 = kb.nextInt();
					int y2 = kb.nextInt();
					kb.nextLine();
					
					System.out.println("Books in between years: " + y1 + " " + y2);
					
					best.displayYearRanges(y1, y2, best);
					break;
				case 4:
					// search by specific month and year
					
					System.out.println("Enter month and year in m/yyyy format.");
					int month = kb.nextInt();
					int year = kb.nextInt();
					kb.nextLine();
					
					System.out.println("Books reached #1 in Month: " + month + " Year: " + year + "\n");
					
					best.displayMonthAndYearRange(month, year, best);
					break;
				case 5:
					// search by author name
					
					System.out.println("Search for an Author:");
					String name = kb.nextLine();
					
					
					best.searchByAuthor(name, best);
					break;
				case 6:
					// search by title
					
					System.out.println("Search for a title:");
					String title = kb.nextLine();
					
					best.searchByTitle(title, best);
					break;
				case 7: 
					//print all fiction books
					
					System.out.println("All Fiction Books:\n");
					String fiction = "Fiction";
					
					best.displayFictionBooks(fiction, best);
					break;
				case 8:
					//print all non-fiction books
					
					System.out.println("All Non-Fiction Books:\n");
					String nonFic = "Nonfiction";
					
					best.displayNonFictionBooks(nonFic, best);
					break;
				case 9:
					// display books by date order
					
					System.out.println("Books by Date:\n");
					best.displayByDateOrder(best);
					
					break;
				case 10:
					// display books by title order
					
					System.out.println("Books By Title\n");
					best.displayByTitleOrder(best);
					break;
				}
				System.out.println("Exit? Y/N");
				dec = kb.nextLine();
			}
		}
		System.out.println("Exit Menu");
	}
}