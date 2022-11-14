package org.example;

import java.util.Scanner;

public class flowTest {
    static brute br;

    public static void main(String[] args) {
     br =new brute();
        Scanner console = new Scanner(System.in);
        String num= console.nextLine();
        int t=Integer.parseInt(num);
        Thread myThread = new Thread(br);
        Thread myThread2 = new Thread(br);
        Thread myThread3 = new Thread(br);
        Thread myThread4 = new Thread(br);
        switch (t) {
            case (1):
                myThread.start();
                break;
            case (2):
                    myThread.start();
                    myThread2.start();
                    break;
            case (3):
                        myThread.start();
                        myThread2.start();
                        myThread3.start();
                        break;
            case (4):
                            myThread.start();
                            myThread2.start();
                            myThread3.start();
                            myThread4.start();
                            break;
        }
    }

}
