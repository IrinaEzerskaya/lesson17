package com.company;

import java.util.Stack;

// Таки класс валидатора
public class BracketsValidator {

    // Текстовый сет для проверки
    private Stack<Character> stack = new Stack<Character>();

    // Проверка открытой скобки
    private boolean isOpeningBracket(char bracket) {
        return "({[".indexOf(bracket) != -1;
    }

    // Проверка закрытой скобки
    private boolean isClosingBracket(char bracket) {
        return ")}]".indexOf(bracket) != -1;
    }

    // Проверка любой пары скобок
    private boolean isPair(char opening, char closing) {
        return (opening == '(' && closing == ')')
            || (opening == '[' && closing == ']')
            || (opening == '{' && closing == '}');
    }

    // Метод проверки
    public boolean validate(String input) {
        // открываем итератор по тексту
        for (char c : input.toCharArray()) {
            if (isClosingBracket(c) && stack.isEmpty()) {
                // Ошибка если найдена закрывающая скобка и стек пустой
                return false;
            }
            if (isOpeningBracket(c)) {
                // Все новые открывающие скобки сохраняем в стек
                stack.push(c);
            }
            if (isClosingBracket(c)) {
                // Если найдена закрывающая скобка, и в стеке находится соответствующая пара, то вытаскиваем ее из стека
                if (isPair(stack.peek(), c)) {
                    stack.pop();
                }
            }
        }

        // Если стек пустой после обработки, значит все ок
        return stack.isEmpty();
    }

}