package pl.nullpointerexception.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.nullpointerexception.model.PolicyConfiguration;
import pl.nullpointerexception.repository.PolicyConfigurationRepository;


@Service
@AllArgsConstructor
public class PolicyConfigurationService {

    private final PolicyConfigurationRepository policyConfigurationRepository;

    public PolicyConfiguration getMostRecentConfiguration() {
        return policyConfigurationRepository.findFirstByOrderByIdDesc()
                .orElseThrow(() -> new IllegalArgumentException("Konfiguracja nie istnieje"));
    }
}
