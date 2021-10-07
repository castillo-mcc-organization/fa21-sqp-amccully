package edu.miracosta.cs113;

import edu.miracosta.cs113.StackInterface;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E> {

    private ArrayList<E> stackData;

    public ArrayListStack() {
        stackData = new ArrayList<E>();
    }
    @Override
    public boolean empty() {
        return stackData.isEmpty();
    }

    @Override
    public E peek() {
        try {
            return stackData.get(stackData.size() - 1);
        }
        catch(IndexOutOfBoundsException ioobe) {
            throw new EmptyStackException();
        }
    }

    @Override
    public E pop() {
        try {
            return stackData.remove(stackData.size()-1);
        }
        catch(IndexOutOfBoundsException ioobe) {
            throw new EmptyStackException();
        }
    }

    @Override
    public E push(E obj) {
        stackData.add(obj);
        return obj;
    }

}
