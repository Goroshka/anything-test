package com.koldakov.datastructures;

import java.util.NoSuchElementException;

public class MyQueue<T> {

    private QueueElement<T> firstElement;
    private QueueElement<T> lastElement;
    public int size;

    public void enqueue(T value) {
        QueueElement<T> newElement = new QueueElement<>(value);

        if (firstElement == null) {
            firstElement = newElement;
            lastElement = firstElement;
        } else {
            QueueElement<T> currentLast = lastElement;

            lastElement = newElement;
            lastElement.previousElement = currentLast;

            currentLast.nextElement = lastElement;
        }
        size++;
    }

    public T dequeue() {
        QueueElement<T> element;
        if (firstElement == null) {
            throw new NoSuchElementException("Queue is empty");
        } else if (firstElement == lastElement) {
            element = firstElement;
            firstElement = null;
        } else {
            element = firstElement;
            firstElement = firstElement.nextElement;
        }
        size--;

        return element.value;
    }

    private static class QueueElement<T> {
        final T value;
        QueueElement<T> previousElement;
        QueueElement<T> nextElement;

        public QueueElement(T value) {
            this.value = value;
        }
    }
}
