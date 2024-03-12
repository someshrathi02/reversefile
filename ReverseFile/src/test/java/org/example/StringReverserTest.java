package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringReverserTest {

    @ParameterizedTest
    @ValueSource(strings = {"ABC", "123", "Hello World","",""})
    public void testReverse(String input) {
        String reversed = StringReverser.reverse(input);
        StringBuilder expected = new StringBuilder(input).reverse();
        assertEquals(expected.toString(), reversed);
    }

    @Test
    public void testReverseNullString() {
        assertEquals(null, StringReverser.reverse(null));
    }
}
