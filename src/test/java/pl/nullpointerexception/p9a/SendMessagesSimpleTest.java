package pl.nullpointerexception.p9a;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SendMessagesSimpleTest {

    private SendMessagesSimple sendMessagesSimple = new SendMessagesSimple();

    @Test
    void shouldSendMessageToUser() {
        // given
        sendMessagesSimple.addMessage("jkowalski", "Hello jkowalski");
        sendMessagesSimple.addMessage("anowak", "Hello anowak");
        sendMessagesSimple.addMessage("mdabrowski", "Hello mdabrowski");
        // when
        Statistic statistic = sendMessagesSimple.send();
        // then
        assertThat(statistic.getSuccess()).isEqualTo(3);
        assertThat(statistic.getFailure()).isEqualTo(0);
    }

    @Test
    void shouldSendMessageToNoneExistingUser() {
        // given
        sendMessagesSimple.addMessage("jdoe", "Hello jdoe");
        sendMessagesSimple.addMessage("xyz", "Hello xyz");
        // when
        Statistic statistic = sendMessagesSimple.send();
        // then
        assertThat(statistic.getSuccess()).isEqualTo(0);
        assertThat(statistic.getFailure()).isEqualTo(2);
    }

    @Test
    void shouldSendMessageToAnyUser() {
        // given
        // when
        Statistic statistic = sendMessagesSimple.send();
        // then
        assertThat(statistic.getFailure()).isEqualTo(0);
        assertThat(statistic.getSuccess()).isEqualTo(0);
    }


}