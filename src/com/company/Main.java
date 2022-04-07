package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Dice round1UserD1 = new Dice();
        Dice round1UserD2 = new Dice();
        Dice round1ComD1 = new Dice();
        Dice round1ComD2 = new Dice();
        ArrayList<Integer> collectResult = new ArrayList<>();

        int sumOfResultU = 0;
        int sumOfResultC = 0;
        for (int i = 0; i < 3; i++) {
            int predictedNumUser = predictNumber();
            int predictedNumCom = predictedNCom();
            int sumOfDiceUser = round1UserD1.rollTheDice() + round1UserD2.rollTheDice();
            int sumOfDiceCom = round1ComD1.rollTheDice() + round1ComD2.rollTheDice();
            int resultUser = result(sumOfDiceUser, predictedNumUser);
            int resultCom = result(sumOfDiceCom, predictedNumCom);
            sumOfResultU += resultUser;
            sumOfResultC += resultCom;
            currentWinner(resultUser, resultCom);

            collectResult.add(predictedNumUser);
            collectResult.add(predictedNumCom);
            collectResult.add(sumOfDiceUser);
            collectResult.add(sumOfDiceCom);
            collectResult.add(resultUser);
            collectResult.add(resultCom);

            System.out.println("--------------------------------------\n");
        }
        System.out.println("------------------Finish Game-------------------\n");
        int j = 1;
        System.out.println("Round  |           User |        Computer");
        for (int i = 0; i < collectResult.size(); i = i + 6) {

                System.out.println("-------+----------------+------------------");
                System.out.printf("       | Predicted:  %d | Predicted:  %d \n", collectResult.get(i), collectResult.get(i + 1));
                System.out.printf(" - %d - | Dice:       %d | Dice:       %d \n", j, collectResult.get(i + 2), collectResult.get(i + 3));
                System.out.printf("       | Result:     %d | Result:     %d \n", collectResult.get(i + 4), collectResult.get(i + 5));
            j++;
            if (i == 12) {
                break;
            }
        }
        System.out.println("-------+----------------+------------------");
        System.out.printf("Total  | Points:  %d    | Points:    %d \n", sumOfResultU, sumOfResultC);
         if (sumOfResultU > sumOfResultC) {
             System.out.printf("\n\nUser won %d points more. Congratulations!\n", sumOfResultU - sumOfResultC);
         }
         else if (sumOfResultU < sumOfResultC) {
             System.out.printf("\nComputer won %d points more. Congratulations!\n", sumOfResultC - sumOfResultU);
         }
         else System.out.println("\nThe result is draw");
    }

    public static int predictNumber() {
        Scanner scanner = new Scanner(System.in);
        int numberUser;
        System.out.print("Predict amount of points from 2 to 12: ");
        do {
            numberUser = scanner.nextInt();
            if (numberUser < 2 || numberUser > 12) {
                System.out.println("Please enter a number between 2 and 12");
            }
        }
        while (numberUser < 2 || numberUser > 12);
        return numberUser;
    }

    public static int result(int valueOfDice, int numberPredicted) {
        return valueOfDice- Math.abs(valueOfDice - numberPredicted) * 2;
    }

    public static int predictedNCom() {
        Random random = new Random();
        return random.nextInt(11) + 2;
    }

    public static void currentWinner(int resultOfUser, int resultOfCom) {
        System.out.println("------   Current score   ------");
        System.out.printf("User: %d points\n", resultOfUser);
        System.out.printf("Computer: %d points\n", resultOfCom);

        if (resultOfUser > resultOfCom) {
            System.out.printf("\nUser is ahead by %d points!\n", resultOfUser - resultOfCom);

        }
        else if (resultOfUser < resultOfCom) {
            System.out.printf("\nComputer is ahead by %d points!\n",Math.abs(resultOfUser - resultOfCom));
        }
        else System.out.println("\nThe result is draw");
    }

}
