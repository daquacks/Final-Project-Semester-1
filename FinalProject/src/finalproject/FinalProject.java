package finalproject;
import java.util.*;

public class FinalProject {
    
    public static Book[] arrayOfBooks;

    public static void main(String[] args) {
        scanForInput();
    }
    
    public static void executeChoice(int n, Scanner scInput) {
        while (n>5 || n<0) {
            System.out.println("Invalid input. Try again: ");
            n=scInput.nextInt();
        }
        switch (n) {
            case 0: // EXECUTE ONE BY ONE
                arrayOfBooks=addBook(); // Assigns the value returned by addBook (the actual array) to the currently null array
                getSaleInfo(); 
                getPriceInfo(); 
                getBookDetails();
                break;
            case 1: // ADD A BOOK
                arrayOfBooks=addBook(); 
                scanForInput(); 
                break;
            case 2: // GET THE INFO ON SALES
                if (arrayOfBooks!=null) {
                   getSaleInfo();
                }
                else { // Demands for adding books if there is nothing in the array
                    System.out.println("Add books first."); 
                }
                scanForInput(); 
                break;
            case 3: // GET THE INFO ON PRICES
                if (arrayOfBooks!=null) {
                   getPriceInfo(); 
                }
                else {
                    System.out.println("Add books first.");
                }
                scanForInput(); 
                break;
            case 4: // GET DETAILS ON ALL BOOKS
                if (arrayOfBooks!=null) {
                   getBookDetails(); 
                }
                else {
                    System.out.println("Add books first.");
                }
                scanForInput(); 
                break;
            case 5: System.exit(0); break;
        }
    }
    
       public static void scanForInput() {
           Scanner scInput = new Scanner(System.in);
           System.out.println("Select a question to execute from the following list:\n0: Execute all one by one\n1: Add books");
           System.out.println("2: Get sale info of the books\n3: Get price info of the books\n4: Get details the books\n5: Exit\nEnter integer 0-5: ");
           while (!(scInput.hasNextInt())) {
               System.out.println("Please enter an integer.");
               scInput.next();
           }
           int userInput = scInput.nextInt();
           executeChoice(userInput, scInput); 
       }
       
       public static Book[] addBook() {
           Scanner scInput1 = new Scanner(System.in);
           
           System.out.println("Enter an amount of books to add: ");
           while (!scInput1.hasNextInt()) {
               System.out.println("Try again.");
               scInput1.next();
           }
           int numberToAdd=scInput1.nextInt();
           scInput1.nextLine();
           
           Book[] arrayOfBooks = new Book[numberToAdd];
           
           for (int i=0; i<numberToAdd; i++) {
              // INITIALIZATION
              Scanner scInput = new Scanner(System.in);
              int edition=0;
              Book book;
              String bookTitle;
              
              // BASICS
              System.out.printf("\nEnter the data for the book #%d: ", i+1);
              System.out.println("\nTitle: ");
              bookTitle=scInput.nextLine();
              
              // AUTHOR
              System.out.println("\nAUTHOR INFO");
              System.out.println("Author first name (enter numbers in roman numerals): ");
              
              boolean allLetters=true;
              String firstName = scInput.nextLine();
              char[] firstNameChars = firstName.toCharArray(); // This checks if the country is only letters
              for (char c: firstNameChars) {
                  if (!Character.isLetter(c) && c!=' ') {
                      allLetters=false;
                  }
              }
              while (!allLetters) {
                  int count=0;
                  System.out.println("Please enter a valid first name: ");
                  firstName=scInput.nextLine();
                  firstNameChars=firstName.toCharArray();
                  for (char c: firstNameChars) {
                      if (Character.isLetter(c)||c==' ') {
                          count++;
                      }
                  }
                  if (count==firstNameChars.length) {
                      allLetters=true;
                  }
              }
              
              System.out.println("Author last name: ");
              allLetters=true;
              String lastName = scInput.nextLine();
              char[] lastNameChars = lastName.toCharArray(); // This checks if the country is only letters
              for (char c: lastNameChars) {
                  if (!Character.isLetter(c)&&c!=' ') {
                      allLetters=false;
                  }
              }
              while (!allLetters) {
                  int count=0;
                  System.out.println("Please enter a valid last name: ");
                  lastName=scInput.nextLine();
                  lastNameChars=lastName.toCharArray();
                  for (char c: lastNameChars) {
                      if (Character.isLetter(c)|| c==' ') {
                          count++;
                      }
                  }
                  if (count==lastNameChars.length) {
                      allLetters=true;
                  }
              }
              
              System.out.println("Author's number of published books: ");
              while (!(scInput.hasNextInt())) {
                  System.out.println("Please enter an integer value.");
                  scInput.next();   
              }
              
              int tempNumber = scInput.nextInt();
              while (tempNumber<=0) {
                  System.out.println("Please enter a positive integer.");
                  tempNumber=scInput.nextInt();
              }
              int amountOfBooks = tempNumber;
              scInput.nextLine();
              Author author = new Author(lastName,firstName,amountOfBooks);
              
              // PUBLISHER
              System.out.println("\nPUBLISHER INFO");
              System.out.println("Publisher name: "); // Can also include a number 
              String publisherName = scInput.nextLine();
              System.out.println("Publisher country: ");
              
              allLetters=true;
              String publisherCountry = scInput.nextLine();
              char[] countryChars = publisherCountry.toCharArray(); // This checks if the country is only letters
              for (char c: countryChars) {
                  if (!Character.isLetter(c)&&c!=' ') {
                      allLetters=false;
                  }
              }
              while (!allLetters) {
                  int count=0;
                  System.out.println("Please enter a valid country name: ");
                  publisherCountry=scInput.nextLine();
                  countryChars=publisherCountry.toCharArray();
                  for (char c: countryChars) {
                      if (Character.isLetter(c)||c==' ') {
                          count++;
                      }
                  }
                  if (count==countryChars.length) {
                      allLetters=true;
                  }
              }
              
              Publisher publisher = new Publisher(publisherName,publisherCountry);
              
              // EDITION
              System.out.println("\nEDITION INFO");
              System.out.println("Book has a version? (Y/N)");
              String input = scInput.nextLine();
              while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
                  System.out.println("Try again. Please type Y or N.");
                  input=scInput.nextLine();
              }
              if (input.equalsIgnoreCase("Y")) {
                  System.out.println("Enter the edition: ");
                  while (!scInput.hasNextInt()) {
                      System.out.println("Please enter an integer.");
                      scInput.next();
                  }
                  
                  int tempEdition = scInput.nextInt();  // Store the valid integer input
                  while (tempEdition <= 0) {  // Check >0
                  System.out.println("Please enter a positive integer.");
                  tempEdition = scInput.nextInt();  
                  }
                  
                  edition = tempEdition;
                  scInput.nextLine();
                  book = new Book(bookTitle,author,publisher,edition);
              }
              else {
                  book = new Book(bookTitle,author,publisher);
              }
              
              // PRICE
              System.out.println("\nPRICE INFO");
              System.out.printf("Do you want to set a price other  than the default %.2f CAD (Adjusts with inflation)? (Y/N)",book.getPrice());
              String secondInput = scInput.nextLine();
              while (!secondInput.equalsIgnoreCase("Y") && !secondInput.equalsIgnoreCase("N")) {
                  System.out.println("Try again. Please type Y or N.");
                  secondInput=scInput.nextLine();
              }
              if (secondInput.equalsIgnoreCase("Y")) {
                  System.out.println("Enter the price: ");
                  while (!scInput.hasNextDouble()) {
                      System.out.println("Please enter a double value.");
                      secondInput= scInput.nextLine();
                  }
                  book.setPrice(scInput.nextDouble());
                  scInput.nextLine();
              }
              arrayOfBooks[i]=book;
              
              // SALE NUMBERS
              System.out.println("SALE NUMBERS");
              System.out.println("Enter sale numbers for each month (0 if nothing): ");
              int[] sales = new int[6];
              for (int j = 0; j < 6; j++) {
                  if (scInput.hasNextInt()) {
                      sales[j] = scInput.nextInt();
                  } 
                  else {
                      System.out.println("Please enter integer values.");
                      j=0;
                      for (int k=0; k<6; k++) {
                          sales[j]=0;
                      }
                      scInput.next();
                  }
              }
              for (int j=0;j<6;j++) {
                  book.setSaleNumbers(sales[j], j);
              }
         } 
           // RETURNING
           System.out.println("\n \n");
           return arrayOfBooks;
       }
       
       public static void getSaleInfo() {
           
           // SELECTION SORT
           for (int i=0; i<arrayOfBooks.length;i++) {
               int maxIndex=i;
               for (int j=i+1; j<arrayOfBooks.length;j++) {
                   if (arrayOfBooks[j].getTotalSold()>arrayOfBooks[maxIndex].getTotalSold()) {
                       maxIndex=j;
                   }
                   Book temp = arrayOfBooks[maxIndex];
                   arrayOfBooks[maxIndex]=arrayOfBooks[i];
                   arrayOfBooks[i]=temp;
               }
           }
           
           // PRINTING ALL
           System.out.print("The following are the books with their total sales in descending order: ");
           for (int i=0; i<arrayOfBooks.length;i++) {
               // BASICS
               System.out.println("\n" + arrayOfBooks[i].getTitle());
               
               // AUTHOR INFO
               System.out.println("AUTHOR NAME: " + arrayOfBooks[i].getAuthor().getFirstName() + " " + arrayOfBooks[i].getAuthor().getLastName());
               System.out.println("AMOUNT OF BOOKS PUBLISHED BY THIS AUTHOR: " + arrayOfBooks[i].getAuthor().getNoOfBooks());
               
               // PUBLISHER INFO
               System.out.println("\nPUBLISHED BY: " + arrayOfBooks[i].getPublisher().getPubName());
               System.out.println("PUBLISHED IN: " + arrayOfBooks[i].getPublisher().getCountry());
               
               // EDITION AND PRICE
               System.out.println("\nEDITION: " + arrayOfBooks[i].getEdition());
               System.out.printf("LISTED MSRP (MODERN SELLER RETAIL PRICE): %.2f",arrayOfBooks[i].getPrice());
               System.out.println("\n \n");
           }
       }
       
       public static void getPriceInfo() {
           
           // SELECTION SORT
           for (int i=0; i<arrayOfBooks.length;i++) {
               int maxIndex=i;
               for (int j=i+1; j<arrayOfBooks.length;j++) {
                   if (arrayOfBooks[j].getPrice()>arrayOfBooks[maxIndex].getPrice()) {
                       maxIndex=j;
                   }
                   Book temp = arrayOfBooks[maxIndex];
                   arrayOfBooks[maxIndex]=arrayOfBooks[i];
                   arrayOfBooks[i]=temp;
               }
           }
           
           // PRINTING ALL
           System.out.print("The following are the books with their price in descending order: ");
           for (int i=0;i<arrayOfBooks.length;i++) {
               // BASICS
               System.out.println("\n" + arrayOfBooks[i].getTitle());
               
               // AUTHOR INFO
               System.out.println("AUTHOR NAME: " + arrayOfBooks[i].getAuthor().getFirstName() + " " + arrayOfBooks[i].getAuthor().getLastName());
               System.out.println("AMOUNT OF BOOKS PUBLISHED BY THIS AUTHOR: " + arrayOfBooks[i].getAuthor().getNoOfBooks());
               
               // PUBLISHER INFO
               System.out.println("\nPUBLISHED BY: " + arrayOfBooks[i].getPublisher().getPubName());
               System.out.println("PUBLISHED IN: " + arrayOfBooks[i].getPublisher().getCountry());
               
               // EDITION AND PRICE
               System.out.println("\nEDITION: " + arrayOfBooks[i].getEdition());
               System.out.printf("LISTED MSRP (MODERN SELLER RETAIL PRICE): %.2f",arrayOfBooks[i].getPrice());
               System.out.println("\n \n");
           }
       }
       
       public static void getBookDetails() {
           System.out.println("Here are all the books and their information:");
           for (int i=0; i<arrayOfBooks.length;i++) {
               // BASICS
               System.out.println("\n" + arrayOfBooks[i].getTitle());
               
               // AUTHOR INFO
               System.out.println("AUTHOR NAME: " + arrayOfBooks[i].getAuthor().getFirstName() + " " + arrayOfBooks[i].getAuthor().getLastName());
               System.out.println("AMOUNT OF BOOKS PUBLISHED BY THIS AUTHOR: " + arrayOfBooks[i].getAuthor().getNoOfBooks());
               
               // PUBLISHER INFO
               System.out.println("\nPUBLISHED BY: " + arrayOfBooks[i].getPublisher().getPubName());
               System.out.println("PUBLISHED IN: " + arrayOfBooks[i].getPublisher().getCountry());
               
               // EDITION AND PRICE
               System.out.println("\nEDITION: " + arrayOfBooks[i].getEdition());
               System.out.printf("LISTED MSRP (MODERN SELLER RETAIL PRICE): %.2f",arrayOfBooks[i].getPrice());
               System.out.println("\n \n");
           }
       }
       
    }