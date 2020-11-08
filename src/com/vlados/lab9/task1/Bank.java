package com.vlados.lab9.task1;

import javax.swing.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private int numOfAccounts;
    private Account [] accounts;
    private Lock lock;
    private Condition condition;

    Bank(int n) {
        this.numOfAccounts = n;
        accounts = new Account[numOfAccounts];
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
        for(int i = 0; i < numOfAccounts; i++) {
            accounts[i] = new Account(Math.random() * 1000);
        }
    }

    public int getNumOfAccounts() {
        return numOfAccounts;
    }

    public double getTotalSum() {
        double totalSum = 0;
        for (Account a : accounts) {
            totalSum += a.getSum();
        }
        return totalSum;
    }

    public void transfer(int from, int to, double sum) throws InterruptedException {
        lock.lock();
        try {
            while (accounts[from].getSum() < sum) condition.await();
            accounts[from].withdraw(sum);
            accounts[to].deposit(sum);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

class Account {
    private double sum;

    Account(double sum) {
        this.sum = sum;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void withdraw(double sum) {
        this.sum -= sum;
    }

    public void deposit(double sum) {
        this.sum += sum;
    }
}
