package com.codecool.hashmap;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashMap<K, V> {

    private int bucketSize = 16;

    private LinkedList<KeyValue>[] elements = new LinkedList[bucketSize];

    public void add(String key,  Integer value) {
        int position = getHash(key);
        /*if (Arrays.stream(elements).anyMatch(x -> getHash(x.getFirst().getKey()) == position)) {

        }*/
        for (LinkedList<KeyValue> element : elements) {
            try {
                if (getHash(element.getFirst().getKey()) == position) {
                    throw new IllegalArgumentException("The key already exists!");
                }
            } catch (NullPointerException e) {

            }

        }
        LinkedList list = new LinkedList();
        list.add(new KeyValue(key, value));
        elements[position] = list;

        resizeIfNeeded();
        }

    public Integer getValue(String key) {
        for (LinkedList<KeyValue> element : elements) {
            try {
                if (getHash(element.getFirst().getKey()) == getHash(key)) {
                    return element.getFirst().getValue();
                }
            } catch (NullPointerException e) {

            }

        }

        throw new IllegalArgumentException("There is no such key in the HashMap!");

    }

    public void remove(String key) {
        for (LinkedList<KeyValue> element : elements) {
            try {
                if (getHash(element.getFirst().getKey()) == getHash(key)) {
                    element = new LinkedList<KeyValue>();
                }
            } catch (NullPointerException e) {

            }

        }

    }

    public void clearAll() {
        this.elements = new LinkedList[bucketSize];
    }

    private int getHash(String key) {
        return key.hashCode() & 0x7fffffff % elements.length -1;
    }

    private void resizeIfNeeded(){}

}



