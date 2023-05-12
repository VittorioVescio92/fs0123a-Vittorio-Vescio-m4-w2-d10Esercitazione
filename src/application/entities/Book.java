package application.entities;

public class Book extends Catalogue {
	private String author;
	private String genre;

	public Book(String title, int pubblicationYear, int pagesNumber, String author, String genre) {
		super(title, pubblicationYear, pagesNumber);
		setAuthor(author);
		setGenre(genre);

	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "ISBN code: " + getISBN() + " | Title: " + getTitle() + " | Pubblication year: " + getPubblicationYear()
				+ " | Number of pages: " + getPagesNumber() + " | Author: " + getAuthor() + " | Genre: " + getGenre();
	}

}
