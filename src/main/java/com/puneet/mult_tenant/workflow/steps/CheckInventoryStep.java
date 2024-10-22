package com.puneet.mult_tenant.workflow.steps;

import com.puneet.mult_tenant.config.WorkflowStep;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("checkInventoryStep")
public class CheckInventoryStep {
    
    @WorkflowStep(name="checkInventory")
    public void checkInventory(Map<String, Object> context) {
        final Map<String, Object> map = new HashMap<>();
        map.put("checkInventory1", "value1");
        map.put("checkInventory", "value2");
        context.put("checkInventory", map);
    }
}