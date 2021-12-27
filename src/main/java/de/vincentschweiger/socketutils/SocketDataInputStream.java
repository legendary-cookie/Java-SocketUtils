package de.vincentschweiger.socketutils;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SocketDataInputStream extends DataInputStream {
    /**
     * Creates a DataInputStream that uses the specified
     * underlying InputStream.
     *
     * @param in the specified input stream
     */
    public SocketDataInputStream(InputStream in) {
        super(in);
    }

    /**
     * Read a String from stream,
     * first 4 bytes are the length (int),
     * after that n bytes are is the String sent (n=length)
     *
     * @return Read stream into string
     * @throws IOException Reading from stream
     */
    public String readString() throws IOException {
        int length = this.readInt();
        byte[] buffer = new byte[length];
        this.readFully(buffer);
        return new String(buffer);
    }
}
