package pl.nullpointerexception.p5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VoidMethodExampleRefactorTest {

    private VoidMethodExampleRefactor voidMethodExampleRefactor = new VoidMethodExampleRefactor();

    @Test
    void shouldDeleteExistingFile(@TempDir Path tempDir) throws IOException {
        // given
        Files.createFile(tempDir.resolve("testFile.txt"));
        // when
        boolean deleted = voidMethodExampleRefactor.delete(tempDir, "testFile.txt");
        // then
        assertThat(deleted).isTrue();
    }

    @Test
    void shouldDeleteNoneExistingFile(@TempDir Path tempDir) throws IOException {
        // when
        boolean deleted = voidMethodExampleRefactor.delete(tempDir, "testFile.txt");
        // then
        assertThat(deleted).isFalse();
    }

    @Test
    void shouldNotDeleteNoneEmptyDir(@TempDir Path tempDir) throws IOException {
        // given
        Files.createFile(tempDir.resolve("testFile.txt"));
        // when
        boolean deleted = voidMethodExampleRefactor.delete(tempDir, "");
        // then
        assertThat(deleted).isFalse();
    }


}