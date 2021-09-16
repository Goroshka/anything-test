package com.koldakov.datastructures;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> {

    private ListElement<T> firstElement;
    public int size;

    public void add(T value) {
        ListElement<T> temp = new ListElement<>(value);
        if (firstElement == null) {
            firstElement = temp;
        } else {
            ListElement<T> current = firstElement;
            while (current.nextElement != null) {
                current = current.nextElement;
            }
            current.nextElement = temp;
        }
        size++;
    }

    public void add(T value, int index) {
        if (index < 0 || index > size) {
            throw new NoSuchElementException("Index out of bounds");
        }

        ListElement<T> newElement = new ListElement<>(value);
        if (index == 0) {
            newElement.nextElement = firstElement;
            firstElement = newElement;
        } else {
            ListElement<T> currentElement = firstElement;
            for (int i = 0; i < index - 1; i++) {
                currentElement = currentElement.nextElement;
            }
            newElement.nextElement = currentElement.nextElement;
            currentElement.nextElement = newElement;
        }

        size++;
    }

    public T get(int index) {
        if (index >= size) {
            throw new NoSuchElementException("Index out of bounds");
        }

        ListElement<T> current = firstElement;
        for (int i = 0; i < index; i++) {
            current = current.nextElement;
        }
        return current.value;
    }

    public void remove(int index) {
        if (index >= size) {
            throw new NoSuchElementException("Index out of bounds");
        }

        ListElement<T> current = firstElement;
        for (int i = 0; i < index - 1; i++) {
            current = current.nextElement;
        }
        ListElement<T> elementToDelete = current.nextElement;
        current.nextElement = elementToDelete.nextElement;

        size--;
    }

    public void replace(T value, int index) {
        if (index >= size) {
            throw new NoSuchElementException("Index out of bounds");
        }

        ListElement<T> newElement = new ListElement<>(value);
        if (index == 0) {
            newElement.nextElement = firstElement.nextElement;
            firstElement = newElement;
        } else {
            ListElement<T> currentElement = firstElement;
            for (int i = 0; i < index - 1; i++) {
                currentElement = currentElement.nextElement;
            }
            currentElement.nextElement = newElement;
        }
    }

    public void sort(Comparator<T> comparator) {
        MyLinkedList<T> temporaryList = new MyLinkedList<>();

        for (int i = 0; i < this.size; i++) {
            int j = 0;
            while (j < i && comparator.compare(temporaryList.get(j), this.get(i)) < 0) {
                j++;
            }
            temporaryList.add(this.get(i), j);
        }

        for (int i = 0; i < temporaryList.size; i++) {
            this.replace(temporaryList.get(i), i);
        }
    }

    public void reverse() {
        ListElement<T> prev = null;
        ListElement<T> current = firstElement;
        ListElement<T> next = null;

        while (current != null) {
            next = current.nextElement;
            current.nextElement = prev;
            prev = current;
            current = next;
        }
        firstElement = prev;
    }

    @Override
    public String toString() {
        if (firstElement == null) {
            return "List is empty";
        }

        StringBuilder result = new StringBuilder("List is: [");
        ListElement<T> current = firstElement;
        for (int i = 0; i < size; i++) {
            result.append(current.value).append(", ");
            current = current.nextElement;
        }
        return result.delete(result.length() - 2, result.length()).append("]").toString();
    }

    private static class ListElement<T> {
        final T value;
        ListElement<T> nextElement;

        ListElement(T value) {
            this.value = value;
        }
    }
}
