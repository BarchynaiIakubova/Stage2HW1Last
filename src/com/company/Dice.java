package com.company;

import java.util.Random;

public class Dice {
    private int valueOfDice;

    public Dice() {
    }

    public int getValueOfDice() {
        return valueOfDice;
    }

    public void setValueOfDice(int valueOfDice) {
        this.valueOfDice = valueOfDice;
    }

    public int rollTheDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public void printDice() {
        valueOfDice = rollTheDice();
        //System.out.println(valueOfDice);
        System.out.println("+-------+");
        switch (valueOfDice) {
            case 6 -> System.out.println("| # # # |\n|       |\n| # # # |");
            case 5 -> System.out.println("| #   # |\n|   #   |\n| #   # |");
            case 4 -> System.out.println("| #   # |\n|       |\n| #   # |");
            case 3 -> System.out.println("| #     |\n|   #   |\n|     # |");
            case 2 -> System.out.println("| #     |\n|       |\n|     # |");
            case 1 -> System.out.println("|       |\n|   #   |\n|       |");
        }
        System.out.println("+-------+");


    }

}

