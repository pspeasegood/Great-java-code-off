package org.decoder;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CaesarCipherTest {

    private static final CaesarCipher caesarCipher = new CaesarCipher();

    @Test
    public void decodePositiveSmallShiftKey() {
        String expected = "hello";
        assertThat(caesarCipher.decodeMessage("khoor", 3), equalTo(expected));
    }

    @Test
    public void encodePositiveSmallShiftKey() {
        String expected = "khoor";
        assertThat(caesarCipher.encodeMessage("hello", 3), equalTo(expected));
    }

    @Test
    public void decodePositiveSmallShiftKeyAndEdgeAlpha() {
        String expected = "vwxyz";
        assertThat(caesarCipher.decodeMessage("abcde", 5), equalTo(expected));
    }

    @Test
    public void encodePositiveSmallShiftKeyAndEdgeAlpha() {
        String expected = "abcde";
        assertThat(caesarCipher.encodeMessage("vwxyz", 5), equalTo(expected));
    }

    @Test
    public void decodePositiveSmallShiftKeyAndPunctuation() {
        String expected = "hello!";
        assertThat(caesarCipher.decodeMessage("khoor!", 3), equalTo(expected));
    }

    @Test
    public void encodePositiveSmallShiftKeyAndPunctuation() {
        String expected = "khoor!";
        assertThat(caesarCipher.encodeMessage("hello!", 3), equalTo(expected));
    }

    @Test
    public void decodePositiveLargeShiftKey() {
        String expected = "hello";
        assertThat(caesarCipher.decodeMessage("dahhk", 100), equalTo(expected));
    }

    @Test
    public void encodePositiveLargeShiftKey() {
        String expected = "dahhk";
        assertThat(caesarCipher.encodeMessage("hello", 100), equalTo(expected));
    }

    @Test
    public void decodeNegativeSmallShiftKey() {
        String expected = "hello";
        assertThat(caesarCipher.decodeMessage("ebiil", -3), equalTo(expected));
    }

    @Test
    public void encodeNegativeSmallShiftKey() {

        String expected = "ebiil";
        assertThat(caesarCipher.encodeMessage("hello", -3), equalTo(expected));
    }

    @Test
    public void decodeNegativeLargeShiftKey() {
        String expected = "hello";
        assertThat(caesarCipher.decodeMessage("lipps", -100), equalTo(expected));
    }

    @Test
    public void encodeNegativeLargeShiftKey() {
        String expected = "lipps";
        assertThat(caesarCipher.encodeMessage("hello", -100), equalTo(expected));
    }

    @Test
    public void decodePositiveSmallShiftKeyForUpperCaseLetters() {
        String expected = "HELLO";
        assertThat(caesarCipher.decodeMessage("KHOOR", 3), equalTo(expected));
    }

    @Test
    public void encodePositiveSmallShiftKeyForUpperCaseLetters() {
        String expected = "KHOOR";
        assertThat(caesarCipher.encodeMessage("HELLO", 3), equalTo(expected));
    }

    @Test
    public void decodeMessageWithCaseSensitiveCharsAndSmallPositiveShiftKey() {
        String expected = "This is a Message";
        assertThat(caesarCipher.decodeMessage("Aopz pz h Tlzzhnl", 7), equalTo(expected));
    }

    @Test
    public void decodeMessageWithCaseSensitiveCharsAndSmallNegativeShiftkey() {
        String expected = "This is a Message for Negative Shift";
        assertThat(caesarCipher.decodeMessage("Ocdn dn v Hznnvbz ajm Izbvodqz Ncdao", -5), equalTo(expected));
    }

    @Test
    public void decodeMessageWithPunctuationAndSmallPositiveShiftKey() {
        String expected = "This is a Message & for Positive Shift!!";
        assertThat(caesarCipher.decodeMessage("Ymnx nx f Rjxxflj & ktw Utxnynaj Xmnky!!", 5), equalTo(expected));
    }

    @Test
    public void decodeMessageThatLooksTheSame() {
        String expected = "Hello";
        assertThat(caesarCipher.decodeMessage("Hello", 26), equalTo(expected));
    }

    @Test
    public void decodeMessageWithIntMax() {
        String expected = "Hello";
        assertThat(caesarCipher.decodeMessage("Ebiil", Integer.MAX_VALUE), equalTo(expected));
    }

    @Test
    public void decodeMessageWithNumbers() {
        String expected = "He110 W0rlD";
        assertThat(caesarCipher.decodeMessage("Kh110 Z0uoG", 3), equalTo(expected));
    }
}