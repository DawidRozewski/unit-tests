package pl.nullpointerexception.p5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VoidMethodExample {

    public void delete(Path path, String fileName) throws IOException {
        Files.delete(path.resolve(fileName));
    }
}
