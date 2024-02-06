package com.src;

import java.awt.*;
import java.util.HashMap;

public class CompareJava11To17Features {

    public static void main(String[] args) {
//        jsonBlock();
//        sqlStatement();
//        improvedSwitch(Fruit.DEFAULT);
//        doSomething();
//        patternMatchingInJava17();
        helpfulNullPointerException();
    }


    public static void doSomething() {
        record Fruit(String name, int price) {
        }
        Fruit fruit = new Fruit("Apple", 100);
        System.out.println(fruit.price());
    }

    // switch pattern
    private static void improvedSwitch(Fruit fruit) {
        String text = switch (fruit) {
            case APPLE, PEAR -> {
                System.out.println("the given fruit was: " + fruit);
                yield "Common fruit";
            }
            case ORANGE, AVOCADO -> "Exotic fruit";
            default -> "Undefined fruit";
        };
        System.out.println(text);
    }

    // text blocks
    private static void jsonBlock() {
        String text = """
                  {
                    "name": "John Doe",
                    "age": 45,
                    "address": "Doe Street, 23, Java Town"
                  }
                """;
        System.out.println(text);
    }

    private static void sqlStatement() {
        String sql = """
                SELECT id, firstName, lastName
                FROM Employee
                WHERE departmentId = "IT"
                ORDER BY lastName, firstName""";
        System.out.println(sql);
    }

    // Pattern Matching with instanceof
    private static void patternMatchingInJava17() {
        Object o = new GrapeClass(Color.BLUE, 2);
        if (o instanceof Grape grape) {
            System.out.println("This grape has " + grape.value() + " pits.");
        }
    }

    private static void helpfulNullPointerException() {
        HashMap<String, Grape> grapes = new HashMap<>();
        grapes.put("grape1", new GrapeClass(Color.BLUE, 2));
        grapes.put("grape2", new GrapeClass(Color.white, 4));
        grapes.put("grape3", null);
        var color = grapes.get("grape3").color();
    }

    enum Fruit {
        APPLE,
        PEAR,
        ORANGE,
        AVOCADO,
        DEFAULT
    }

    interface Grape {
        Color color();

        int value();
    }

    record GrapeClass(Color color, int value) implements Grape {
    }

    // sealed classes
    public abstract sealed class FruitSealed permits AppleSealed, PearSealed {
    }

    public non-sealed class AppleSealed extends FruitSealed {
    }

    public final class PearSealed extends FruitSealed {
    }

    public class AppleImpl extends AppleSealed {
    }
}
