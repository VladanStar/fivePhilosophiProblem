package com.company;



public class Main {

    public static void main(String[] args) {
        // write your code here
        Filozof[] filozofi = new Filozof[5];
        Object[] viljuske = new Object[5];
        for (int i = 0; i < viljuske.length; i++) {
            viljuske[i] = new Object();

        }
            for (int i = 0; i < filozofi.length; i++) {
                Object levaViljuska = viljuske[i];
                Object desnaViljuska = viljuske[(i + 1) % viljuske.length];


                if (i == filozofi.length - 1) {
                    filozofi[i] = new Filozof(desnaViljuska, levaViljuska);
                } else {
                    filozofi[i] = new Filozof(levaViljuska, desnaViljuska);
                }
                Thread t = new Thread(filozofi[i], " Filozof " + (i + 1));
                t.start();
            }
        }


}
