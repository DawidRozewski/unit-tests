package pl.nullpointerexception.p8;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.*;
import org.awaitility.Awaitility.*;
class JavaAsyncTaskTest {

    private JavaAsyncTask asyncTask = new JavaAsyncTask();

    @Test
    void shouldRunAsyncTask() {
        // given
        // when
        asyncTask.runTask();
        // then
        await().until(() -> asyncTask.getResult());
    }

}