package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FileHandlerTest {

    @Test
    public void testReadFile() throws IOException {
        String testInput = "ABC";
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        String content = FileHandler.readFile(inputStream);
        assertEquals("ABC", content);
    }

    @Test
    public void testReadFileWithIOException() throws IOException {
        InputStream mockInputStream = Mockito.mock(InputStream.class);
        doThrow(new IOException("Mocked IOException")).when(mockInputStream).read(any());
        assertThrows(IOException.class, () -> FileHandler.readFile(mockInputStream));
    }

    @Test
    public void testWriteFile() throws IOException {
        String testOutput = "CBA";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        FileHandler.writeFile(outputStream, testOutput);
        String content = outputStream.toString();
        assertEquals("CBA", content);
    }

    @Test
    public void testWriteFileWithIOException() throws IOException {
        OutputStream mockOutputStream = Mockito.mock(OutputStream.class);
        doThrow(new IOException("Mocked IOException")).when(mockOutputStream).write(any(byte[].class), anyInt(), anyInt());
        assertThrows(IOException.class, () -> FileHandler.writeFile(mockOutputStream, "CBA"));
    }
}

