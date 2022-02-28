package pl.nullpointerexception.service;

import pl.nullpointerexception.model.*;

import java.math.BigDecimal;
import java.util.List;

import static pl.nullpointerexception.service.PolicyCopyServiceTest.*;

class PolicyCopyServiceTestHelper {

    static PolicyConfiguration createNewBaseConfiguration() {
        PolicyConfiguration policyConfiguration = new PolicyConfiguration();
        policyConfiguration.setId(2L);
        policyConfiguration.setAmountDiscount(new BigDecimal("11.00"));
        policyConfiguration.setPercentDiscount(new BigDecimal("12.00"));
        return policyConfiguration;
    }

    static User createUser(List<Privileges> list) {
        User user = new User();
        user.setId(USER_ID);
        user.setUserName("User");
        user.setPrivileges(list);
        return user;
    }

    static List<Privileges> createPrivileges() {
        Privileges privileges = new Privileges();
        privileges.setName("createPolicy");
        privileges.setActive(true);
        return List.of(privileges);
    }

    static Policy createMostRecentPolicy(long policyId) {
        Policy policy = new Policy();
        policy.setId(policyId);
        return policy;
    }

    static Policy createPolicy(PolicyStatus status, boolean active) {
        Policy policy = new Policy();
        policy.setId(POLICY_ID);
        policy.setStatus(status);
        policy.setCustomer(createCustomer(active));
        policy.setParentId(0L);
        policy.setCreatorId(USER_ID);
        policy.setConfiguration(createConfiguration());
        return policy;
    }

    static CustomerPolicyConfiguration createConfiguration() {
        CustomerPolicyConfiguration customerPolicyConfiguration = new CustomerPolicyConfiguration();
        customerPolicyConfiguration.setId(1L);
        customerPolicyConfiguration.setPercentDiscount(new BigDecimal("15.00"));
        customerPolicyConfiguration.setAmountDiscount(new BigDecimal("10.00"));
        customerPolicyConfiguration.setPolicyConfiguration(createBaseConfiguration());
        return customerPolicyConfiguration;
    }

    static PolicyConfiguration createBaseConfiguration() {
        PolicyConfiguration policyConfiguration = new PolicyConfiguration();
        policyConfiguration.setId(1L);
        policyConfiguration.setPercentDiscount(new BigDecimal("15.00"));
        policyConfiguration.setAmountDiscount(new BigDecimal("10.00"));
        return policyConfiguration;
    }

    static Customer createCustomer(boolean active) {
        Customer customer = new Customer();
        customer.setId(CUSTOMER_ID);
        customer.setName("Customer1");
        customer.setActive(active);
        return customer;
    }
}
