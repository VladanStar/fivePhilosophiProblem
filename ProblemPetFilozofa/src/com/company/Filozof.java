package com.company;

public class Filozof implements Runnable {
    private final Object levaViljuska;
    private final Object desnaViljuska;

    public Filozof(Object levaViljuska, Object desnaViljuska) {
        this.levaViljuska = levaViljuska;
        this.desnaViljuska = desnaViljuska;
    }

    private void izvrsiAkciju(String akcija) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " akcija");
        Thread.sleep((long) (Math.random() * 100));

    }


    @Override
    public void run() {
        try {
            while (true) {
                try {
                    izvrsiAkciju(System.nanoTime() + " razmislja");
                    synchronized (levaViljuska) {
                        izvrsiAkciju(System.nanoTime() + " uzeo levu viljusku");
                        synchronized (desnaViljuska) {
                            izvrsiAkciju(System.nanoTime() + "uzeo desnu viljusku - jede");
                            izvrsiAkciju(System.nanoTime() + "Spusta desnu viljusku");
                            izvrsiAkciju(System.nanoTime() + " Spusta levu viljusku razmislja - ponovo razmislja");

                        }
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }

        } finally {

        }
    }
}
