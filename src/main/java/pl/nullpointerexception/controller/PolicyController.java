package pl.nullpointerexception.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.nullpointerexception.model.Policy;
import pl.nullpointerexception.service.PolicyCopyService;

@RestController
@AllArgsConstructor
public class PolicyController {

    private final PolicyCopyService policyCopyService;

    @GetMapping("/polices/copy")
    public Policy copyPolicy(@RequestParam Long policyId, @RequestParam Long userId) {
        return policyCopyService.createNewPolicyFromExistingOne(policyId, userId);
    }
}
