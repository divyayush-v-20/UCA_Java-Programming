/*
Problem Statement: create a Bank, with the following methods,
    1. Deposit: User will deposit an amount random bw 1->100
    2. Withdraw: Random amount 1->100
        -if balance <= 0(can't withdraw), wait for 2 sec, after that kill that thread
        -else withdraw
 */

public class BankProblem{
    static class Account{
        int balance;
        Account(){
            this.balance = 0;
        }
    }
    static class Deposit extends Thread{
        Account acc;
        Deposit(Account ac){
            this.acc = ac;
        }
        public synchronized void run(){
            int amount = (int)(Math.random() * 100);
            this.acc.balance += amount;
            System.out.println("Deposited " + amount + " to account, current balance: " + this.acc.balance);
        }
    }
    static class Withdraw extends Thread{
        Account acc;
        Withdraw(Account acc){
            this.acc = acc;
        }
        public synchronized void run(){
            int amount = (int)(Math.random() * 100);
            if(this.acc.balance < amount){
                System.out.println("Out of balance");
                try{
                    Thread.sleep(2000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            else{
                this.acc.balance -= amount;
                System.out.println("Withdrawn " + amount + " from account, current balance: " + this.acc.balance);
            }
        }
    }
    public static void main(String[] args){
        Account acc = new Account();
        for(int i = 0; i < 5; i++){
            new Deposit(acc).start();
            new Withdraw(acc).start();
        }
    }
}