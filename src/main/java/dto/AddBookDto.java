package dto;

import com.tibber.models.Book;
import com.tibber.models.Publisher;

public class AddBookDto {
	private Book book;
	private Publisher publisher;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
}
