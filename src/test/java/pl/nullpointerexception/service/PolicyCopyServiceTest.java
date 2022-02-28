package pl.nullpointerexception.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.nullpointerexception.model.*;
import pl.nullpointerexception.service.exception.ValidationException;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static pl.nullpointerexception.service.PolicyCopyServiceTestHelper.*;

@ExtendWith(MockitoExtension.class)
class PolicyCopyServiceTest {
    static final long POLICY_ID = 1L;
    static final long USER_ID = 1L;
    static final long CUSTOMER_ID = 1L;
    static final Clock fixed = Clock.fixed(Instant.parse("2020-05-01T12:00:00.000Z"), ZoneId.systemDefault());
    static final LocalDateTime DATE_TIME = LocalDateTime.now(fixed);
    public static final boolean ACTIVE_CUSTOMER = true;
    public static final boolean INACTIVE_CUSTOMER = false;

    @Mock
    private PolicyService policyService;
    @Mock
    private UserService userService;
    @Mock
    private PolicyConfigurationService policyConfigurationService;
    @Mock
    private Clock clock;

    @InjectMocks
    private PolicyCopyService policyCopyService;

    @Test
    void shouldCreatePolicy() {
        // given
        when(clock.instant()).thenReturn(fixed.instant());
        when(clock.getZone()).thenReturn(fixed.getZone());
        when(policyService.getPolicy(POLICY_ID)).thenReturn(createPolicy(PolicyStatus.ACTIVE, ACTIVE_CUSTOMER));
        when(policyService.getMostRecentPolicyForCustomer(CUSTOMER_ID)).thenReturn(createMostRecentPolicy(POLICY_ID));
        when(userService.getUserById(USER_ID)).thenReturn(createUser(createPrivileges()));
        when(policyConfigurationService.getMostRecentConfiguration()).thenReturn(createNewBaseConfiguration());
        when(policyService.addNewPolicy(any())).thenAnswer(invocation -> {
            Policy policy = invocation.getArgument(0, Policy.class);
            policy.setId(2L);
            policy.getConfiguration().setId(2L);
            return policy;
        });
        // when
        Policy policy = policyCopyService.createNewPolicyFromExistingOne(POLICY_ID, USER_ID);
        // then
        assertThat(policy).isNotNull();
        assertThat(policy.getId()).isEqualTo(2L);
        assertThat(policy.getCreatorId()).isEqualTo(USER_ID);
        assertThat(policy.getCreated()).isEqualTo(DATE_TIME);
        assertThat(policy.getConfiguration().getPercentDiscount()).isEqualByComparingTo(new BigDecimal("15.00"));
        assertThat(policy.getConfiguration().getAmountDiscount()).isEqualByComparingTo(new BigDecimal("10.00"));
        PolicyConfiguration base = policy.getConfiguration().getPolicyConfiguration();
        assertThat(base.getPercentDiscount()).isEqualByComparingTo(new BigDecimal("12.00"));
        assertThat(base.getAmountDiscount()).isEqualByComparingTo(new BigDecimal("11.00"));
    }

    @Test
    void shouldThrowExceptionWhenCopyPolicy() {
        // given
        when(policyService.getPolicy(POLICY_ID)).thenReturn(createPolicy(PolicyStatus.ACTIVE, ACTIVE_CUSTOMER));
        when(policyService.getMostRecentPolicyForCustomer(CUSTOMER_ID)).thenReturn(createMostRecentPolicy(0L));
        // when
        assertThatThrownBy(() -> policyCopyService.createNewPolicyFromExistingOne(POLICY_ID, USER_ID))
                .isInstanceOf(ValidationException.class)
                .hasMessage("To nie jest najnowsza polityka dla tego klienta");
    }

    @Test
    void shouldThrowExceptionWhenCopiedPolicyStatusIsNonActive() {
        // given
        when(policyService.getPolicy(POLICY_ID)).thenReturn(createPolicy(PolicyStatus.INACTIVE, ACTIVE_CUSTOMER));
        when(policyService.getMostRecentPolicyForCustomer(CUSTOMER_ID)).thenReturn(createMostRecentPolicy(1L));
        // when
        assertThatThrownBy(() -> policyCopyService.createNewPolicyFromExistingOne(POLICY_ID, USER_ID))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Niepoprawny status polityki");
    }

    @Test
    void shouldThrowExceptionWhenCustomerIsNoneActive() {
        // given
        when(policyService.getPolicy(POLICY_ID)).thenReturn(createPolicy(PolicyStatus.ACTIVE, INACTIVE_CUSTOMER));
        when(policyService.getMostRecentPolicyForCustomer(CUSTOMER_ID)).thenReturn(createMostRecentPolicy(1L));
        // when
        assertThatThrownBy(() -> policyCopyService.createNewPolicyFromExistingOne(POLICY_ID, USER_ID))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Klient id: 1 jest nieaktywny");
    }

    @Test
    void shouldThrowExceptionWhenUserCannotCreatePolicy() {
        // given
        when(policyService.getPolicy(POLICY_ID)).thenReturn(createPolicy(PolicyStatus.ACTIVE, ACTIVE_CUSTOMER));
        when(policyService.getMostRecentPolicyForCustomer(CUSTOMER_ID)).thenReturn(createMostRecentPolicy(1L));
        when(userService.getUserById(USER_ID)).thenReturn(createUser(Collections.emptyList()));
        // when
        assertThatThrownBy(() -> policyCopyService.createNewPolicyFromExistingOne(POLICY_ID, USER_ID))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Użytkownik nie może tworzyć polityk");
    }
}