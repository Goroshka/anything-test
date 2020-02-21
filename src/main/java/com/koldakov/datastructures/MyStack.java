package com.koldakov.datastructures;

import java.util.NoSuchElementException;

public class MyStack<T> {

    private StackElement<T> upperElement;
    public int size;

    public void push(T value) {
        if (upperElement == null) {
            upperElement = new StackElement<>(value);
        } else {
            StackElement<T> previousElement = upperElement;
            upperElement = new StackElement<>(value);
            upperElement.previousElement = previousElement;
        }
        size++;
    }

    public T pop() {
        if (upperElement == null) {
            throw new NoSuchElementException("Stack is empty");
        }
        StackElement<T> currentUpperElement = upperElement;
        upperElement = upperElement.previousElement;
        size--;

        return currentUpperElement.value;
    }

    public T peek() {
        if (upperElement == null) {
            throw new NoSuchElementException("Stack is empty");
        }

        return upperElement.value;
    }

    @Override
    public String toString() {
        if (upperElement == null) {
            return "Stack is empty";
        }

        StringBuilder result = new StringBuilder("Stack is: [");
        StackElement<T> current = upperElement;
        for (int i = 0; i < size; i++) {
            result.append(current.value).append(", ");
            current = current.previousElement;
        }
        return result.delete(result.length() - 2, result.length()).append("]").toString();
    }

    private static class StackElement<T> {
        final T value;
        StackElement<T> previousElement;

        StackElement(T value) {
            this.value = value;
        }
    }
}
