package com.puneet.mult_tenant.workflow.steps.inner;

import com.puneet.mult_tenant.config.WorkflowStep;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("loadCartStrategy3Step")
public class LoadCartStrategyThree {

    @WorkflowStep(name = "loadCartStrategy3")
    public void loadCartStrategy(Map<String, Object> context) {
        context.put("loadCartStrategy", "loadCartStrategy3");
    }
}
