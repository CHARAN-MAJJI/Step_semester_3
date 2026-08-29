class LibraryBook {
    String title, isbn;

    LibraryBook(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    LibraryBook(String title) {
        this(title, "PENDING");
    }

    void display() {
        System.out.println(title + " | " + isbn + " | Catalogued: true");
    }
}

public class M1 {
    public static void main(String[] args) {

        String[] titles = {"Clean Code", "Untitled Draft", "1984", "Notes"};
        String[] isbns = {"978-0132350884", "", "9780451524935", ""};

        for (int i = 0; i < titles.length; i++) {
            LibraryBook b;

            if (isbns[i].isEmpty())
                b = new LibraryBook(titles[i]);
            else
                b = new LibraryBook(titles[i], isbns[i]);

            b.display();
        }
    }
}
