package edu.miracosta.cs113;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CircularArrayQueue<E> implements Queue<E>{
    // data fields
    int size;
    int capacity;
    int front;
    int rear;
    E[] queueData;

    public CircularArrayQueue(int _capacity) {
        capacity = _capacity;
        size = 0;
        queueData = (E[]) new Object[capacity];
        front = 0;
        rear = capacity-1;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if(!offer(e)) {
            throw new IllegalStateException();
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E e) {
        if(size == capacity) {
            return false;
        }
        rear = (rear + 1) % capacity;
        queueData[rear] = e;
        size++;
        return true;
    }

    @Override
    public E remove() {
        E obj = poll();
        if(obj == null) {
            throw new NoSuchElementException();
        }
        return obj;
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }
        E result = queueData[front];
        front = (front + 1) % capacity;
        size--;
        return result;
    }

    @Override
    public E element() {
        E obj = peek();
        if(obj == null) {
            throw new NoSuchElementException();
        }
        return obj;
    }

    @Override
    public E peek() {
        if(size == 0) {
            return null;
        }
        return queueData[front];
    }
}
