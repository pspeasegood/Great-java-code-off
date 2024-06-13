package org.decoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CaesarCipher {

    /**
     * Method to decode the message.
     * @param inputToDecode - Input message to Decode
     * @param messageShiftedBy - Positive/Negative Shift key
     * @return Decoded Message
     */
    public String decodeMessage(String inputToDecode, int messageShiftedBy) {
        StringBuilder decodedMessage = new StringBuilder();
        while (messageShiftedBy > 26) {
            messageShiftedBy = messageShiftedBy - 26;
        }
        while (messageShiftedBy < -26) {
            messageShiftedBy = messageShiftedBy + 26;
        }
        for (Character input : inputToDecode.toCharArray()) {
            String decoded = getDecodedCharacter(messageShiftedBy, input);
            decodedMessage.append(decoded);
        }
        if (messageShiftedBy == 26 || messageShiftedBy == 0) {
            log.warn("message will be the same after decoding");
        }

        return decodedMessage.toString();
    }

    /**
     * Method to encode the message.
     * @param inputToEncode - Input message to Encode
     * @param messageShiftedBy - Positive/Negative Shift key
     * @return Encoded Message
     */
    public String encodeMessage(String inputToEncode, int messageShiftedBy) {
        StringBuilder encodedMessage = new StringBuilder();
        //Reduce value to be between 0 & 26
        while (messageShiftedBy > 26) {
            messageShiftedBy = messageShiftedBy - 26;
        }

        while (messageShiftedBy < -26) {
            messageShiftedBy = messageShiftedBy + 26;
        }
        if (messageShiftedBy == 26 || messageShiftedBy == 0) {
            log.warn("message will look the same after encoding");
        }
        for (Character input : inputToEncode.toCharArray()) {
            String encodedChar = getEncodedCharacter(messageShiftedBy, input);
            encodedMessage.append(encodedChar);
        }

        return encodedMessage.toString();
    }


    private static String getEncodedCharacter(int messageShiftedBy, Character input) {
        String encoded;
        if (Character.isLetter(input)) {
            int encodedValue = input + messageShiftedBy;
            if (Character.isUpperCase(input)) {
                if (encodedValue < 'A' || encodedValue > 'Z') {
                    encodedValue = messageShiftedBy < 0 ? encodedValue + 26 : encodedValue - 26;
                }
            } else {
                if (encodedValue < 'a' || encodedValue > 'z') {
                    encodedValue = messageShiftedBy < 0 ? encodedValue + 26 : encodedValue - 26;
                }
            }
            encoded = Character.toString(encodedValue);

        } else {
            encoded = input.toString();
        }
        return encoded;
    }

    private static String getDecodedCharacter(int messageShiftedBy, Character input) {
        String decoded;
        if (Character.isLetter(input)) {
            int decodedValue = input - messageShiftedBy;
            if (Character.isUpperCase(input)) {
                if (decodedValue < 'A' || decodedValue > 'Z') {
                    decodedValue = messageShiftedBy < 0 ? decodedValue - 26 : decodedValue + 26;
                }
            } else {
                if (decodedValue < 'a' || decodedValue > 'z') {
                    decodedValue = messageShiftedBy < 0 ? decodedValue - 26 : decodedValue + 26;
                }
            }
            decoded = Character.toString(decodedValue);

        } else {
            decoded = input.toString();
        }
        return decoded;
    }

}
