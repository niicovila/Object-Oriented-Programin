package bookstore;
import java.util.Currency;

public class Stock implements StockInterface{

    private Book book;
    private double price;
    private Currency currency;
    private int copies;
    

    public Stock(Book bookinit, double price, Currency currency, int copies){
        
        this.price=price;
        this.currency= currency;
        this.copies=copies;
        this.book = bookinit;

    }

    
    /** 
     * @return Book
     */
    public Book get_book(){
        return this.book;
    }

    
    /** 
     * @return String
     */
    @Override
    public String getBooktitle() {
        return this.book.getTitle();
    }

    
    /** 
     * @return int
     */
    @Override
    public int numberOfCopies() {
        return this.copies;
    }

    
    /** 
     * @param numberOfCopies
     */
    @Override
    public void addCopies(int numberOfCopies) {
        this.copies += numberOfCopies;
        
    }

    
    /** 
     * @param numberOfCopies
     */
    @Override
    public void removeCopies(int numberOfCopies) {
        this.copies -= numberOfCopies;
    }

    
    /** 
     * @return double
     */
    @Override
    public double totalPrice() {
        return this.price*copies;
    }
}
