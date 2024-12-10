package com.company;

public class Main {

        public static void main(String[] args) {
            int i = 65;
            while(i <= 90){
                System.out.println((char) (i + 32) + " " + (char) i);
                i++;
            }

//        System.out.println((int) "?");

            int j = 0;
            while(j <= 400){
                System.out.println((char) j);
                j++;
            }
        }

}
