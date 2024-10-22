package com.puneet.mult_tenant.workflow.steps.inner;

import com.puneet.mult_tenant.config.WorkflowStep;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("loadCartStrategy1Step")
public class LoadCartStrategyOne {

    @WorkflowStep(name = "loadCartStrategy1")
    public void loadCartStrategy(Map<String, Object> context) {
        context.put("loadCartStrategy", "loadCartStrategy1");
    }
}
