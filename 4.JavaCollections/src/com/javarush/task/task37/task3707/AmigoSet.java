package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        this.map = new HashMap<>((int)(Math.max(16f,Math.ceil(collection.size()/.75f))));
        addAll(collection);
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeInt(map.size());
        outputStream.writeInt(HashMapReflectionHelper.<Integer>callHiddenMethod(map, "capacity"));
        outputStream.writeFloat(HashMapReflectionHelper.<Float>callHiddenMethod(map, "loadFactor"));
        for (E element: map.keySet()) {
            outputStream.writeObject(element);
        }
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        int size = inputStream.readInt();
        int capacity = inputStream.readInt();
        float loadFactor = inputStream.readFloat();
        map = new HashMap<>(capacity,loadFactor);
        for (int i = 0; i < size; i++) {
            map.put((E)inputStream.readObject(), PRESENT);
        }
    }


    @Override
    public boolean add(E e) {
        int was = this.map.size();
        this.map.put(e, PRESENT);
        int now = this.map.size();
        if (was == now) return false;
        else return true;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey((E)o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        if (map.remove((E)o)!=null){
            return true;
        }else return false;
    }

    @Override
    public Object clone(){
        AmigoSet<E> clonedSet = null;
        try{
            clonedSet = new AmigoSet<E>(this.map.keySet());
            clonedSet.map = (HashMap<E, Object>) map.clone();
        }catch (Exception e){
            throw new InternalError();
        }
        return clonedSet;
    }


}
