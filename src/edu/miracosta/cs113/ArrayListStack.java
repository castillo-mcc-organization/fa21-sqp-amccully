package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * ArrayListStack.java : An implementation of the stack interface (stack structure) using ArrayList methods
 *
 * @author      Aaron McCully <amccully2001@gmail.com>
 * @version     1.0
 *
 * @param <E>   generic type of the data stored in a stack
 */
public class ArrayListStack<E> implements StackInterface<E> {

    private ArrayList<E> stackData;

    /**
     * Default constructor which creates a stack instance using ArrayList of generic type E
     */
    public ArrayListStack() {
        stackData = new ArrayList<E>();
    }
    @Override
    public boolean empty() {
        return stackData.isEmpty();
    }

    @Override
    public E peek() {
        if(empty()) {
            throw new EmptyStackException();
        }
        return stackData.get(stackData.size() - 1);
    }

    @Override
    public E pop() {
        if(empty()) {
            throw new EmptyStackException();
        }
        return stackData.remove(stackData.size() - 1);
    }

    @Override
    public E push(E obj) {
        stackData.add(obj);
        return obj;
    }

}
