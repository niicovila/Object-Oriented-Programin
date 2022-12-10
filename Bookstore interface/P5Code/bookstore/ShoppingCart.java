package bookstore;
import java.util.HashSet;

//import java.util.spi.CurrencyNameProvider;
import java.util.Currency;

public class ShoppingCart extends BookCollection implements ShoppingCartInterface{
    private Catalog catalog;


public ShoppingCart(Catalog catinit){
    super();
    this.catalog=catinit; 
    
}


/** 
 * @param booktitle
 * @param collection
 * @return StockInterface
 */
private StockInterface getStock( String booktitle, HashSet< StockInterface > collection ) {
    for ( StockInterface stock : collection ) {
        if ( booktitle.equals( stock.getBooktitle() ) )
            return stock;
    }
    return null;
}

/** 
 * @param numberOfCopies
 * @param booktitle
 */
public void addCopies( int numberOfCopies, String booktitle){
    
    StockInterface book = getStock(booktitle, catalog.collection);
    if(book.numberOfCopies()>= numberOfCopies){
        StockInterface cart = getStock(booktitle, super.collection);
        cart.addCopies(numberOfCopies);
        book.removeCopies(numberOfCopies);
    }
    
    
}

/** 
 * @param numberOfCopies
 * @param booktitle
 */
public void removeCopies(int numberOfCopies, String booktitle){
    StockInterface shop = getStock(booktitle, super.collection);
    if(shop.numberOfCopies()>= numberOfCopies){
        StockInterface book = getStock( booktitle, catalog.collection );
        shop.removeCopies(numberOfCopies);
        book.addCopies(numberOfCopies);
    }
    
    
} 


/** 
 * @return double
 */
public double totalPrice(){
    double total_price = 0;
    for(StockInterface book : super.collection){
        total_price += book.totalPrice();
    }
    return total_price;
}

/** 
 * @return String
 */
public String checkout(){
    
    
    long VISANumber= 476669788;
    String cardHolder="Pep";
    double totalPrice= totalPrice();
    Currency currency= Currency.getInstance("EUR");
    Payment pay = new Payment();

    for(StockInterface book : super.collection){
         book.removeCopies(book.numberOfCopies());
    }

    return pay.doPayment(VISANumber, cardHolder, totalPrice, currency);
    
}
}
