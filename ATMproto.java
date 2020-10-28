package com.company;
import java.util.Scanner;

class account{
    int balance;
    int accNo;
    String password;
    public void setAccNo(int accNo){
        this.accNo = accNo;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int addBalance(int amount){
        return balance + amount;
    }
    public int withdraw(int amount){
        return balance - amount;
    }
    public boolean accNo(int acc){
        boolean correct;
        if (acc == accNo){
            correct = true;
        }else {
            correct = false;
        }
        return correct;
    }
    public boolean verify(String userPassword){
        boolean correct;
        if (password.equals(userPassword)){
            correct = true;
        }else {
            correct = false;
        }
        return correct;
    }
}

public class ATMproto {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        account Ira = new account();
        Ira.setAccNo(123456789);
        Ira.setPassword("DadaIsNice");
        Ira.setBalance(50000);
        System.out.println("Enter account number : ");
        int enterAcc = input.nextInt();
        if (Ira.accNo(enterAcc)){
            System.out.println("Enter password");
            String enterPass = input.next();
            if (Ira.verify(enterPass)){
                System.out.println("Welcome !");
                System.out.println("What do you want do :");
                System.out.println("Enter 1 for adding amount. Enter 2 withdrawing amount.");
                int choice = input.nextInt();
                if (choice == 1){
                    System.out.println("Enter amount to deposit : ");
                    int n = input.nextInt();
                    System.out.println("Success... Your total balance is : ");
                    System.out.println(Ira.addBalance(n));
                }else if (choice == 2){
                    System.out.println("Enter amount to withdraw : ");
                    int n = input.nextInt();
                    System.out.println("Success... Your total balance is : ");
                    System.out.println(Ira.withdraw(n));
                }
            }else {
                System.out.println("Wrong Password !");
            }
        }else {
            System.out.println("Account not found !");
        }
    }
}
