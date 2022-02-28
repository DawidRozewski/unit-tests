package miniTesty.p5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


import static org.assertj.core.api.Assertions.assertThat;


class VoidMethodExampleTest {

    private VoidMethodExample voidMethodExample = new VoidMethodExample();

    @Test
    void shouldDeleteFile(@TempDir Path tempDir) throws IOException {
        // given
        Files.createFile(tempDir.resolve("testFile.txt"));
        // when
        voidMethodExample.delete(tempDir, "testFile.txt");
        // then
        assertThat(Files.exists(tempDir.resolve("testFile.txt"))).isFalse();
    }

}