package dev.hangarmc.hangar.util;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class CryptoUtilsTest {

    @Test
    void bytesToHex_basic() {
        byte[] input = new byte[]{0, 15, (byte) 255, (byte) 165};
        String expected = "000fffa5";
        assertEquals(expected, CryptoUtils.bytesToHex(input));
    }

    @Test
    void bytesToHex_empty() {
        byte[] input = new byte[0];
        assertEquals("", CryptoUtils.bytesToHex(input));
    }

    @Test
    void sha256ToHex_knownVectors() {
        byte[] abc = "abc".getBytes(StandardCharsets.UTF_8);
        String expectedAbc = "ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad";
        assertEquals(expectedAbc, CryptoUtils.sha256ToHex(abc));

        byte[] empty = new byte[0];
        String expectedEmpty = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";
        assertEquals(expectedEmpty, CryptoUtils.sha256ToHex(empty));
    }

}
