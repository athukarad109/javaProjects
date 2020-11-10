package myPcka;

import java.util.ArrayList;
import java.util.Scanner;

class library{
    int password;
    public void setPassword(int password) {
        this.password = password;
    }
    boolean correctPass(int pass){
        if (this.password == pass){
            return true;
        }else {
            return false;
        }
    }

    Scanner sc = new Scanner(System.in);
    ArrayList<String>books = new ArrayList<>();
    void showAvailable(){
        for (int i = 0; i < books.toArray().length; i++){
            System.out.println("\t" + this.books.get(i));
        }

    }
    void addBook(){
        System.out.println("What do you want to add :");
        String name = sc.next();
        this.books.add(name);
        System.out.println(name +  " added");
    }
    void borrowBook(){
        System.out.println("Which book you want to borrow :");
        String name = sc.next();
        this.books.remove(name);
    }
    void returnBook(){
        System.out.println("What do you want to return :");
        String name = sc.next();
        this.books.add(name);
        System.out.println(name +  " returned");
    }

}

public class libraryProto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        library lib = new library();
        lib.setPassword(12345);
        lib.books.add("Yugandhar");
        lib.books.add("Mrutyunjay");
        lib.books.add("Durdamya");
        lib.books.add("Swami");
        System.out.println("Enter your name : ");
        String name = sc.next();
        System.out.println("\t Welcome " + name);
        System.out.println("Please Enter your password :");
        int pass = sc.nextInt();

        boolean isBorrow = false;
        boolean gameOn;

        if (lib.correctPass(pass)){
            gameOn = true;
        }else {
            gameOn = false;
            System.out.println("Incorrect password");
        }
        while (gameOn){
            System.out.println("What do you want to do : " +
                    "\t 1. Show available books" +
                    "\t 2. Add a new book" +
                    "\t 3. Borrow a book" +
                    "\t 4. Return a book" +
                    "\t 5. Quit");
            int choice = sc.nextInt();
            if (choice == 5){
                gameOn = false;
            }
            else if (choice == 1){
                lib.showAvailable();
            }else if (choice == 2){
                lib.addBook();
            }else if (choice == 3){
                lib.borrowBook();
                isBorrow = true;
            }else if (choice == 4){
                if (isBorrow){
                      lib.returnBook();
                }else {
                    System.out.println("Nothing is borrowed");
                }
            }
        }

    }
}
