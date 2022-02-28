package miniTesty.p9b;

import miniTesty.p9b.model.Statistic;
import miniTesty.p9b.model.User;
import miniTesty.p9b.service.MessageService;
import miniTesty.p9b.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.*;

import java.util.Hashtable;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SendMessagesExtendedTest {

    @Mock
    private MessageService messageService;
    @Mock
    private UserService userService;

    @InjectMocks
    private SendMessagesExtended sendMessagesExtended;

    private Map<String, String> toSend = new Hashtable<>();


    @Test
    void shouldSendAllMessagesToAllUser() {
        // given
        toSend.put("jkowalski", "Hello jkowalski");
        toSend.put("jhon", "Hello john");
        toSend.put("vayne", "Hello vayne");
        when(userService.existsByUserName(anyString())).thenReturn(true);

        when(userService.getUserByName("jkowalski"))
                .thenReturn(new User("jkowalski", "jkowalski@gmail.com"));
        when(userService.getUserByName("jhon"))
                .thenReturn(new User("jhon", "jhon@gmail.com"));
        when(userService.getUserByName("vayne"))
                .thenReturn(new User("vayne", "vayne@gmail.com"));

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
        toSend.put("jkowalski", "Hello jkowalski");
        toSend.put("jhon", "Hello john");
        toSend.put("vayne", "Hello vayne");
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
        toSend.put("jkowalski", "Hello jkowalski");
        toSend.put("jhon", "Hello john");
        toSend.put("vayne", "Hello vayne");
        when(userService.existsByUserName(anyString())).thenReturn(true);
        when(userService.getUserByName("jkowalski"))
                .thenReturn(new User("jkowalski", "jkowalski@gmail.com"));
        when(userService.getUserByName("jhon"))
                .thenReturn(new User("jhon", "jhon@gmail.com"));
        when(userService.getUserByName("vayne"))
                .thenReturn(new User("vayne", "vayne@gmail.com"));

        when(messageService.sendMessage(anyString(), anyString())).thenReturn(false);
        // when
        Statistic statistic = sendMessagesExtended.send(toSend);
        // then
        assertThat(statistic.getSuccess()).isEqualTo(0);
        assertThat(statistic.getFailure()).isEqualTo(3);
    }
}