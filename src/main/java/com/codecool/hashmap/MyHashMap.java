package com.codecool.hashmap;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashMap<K, V> {

    private int bucketSize = 16;

    // This holds all the data. Its a primitive array where every element is a Linked List.
// They Linked List holds elements of type KeyValue
    private LinkedList<KeyValue>[] elements = new LinkedList[bucketSize];

    public void add(String key,  Integer value) {
        // find out which position of the primitive array to use:
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

            // If the key already exists throw an error.
            // Make a new instance of the KeyValue class, fill it with the key, value parameters, then add it to the list.

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

        // 1. Calculate the hash of the key. This defines which element to get from the "elements" array
        // 2. Find in the List in this position the KeyValue element that has this key, then return its value.
        //    If none of the items in the list has this key throw error.
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
        // This function converts somehow the key to an integer between 0 and bucketSize
        // In C# GetHashCode(), in Java hashCode() is a function of Object, so all non-primitive types
        // can easily be converted to an integer.
    }

    private void resizeIfNeeded(){}
    // If it holds more elements than bucketSize * 2, destroy and recreate it
    // with the double size of the elements array.
    // if it holds less elements than bucketSize / 2, destroy and recreate it
    // with half size of the elements array.
}



