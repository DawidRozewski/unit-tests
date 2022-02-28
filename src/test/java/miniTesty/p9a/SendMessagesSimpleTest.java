package miniTesty.p9a;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SendMessagesSimpleTest {

    private SendMessagesSimple messagesSimple = new SendMessagesSimple();

    @Test
    void shouldSendMessageToUser() {
        // given
        messagesSimple.addMessage("jkowalski", "Hello jkowalski");
        // when
        Statistic statistic = messagesSimple.send();
        // then
        assertThat(statistic.getSuccess()).isEqualTo(1);
    }

    @Test
    void shouldNotSendMessageToNonExistingUser() {
        // given
        messagesSimple.addMessage("sadgdasd", "agdsas");
        // when
        Statistic statistic = messagesSimple.send();
        // then
        assertThat(statistic.getFailure()).isEqualTo(1);
    }

    @Test
    void shouldNotSendMessageToAnyUser() {
        // given
        // when
        Statistic statistic = messagesSimple.send();
        // then
        assertThat(statistic.getFailure()).isEqualTo(0);
        assertThat(statistic.getSuccess()).isEqualTo(0);
    }
}