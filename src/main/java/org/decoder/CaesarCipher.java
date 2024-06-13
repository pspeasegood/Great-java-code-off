package org.decoder;

public class CaesarCipher {

    public String decodeMessage(String inputToDecode, int messageShiftedBy) {
        StringBuilder decodedMessage = new StringBuilder();
        while (messageShiftedBy > 26) {
            messageShiftedBy = messageShiftedBy - 26;
        }

        while (messageShiftedBy < -26) {
            messageShiftedBy = messageShiftedBy + 26;
        }
        for (Character input : inputToDecode.toCharArray()) {
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

            decodedMessage.append(decoded);
        }
        return decodedMessage.toString();
    }


    public String encodeMessage(String inputToDecode, int messageShiftedBy) {
        StringBuilder decodedMessage = new StringBuilder();
        while (messageShiftedBy > 26) {
            messageShiftedBy = messageShiftedBy - 26;
        }

        while (messageShiftedBy < -26) {
            messageShiftedBy = messageShiftedBy + 26;
        }
        for (Character input : inputToDecode.toCharArray()) {
            String decoded;
            if (Character.isLetter(input)) {
                int decodedValue = input + messageShiftedBy;
                if ((decodedValue < 'a' && decodedValue > 'Z') || decodedValue < 'A' || decodedValue > 'z') {
                    decodedValue = messageShiftedBy < 0 ? decodedValue + 26 : decodedValue - 26;
                }
                decoded = Character.toString(decodedValue);

            } else {
                decoded = input.toString();
            }

            decodedMessage.append(decoded);
        }
        return decodedMessage.toString();
    }


}
