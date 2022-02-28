package miniTesty.p5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VoidMethodExampleRefactorTest {

    VoidMethodExampleRefactor voidMethodExampleRefactor = new VoidMethodExampleRefactor();

    @Test
    void shouldDeleteExistingFile(@TempDir Path tempDir) throws IOException {
        // given
        Files.createFile(tempDir.resolve("test.txt"));
        // when
        boolean isDeleted = voidMethodExampleRefactor.delete(tempDir, "test.txt");
        // then
        assertThat(isDeleted).isTrue();
    }

    @Test
    void shouldNotDeleteExistingFile(@TempDir Path tempDir) {
        // when
        boolean isDeleted = voidMethodExampleRefactor.delete(tempDir, "test.txt");
        // then
        assertThat(isDeleted).isFalse();
    }

    @Test
    void shouldNotDeleteNoneEmptyDir(@TempDir Path tempDir) throws IOException {
        // given
        Files.createFile(tempDir.resolve("test.txt"));
        // when
        voidMethodExampleRefactor.delete(tempDir, "");
        // then
    }
}