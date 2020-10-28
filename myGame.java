package com.company;
import java.util.Scanner;
import java.util.Random;

class player{
    public int health = 0;

    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }
    int damage(int damage){
        return damage;
    }
}
class gameManager{
    public void check(int score){
        if (score == 50){
            System.out.println("You are genius !");
        }else{
            if (score < 30){
                System.out.println("Work on your maths !");
            }else {
                System.out.println("You need to work !");
            }
        }
    }
    public int difficulty(String dif){
        int n = 0;
        if (dif.equals("d")){
            n += 100;
        }else if (dif.equals("e")){
            n+= 10;
        }
        return n;
    }
}

public class myGame {
    public static void main(String[] args) {
        System.out.println("Choose the difficulty for your game : type d for difficult and e for easy");
        System.out.println();
        System.out.println("you will be asked sum of some numbers 5 times. If you got correct answer +10, and for wrong answer -10");
        player Ira = new player();
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        gameManager gm = new gameManager();
        String dif = input.next();
        int n = gm.difficulty(dif);
        for(int i = 0; i < 5; i++){
            int num1 = random.nextInt(n);
            int num2 = random.nextInt(n);
            System.out.println("Enter sum of "+ num1 + " + " + num2);
            int playerChoice = input.nextInt();
            int answer = num1 + num2;
            if (playerChoice == answer){
                System.out.println("You win !");
                Ira.setHealth(Ira.health + Ira.damage(10));
            }else {
                System.out.println("You loose !");
                Ira.setHealth(Ira.health - Ira.damage(10));
            }
        }
        System.out.println("Your score is " + Ira.getHealth());
        System.out.println();
        gm.check(Ira.getHealth());
    }

}
