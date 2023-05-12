package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import application.entities.Book;
import application.entities.Catalogue;
import application.entities.Magazine;
import application.entities.Periodicity;

public class Application {

	public static void main(String[] args) {
		Catalogue book1 = new Book("Libro1", 2010, 100, "MeMedesimo", "Crime");
		Catalogue book2 = new Book("Libro2", 2010, 229, "MeMedesimo", "Horror");
		Catalogue book3 = new Book("Libro3", 2012, 122, "TuTuesimo", "Comedy");
		Catalogue magazine1 = new Magazine("Magazine1", 2020, 133, Periodicity.MENSILE);
		Catalogue magazine2 = new Magazine("Magazine2", 2023, 500, Periodicity.SETTIMANALE);
		Catalogue magazine3 = new Magazine("Magazine3", 2010, 324, Periodicity.SETTIMANALE);

		List<Catalogue> mediaList = new ArrayList<>();
		addElem(mediaList, book1);
		addElem(mediaList, book2);
		addElem(mediaList, book3);
		addElem(mediaList, magazine1);
		addElem(mediaList, magazine2);
		addElem(mediaList, magazine3);

		System.out.println("Lista libri/magazine: " + mediaList);

		removElem(mediaList, book1.getISBN());

		System.out.println("Lista libri/magazine dopo il remove: " + mediaList);

		System.out.println("Find ISBN: " + findISBN(mediaList, magazine1.getISBN()));

		System.out.println("Find Year: " + findYear(mediaList, 2010));

		System.out.println("Find Author: " + findAuthor(mediaList, "MeMedesimo"));
	}

	public static void addElem(List<Catalogue> list, Catalogue item) {
		list.add(item);
	}

	public static void removElem(List<Catalogue> list, UUID id) {
		Iterator<Catalogue> i = list.iterator();
		while (i.hasNext()) {
			Catalogue curr = i.next();
			if (curr.getISBN().equals(id)) {
				i.remove();
			}
		}
	}

	public static Catalogue findISBN(List<Catalogue> list, UUID id) {
		Catalogue m = list.stream().filter(media -> media.getISBN().equals(id)).findAny().orElse(null);
		return m;
	}

	public static List<Catalogue> findYear(List<Catalogue> list, int pubYear) {
		List<Catalogue> p = list.stream().filter(media -> media.getPubblicationYear() == pubYear).toList();
		return p;
	}

	public static List<Book> findAuthor(List<Catalogue> list, String author) {
		List<Book> l = list.stream().filter(m -> m instanceof Book && ((Book) m).getAuthor().equals(author))
				.map(m -> (Book) m).toList();
		return l;
	}
}
