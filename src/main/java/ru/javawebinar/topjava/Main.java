package ru.javawebinar.topjava;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger atm = new AtomicInteger();

    public static void main(String[] args) {

        System.out.println(atm.incrementAndGet());
        System.out.println(atm.incrementAndGet());
    }
}
