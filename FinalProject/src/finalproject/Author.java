package finalproject;
import java.util.*;

public class Author {
    private String lastName;
    private String firstName;
    private int noOfBooks;
    
    public Author(String lastName, String firstName, int noOfBooks) {
        this.lastName=lastName;
        this.firstName=firstName;
        this.noOfBooks=noOfBooks;
    }
    
    public void setLastName(String lastName) {
        this.lastName=lastName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }
    
    public void setNoOfBooks(int noOfBooks) {
        this.noOfBooks=noOfBooks;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public int getNoOfBooks() {
        return noOfBooks;
    }
}
