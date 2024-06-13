package org.decoder;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CaesarCipherTest {

    private static final CaesarCipher caesarCipher = new CaesarCipher();

    @Test
    public void positiveSmallShiftKey() {
        String expected = "hello";
        assertThat(caesarCipher.decodeMessage("khoor", 3), equalTo(expected));
    }

    @Test
    public void encodeSmallShiftKey() {
        String expected = "khoor";
        assertThat(caesarCipher.encodeMessage("hello", 3), equalTo(expected));
    }

    @Test
    public void positiveSmallShiftKeyAndEdgeAlpha() {
        String expected = "vwxyz";
        assertThat(caesarCipher.decodeMessage("abcde", 5), equalTo(expected));
    }

    @Test
    public void encodeSmallShiftKeyAndEdgeAlpha() {
        String expected = "abcde";
        assertThat(caesarCipher.encodeMessage("vwxyz", 5), equalTo(expected));
    }

    @Test
    public void positiveSmallShiftKeyAndPunctuation() {
        String expected = "hello!";
        assertThat(caesarCipher.decodeMessage("khoor!", 3), equalTo(expected));
    }

    @Test
    public void positiveLargeShiftKey() {
        String expected = "hello";
        assertThat(caesarCipher.decodeMessage("dahhk", 100), equalTo(expected));
    }

    @Test
    public void encodePositiveLargeShiftKey() {
        String expected = "dahhk";
        assertThat(caesarCipher.encodeMessage("hello", 100), equalTo(expected));
    }

    @Test
    public void negativeSmallShiftKey() {
        String expected = "hello";
        assertThat(caesarCipher.decodeMessage("ebiil", -3), equalTo(expected));
    }

    @Test
    public void negativeLargeShiftKey() {
        String expected = "hello";
        assertThat(caesarCipher.decodeMessage("lipps", -100), equalTo(expected));
    }

    @Test
    public void positiveSmallShiftKeyForUpperCaseLetters() {
        String expected = "HELLO";
        assertThat(caesarCipher.decodeMessage("KHOOR", 3), equalTo(expected));
    }

    @Test
    public void caseSensitiveAndSmallPositiveShiftKey() {
        String expected = "This is a Message";
        assertThat(caesarCipher.decodeMessage("Aopz pz h Tlzzhnl", 7), equalTo(expected));
    }

    @Test
    public void decodeMessageWithCaseSensitiveCharsAndSmallNegativeShiftkey() {
        String expected = "This is a Message for Negative Shift";
        assertThat(caesarCipher.decodeMessage("Ocdn dn v Hznnvbz ajm Izbvodqz Ncdao", -5), equalTo(expected));
    }

    @Test
    public void punctuationAndSmallPositiveShiftKey() {
        String expected = "This is a Message & for Positive Shift!!";
        assertThat(caesarCipher.decodeMessage("Ymnx nx f Rjxxflj & ktw Utxnynaj Xmnky!!", 5), equalTo(expected));
    }
}