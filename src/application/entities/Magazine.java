package application.entities;

public class Magazine extends Library {
	private Periodicity periodicity;

	public Magazine(String title, int pubblicationYear, int pagesNumber, Periodicity periodicity) {
		super(title, pubblicationYear, pagesNumber);
		setPeriodicity(periodicity);
	}

	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	@Override
	public String toString() {
		return "ISBN code: " + getISBN() + " | Title: " + getTitle() + " | Pubblication year: " + getPubblicationYear()
				+ " | Number of pages: " + getPagesNumber() + " | Periodicity: " + getPeriodicity();
	}

}
