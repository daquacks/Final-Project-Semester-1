package finalproject;
import java.util.*;

public class Book {
   private String title;
   private Author author;
   private Publisher publisher;
   private int edition;
   private double price; // In canadian dollars 
   private int[] saleNumbers;
   private double annualInflationRate; // In percentage
   private double totalRevenue;
   
   public Book(String title, Author author, Publisher publisher, int edition) {
       this.title=title;
       this.author=author;
       this.publisher=publisher;
       this.edition=edition;
       saleNumbers = new int[6];
       annualInflationRate=7.0;
       price=17.72;
       price+=(((int)((price*(annualInflationRate/100.0))*100))/100.0);
   }
   
   public void setTitle(String title) {
       this.title=title;
   }
   
   public void setAuthor(Author author) {
       this.author=author;
   }
   
   public void setPublisher(Publisher publisher) {
       this.publisher=publisher;
   }
   
   public void setEdition(int edition) {
       this.edition=edition;
   }
   
   public void setPrice(double price) {
       this.price=price;
   }
   
   public void setAnnualInflationRate(double annualInflationRate) {
       this.annualInflationRate=annualInflationRate;
       price+=(((int)((price*(annualInflationRate/100.0))*100))/100.0);
   }
   
   public void setSaleNumbers(int numberOfSoldBooks, int monthNumber) {
           saleNumbers[monthNumber]=numberOfSoldBooks;
   }
   
   public String getTitle() {
       return title;
   }
   
   public Author getAuthor() {
       return author;
   }
   
   public Publisher getPublisher() {
       return publisher;
   }
   
   public int getEdition() {
       return edition;
   }
   
   public double getPrice() {
       return price;
   }
   
   public double getAnnualInflationRate() {
       return annualInflationRate;
   }
   
   public int getSaleNumbers(int monthNumber) {
       return saleNumbers[monthNumber-1];
   }
   
   public int getTotalBooks() {
       int sum=0;
       for (int sales: saleNumbers) {
           sum+=saleNumbers[sales];
       }
       return sum;
   }
   
   public double getTotalSold() {
       int sum=0;
       for (int sales: saleNumbers) {
           sum+=(sales*price);
       }
       totalRevenue+=sum;
       return sum;
   }
   
   public void resetSaleNumbers() { // Do this at the beginning of the year unless we want to commit fraud
       for (int sales: saleNumbers) {
           sales=0;
       }
   }
   
   public void sendTaxReports() {
       totalRevenue-=getTotalSold()*0.30; // I know it's a lot...
   }
   
   /**
    * Please do not use this seriously.
    */
   public void falsifyTaxReports() { // Commit fraud (tax evasion)
       resetSaleNumbers(); // Sets this to zero so we do not have to pay anything 
       sendTaxReports();
   }
}
