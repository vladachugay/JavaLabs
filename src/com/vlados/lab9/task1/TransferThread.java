package com.vlados.lab9.task1;

public class TransferThread implements Runnable{
    private Bank bank;

    TransferThread(Bank bank) {
        this.bank = bank;
    }
    @Override
    public void run() {
        int n = bank.getNumOfAccounts();
        try {
            bank.transfer((int)(Math.random() * n), (int)(Math.random() * n), Math.random() * 100);
        } catch (InterruptedException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
