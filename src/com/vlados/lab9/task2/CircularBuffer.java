package com.vlados.lab9.task2;

import java.util.concurrent.locks.*;

public class CircularBuffer {
    private final Lock accessLock = new ReentrantLock();
    private final Condition canWrite = accessLock.newCondition();
    private final Condition canRead = accessLock.newCondition();
    private int size;
    private String[] buffer;
    private int occupiedBuffers = 0;   //кількість зайнятих позицій в буфері
    private int writeIndex = 0;        //індекс для записування наступного значення
    private int readIndex = 0;         //індекс для зчитування наступного значення

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new String[size];
    }

    public void add(String value) {
        accessLock.lock();
        try {
            while (occupiedBuffers == buffer.length)  // якщо/поки буфер повний, ждемо
                canWrite.await();
            buffer[writeIndex] = value;
            writeIndex = (writeIndex + 1) % buffer.length;
            occupiedBuffers++;
            canRead.signal();    // з'явилось значення, щоб зчитати
        } catch (InterruptedException exception) {
            System.out.println(exception.getMessage());
        } finally {
            accessLock.unlock();
        }
    }

    public String get() {
        String value = "";
        accessLock.lock();
        try {
            while (occupiedBuffers == 0)
                canRead.await();
            value = buffer[readIndex];
            readIndex = (readIndex + 1) % buffer.length;
            occupiedBuffers--;
            canWrite.signal();   // звільнилось місце для запису
        } catch (InterruptedException exception) {
            System.out.println(exception.getMessage());
        } finally {
            accessLock.lock();
        }
        return value;
    }
}
