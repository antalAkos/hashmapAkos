package com.codecool.hashmap;

public class Main {

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.add("first", 1);
        hashMap.add("second", 2);
        System.out.println(hashMap.getValue("second"));
        //hashMap.getValue("asd");
        hashMap.remove("second");
        hashMap.clearAll();
    }
}
