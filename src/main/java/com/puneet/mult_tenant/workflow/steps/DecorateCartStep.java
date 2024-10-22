package com.puneet.mult_tenant.workflow.steps;

import com.puneet.mult_tenant.config.WorkflowStep;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("decorateCartStep")
public class DecorateCartStep {
    
    @WorkflowStep(name="decorateCart")
    public void decorateCart(Map<String, Object> context) {
        final Map<String, Object> map = new HashMap<>();
        map.put("decorateCart1", "value1");
        map.put("decorateCart2", "value2");
        context.put("decorateCart", map);
    }
}