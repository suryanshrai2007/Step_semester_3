package oop_constructs.class_problems;

public class LibraryBook {
    String title;
    String isbn;
    boolean catalogued;

    public LibraryBook(String title, String isbn) {
        this.title = title;
        this.isbn = (isbn == null || isbn.isEmpty()) ? "PENDING" : isbn;
        this.catalogued = true;
    }

    public LibraryBook(String title) {
        this(title, "");
    }

    public void printInfo() {
        System.out.println(title + " | " + isbn + " | Catalogued: " + catalogued);
    }

    public static void main(String[] args) {
        String[] titles = {"Clean Code", "Untitled Draft", "1984", "Notes"};
        String[] isbns = {"978-0132350884", "", "9780451524935", ""};

        for (int i = 0; i < titles.length; i++) {
            LibraryBook book = isbns[i].isEmpty()
                    ? new LibraryBook(titles[i])
                    : new LibraryBook(titles[i], isbns[i]);
            book.printInfo();
        }
    }
}