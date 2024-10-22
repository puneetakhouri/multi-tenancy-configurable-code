package com.puneet.mult_tenant.workflow.steps;

import com.puneet.mult_tenant.config.WorkflowStep;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("checkWhitelistStep")
public class CheckWhitelistStep {
    
    @WorkflowStep(name="checkWhitelist")
    public void checkWhitelist(Map<String, Object> context) {
        final Map<String, Object> map = new HashMap<>();
        map.put("checkWhitelist1", "value1");
        map.put("checkWhitelist2", "value2");
        context.put("checkWhitelist", map);
    }
}