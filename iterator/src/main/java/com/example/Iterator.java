package com.example;

public interface Iterator<E> {
    public abstract boolean hasNext();
    public abstract E next();
}