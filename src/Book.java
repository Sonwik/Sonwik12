public class Book {
    private int id;
    private static int idGen = 0;
    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book() {
        this.id = idGen++;
        this.available = true;
    }

    public Book(String title, String author, int year) {
        this();
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    public void markAsBorrowed() {
        this.available = false;
    }

    public void markAsReturned() {
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        // Простая проверка на пустоту
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Empty title");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author.isEmpty()) {
            throw new IllegalArgumentException("Empty author");
        }
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        // Просто проверяем, что год адекватный
        if (year < 1500 || year > 2025) {
            throw new IllegalArgumentException("Bad year");
        }
        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "Book [" + id + "]: " + title + " by " + author + " (" + year + ")";
    }
    public static void main(String[] args) {
        }
}