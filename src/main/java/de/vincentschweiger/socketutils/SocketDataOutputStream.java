package de.vincentschweiger.socketutils;

import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class SocketDataOutputStream extends DataOutputStream {
    /**
     * Creates a new data output stream to write data to the specified
     * underlying output stream. The counter {@code written} is
     * set to zero.
     *
     * @param out the underlying output stream, to be saved for later
     *            use.
     * @see FilterOutputStream#out
     */
    public SocketDataOutputStream(OutputStream out) {
        super(out);
    }

    /**
     * First 4 bytes written is the String length
     * Everything after that is the String data
     *
     * @param msg The String to be sent
     * @throws IOException Writing to stream
     */
    public void writeString(final String msg) throws IOException {
        byte[] msgBytes = msg.getBytes(StandardCharsets.UTF_8);
        this.writeInt(msgBytes.length);
        this.write(msgBytes);
    }
}
