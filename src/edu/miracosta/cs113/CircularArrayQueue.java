package edu.miracosta.cs113;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * CircularArrayQueue.java : An implementation of circular array queue using methods from Java's Queue interface
 *
 * @author      Aaron McCully <amccully2001@gmail.com>
 * @version     1.0
 *
 * @param <E>   generic type of the data stored in a queue
 */
public class CircularArrayQueue<E> implements Queue<E> {

    // data fields
    int size;
    int capacity;
    int front;
    int rear;
    E[] queueData;

    /**
     * A constructor which creates a circular array queue instance with a set capacity
     * Size is set to 0, queue starts as empty
     *
     * @param _capacity an integer that tells us maximum capacity of the queue
     */
    public CircularArrayQueue(int _capacity) {
        capacity = _capacity;
        size = 0;
        queueData = (E[]) new Object[capacity];
        front = 0;
        rear = capacity - 1;
    }

    /**
     * Will double the maximum capacity of the circular array queue instance
     */
    private void reallocate() {
        int newCapacity = capacity * 2;
        E[] newQueueData = (E[]) new Object[newCapacity];
        int i = front;
        for(int j = 0; j < capacity; j++) {
            newQueueData[j] = queueData[i];
            i = (i + 1) % capacity;
        }
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
        queueData = newQueueData;
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
            reallocate();
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
