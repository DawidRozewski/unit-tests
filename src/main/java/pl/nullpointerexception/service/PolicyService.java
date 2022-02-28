package pl.nullpointerexception.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.nullpointerexception.model.Policy;
import pl.nullpointerexception.repository.PolicyRepository;

@Service
@AllArgsConstructor
public class PolicyService {

    private final PolicyRepository policyRepository;

    public Policy getPolicy(Long policyId) {
        return policyRepository.findById(policyId)
                .orElseThrow(() -> new IllegalArgumentException("Polityka nie istnieje"));
    }

    public Policy addNewPolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public Policy getMostRecentPolicyForCustomer(Long customerId) {
        return policyRepository.findFirstByCustomerIdOrderByIdDesc(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Polityka nie istnieje"));
    }

}
