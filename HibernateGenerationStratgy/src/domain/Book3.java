package domain;

import javax.persistence.*;
	
@Entity
@Table(name="book_data3")
public class Book3
	 {
	    @Id
	    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="book_generator")
	    @Column(name="book_id")
		private int bookId;
	    
	    @Id
	    @Column(name="book_name")
	    private String bookName;
	    
	    @Id
	    @Column(name="book_price")
	    private double bookPrice;
	    
	    
		public int getBookId() {
			return bookId;
		}
		public void setBookId(int bookId) {
			this.bookId = bookId;
		}
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		public double getBookPrice() {
			return bookPrice;
		}
		public void setBookPrice(double bookPrice) {
			this.bookPrice = bookPrice;
		}
	      

}
