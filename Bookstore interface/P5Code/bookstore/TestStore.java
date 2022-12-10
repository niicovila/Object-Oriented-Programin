//Corregit
package bookstore;
//with a main method that launches an application of type BookStore.

import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.LinkedList;

public class TestStore {
    public static void main( String[] args ) {
        Catalog books = new Catalog();
        Catalog cart = new Catalog();

        LinkedList< String[]> store_books = new LinkedList<String[]>();
        store_books = BookCollection.readCatalog("bookstore\\books.xml");

        for(String[] s:store_books){
            
            Date date = new Date();
            try { date = new SimpleDateFormat().parse( s[2] ); } // Date instance
            catch( Exception e ) {}
            long isbn = Long.parseLong( s[4] ); // convert to long
            double price = Double.parseDouble( s[5] ); // convert to double
            Currency currency = Currency.getInstance( s[6] ); // Currency instance
            int copies_store = Integer.parseInt( s[7] );

            Book book = new Book(s[0],s[1], date, s[3], isbn);

            StockInterface stock = new Stock(book, price, currency, copies_store);
            StockInterface s_cart = new Stock(book, price, currency, 0);
            
            books.collection.add(stock);
            cart.collection.add(s_cart);
        }
        
        ShoppingCart shoppingcart = new ShoppingCart(books);
        
        shoppingcart.collection = cart.collection;
        
        new BookStore( (BookCollectionInterface)books, shoppingcart );
        
    


    }
}

