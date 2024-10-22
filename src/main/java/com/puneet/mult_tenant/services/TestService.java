package com.puneet.mult_tenant.services;

import com.puneet.mult_tenant.config.WorkflowExecutor;
import com.puneet.mult_tenant.config.WorkflowStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestService {


    @Autowired
    private WorkflowExecutor workflowExecutor;
    public Map<String, Object> getData(String tenant) {
        // Load tenant-specific workflow configuration
        List<String> workflowSteps = loadWorkflowConfig(tenant);

        // Create context for workflow execution
        Map<String, Object> context = createContext(tenant);

        // Execute workflow
        workflowExecutor.execute(workflowSteps, context);

        // Extract and return the final cart object
        return context;
    }

    private List<String> loadWorkflowConfig(String tenantId) {
        // Load workflow configuration from database or configuration service
        // This is a placeholder - implement actual loading logic
        switch (tenantId){
            case "AJIO":
                return List.of("loadCart", "checkWhitelist", "checkInventory", "fetchWalletBalance", "decorateCart");
            case "RCPL":
                return List.of("loadCart", "checkWhitelist", "fetchWalletBalance", "checkInventory");
            default:
                return List.of("loadCart", "checkWhitelist", "checkInventory", "fetchWalletBalance", "decorateCart");
        }

    }

    private Map<String, Object> createContext(String tenantId) {
        Map<String, Object> context = new LinkedHashMap<>();
        context.put("tenantId", tenantId);
        return context;
    }

    /*@WorkflowStep
    private Map<String, Object> loadCart(Map<String, Object> context) {
        final Map<String, Object> map = new HashMap<>();
        map.put("prop1", "value1");
        map.put("prop2", "value2");
        context.put("loadCart", map);
        return context;
    }

    @WorkflowStep
    private Map<String, Object> checkWhitelist(Map<String, Object> context) {
        final Map<String, Object> map = new HashMap<>();
        map.put("checkWhitelist1", "value1");
        map.put("checkWhitelist2", "value2");
        context.put("checkWhitelist", map);
        return context;
    }

    @WorkflowStep
    private Map<String, Object> checkInventory(Map<String, Object> context) {
        final Map<String, Object> map = new HashMap<>();
        map.put("checkInventory1", "value1");
        map.put("checkInventory", "value2");
        context.put("checkInventory", map);
        return context;
    }

    @WorkflowStep
    private Map<String, Object> fetchWalletBalance(Map<String, Object> context) {
        final Map<String, Object> map = new HashMap<>();
        map.put("fetchWalletBalance1", "value1");
        map.put("fetchWalletBalance2", "value2");
        context.put("fetchWalletBalance", map);
        return context;
    }

    @WorkflowStep
    private Map<String, Object> decorateCart(Map<String, Object> context) {
        final Map<String, Object> map = new HashMap<>();
        map.put("decorateCart1", "value1");
        map.put("decorateCart2", "value2");
        context.put("decorateCart", map);
        return context;
    }*/
}
