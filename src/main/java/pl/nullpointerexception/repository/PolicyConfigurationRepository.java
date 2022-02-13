package pl.nullpointerexception.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.nullpointerexception.model.PolicyConfiguration;

import java.util.Optional;

@Repository
public interface PolicyConfigurationRepository extends JpaRepository<PolicyConfiguration, Long> {
    Optional<PolicyConfiguration> findFirstByOrderByIdDesc();
}
