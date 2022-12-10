package bookstore;
import java.util.Date;


public class Book {
    private String title;
    private String author;
    private Date publicationDate;
    private String publicationPlace;
    private long ISBN;

    public Book(String title, String author, Date date, String place, long isbn){
        this.title=title;
        this.author=author;
        this.publicationDate=date;
        this.publicationPlace=place;
        this.ISBN=isbn;
    }
    
    /** 
     * @return String
     */
    public String getTitle(){
        return this.title;
    }
    
    /** 
     * @return String
     */
    public String getAuthor(){
        return this.author;
    }

    
    /** 
     * @return Date
     */
    public Date getpublicationDate(){
        return this.publicationDate;
    }

    
    /** 
     * @return String
     */
    public String getpublicationPlace(){
        return this.publicationPlace;
    }
    
    /** 
     * @return long
     */
    public long getISBN(){
        return this.ISBN;
    }
}
