package com.company;

public class Main {

    public static void main(String[] args) {

        String test = "a + (42 - b) * [wtf()] / {(2 + 2)}";
        BracketsValidator validator = new BracketsValidator();
        boolean correct = validator.validate(test);
        System.out.println("Скобки расставлены " + (correct ? "" : "не") + "правильно");

    }
}
