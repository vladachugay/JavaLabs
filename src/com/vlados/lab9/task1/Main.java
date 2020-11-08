package com.vlados.lab9.task1;

public class Main {
    public static void main(String[] args) {
        int numOfAccounts = 10_000;
        Bank bank = new Bank(numOfAccounts);
        Thread[] thread = new Thread[10_000];
        System.out.println("Before transferring: \t" + bank.getTotalSum());
        for(int i = 0; i < thread.length; i++) {
            try {
                thread[i] = new Thread(new TransferThread(bank));
                thread[i].join();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        System.out.println("After transferring: \t" + bank.getTotalSum());
    }
}
