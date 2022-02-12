package pl.nullpointerexception.p9b;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.nullpointerexception.p9b.model.Statistic;
import pl.nullpointerexception.p9b.model.User;
import pl.nullpointerexception.p9b.service.MessageService;
import pl.nullpointerexception.p9b.service.UserService;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SendMessagesExtendedTest {

    @Mock
    private UserService userService;

    @Mock
    private MessageService messageService;

    @InjectMocks
    private SendMessagesExtended sendMessagesExtended;

    Map<String, String> toSend = new HashMap<>();

    @BeforeEach
    void setUp() {
        toSend.put("jkowalski", "Hello jkowalski");
        toSend.put("anowak", "Hello anowak");
        toSend.put("Majlo", "Hello Majlo");
    }

    @Test
    void shouldSendMessagesToAllUsers() {
        // given
        when(userService.existsByUserName(anyString())).thenReturn(true);
        when(userService.getUserByName("jkowalski"))
                .thenReturn(new User("jkowalski", "jkowalski@test.pl"));
        when(userService.getUserByName("anowak"))
                .thenReturn(new User("anowak", "anowak@test.pl"));
        when(userService.getUserByName("Majlo"))
                .thenReturn(new User("Majlo", "Majlo@test.pl"));

        when(messageService.sendMessage(anyString(), anyString())).thenReturn(true);
        // when
        Statistic statistic = sendMessagesExtended.send(toSend);
        // then
        assertThat(statistic.getSuccess()).isEqualTo(3);
        assertThat(statistic.getFailure()).isEqualTo(0);
    }

    @Test
    void shouldNotSendMessagesToAnyUser() {
        // given
        when(userService.existsByUserName(anyString())).thenReturn(false);
        // when
        Statistic statistic = sendMessagesExtended.send(toSend);
        // then
        assertThat(statistic.getSuccess()).isEqualTo(0);
        assertThat(statistic.getFailure()).isEqualTo(3);
    }

    @Test
    void shouldNotSendMessagesToAnyUserWhenMessageServiceFailure() {
        // given
        when(userService.existsByUserName(anyString())).thenReturn(true);
        when(userService.getUserByName("jkowalski"))
                .thenReturn(new User("jkowalski", "jkowalski@test.pl"));
        when(userService.getUserByName("anowak"))
                .thenReturn(new User("anowak", "anowak@test.pl"));
        when(userService.getUserByName("Majlo"))
                .thenReturn(new User("Majlo", "Majlo@test.pl"));
        when(messageService.sendMessage(anyString(), anyString())).thenReturn(false);
        // when
        Statistic statistic = sendMessagesExtended.send(toSend);
        // then
        assertThat(statistic.getSuccess()).isEqualTo(0);
        assertThat(statistic.getFailure()).isEqualTo(3);
    }

}