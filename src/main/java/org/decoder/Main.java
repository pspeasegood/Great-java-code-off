package org.decoder;

public class Main {

    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher();
        String message = "Hello";

        String output = cipher.encodeMessage(message, 100);
        System.out.println(output);


    }
}