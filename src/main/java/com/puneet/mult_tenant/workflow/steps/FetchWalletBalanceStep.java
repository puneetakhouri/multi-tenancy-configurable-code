package com.puneet.mult_tenant.workflow.steps;

import com.puneet.mult_tenant.config.WorkflowStep;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("fetchWalletBalanceStep")
public class FetchWalletBalanceStep {
    
    @WorkflowStep(name="fetchWalletBalance")
    public void fetchWalletBalance(Map<String, Object> context) {
        final Map<String, Object> map = new HashMap<>();
        map.put("fetchWalletBalance1", "value1");
        map.put("fetchWalletBalance2", "value2");
        context.put("fetchWalletBalance", map);
    }
}