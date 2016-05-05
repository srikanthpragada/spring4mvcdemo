package model;

public class BookNotFoundException extends RuntimeException {

	 public BookNotFoundException() {
		 super("Book is not found!");
	 }
}
