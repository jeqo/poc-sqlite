package sqlite.wal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class WalReader {
    public static void main(String[] args) throws IOException {
        var buffer = ByteBuffer.wrap(Files.readAllBytes(Path.of("test.db-wal")));
        var index = buffer.slice();
        index.limit(4);
        buffer.position(buffer.position() + 4);
//        var iVersion = index.slice();
//        iVersion.limit(3);
        var output = index.getInt();
        System.out.println(output);
    }

    public static int readVarint(ByteBuffer buffer) {
        int value = readUnsignedVarint(buffer);
        return (value >>> 1) ^ -(value & 1);
    }

    public static int readUnsignedVarint(ByteBuffer buffer) {
        int value = 0;
        int i = 0;
        int b;
        while (((b = buffer.get()) & 0x80) != 0) {
            value |= (b & 0x7f) << i;
            i += 7;
            if (i > 28)
                throw new IllegalArgumentException();
        }
        value |= b << i;
        return value;
    }
}
