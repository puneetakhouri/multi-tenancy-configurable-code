package com.puneet.mult_tenant.services;

import com.puneet.mult_tenant.config.WorkflowExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public abstract class BaseService implements WorkflowManager {

    @Autowired
    private WorkflowExecutor workflowExecutor;

    protected List<String> loadWorkflowConfig(String tenantId, String methodName) {
        // Load workflow configuration from database or configuration service
        // This is a placeholder - implement actual loading logic

        switch (tenantId){
            case "AJIO":
                return "getData".equalsIgnoreCase(methodName) ? List.of("loadCart", "checkWhitelist", "checkInventory", "fetchWalletBalance", "decorateCart") : Collections.emptyList();
            case "RCPL":
                return "getData".equalsIgnoreCase(methodName) ? List.of("loadCart", "checkWhitelist", "fetchWalletBalance", "checkInventory") : Collections.emptyList();
            default:
                return List.of("loadCart", "checkWhitelist", "checkInventory", "fetchWalletBalance", "decorateCartWithPriceInCustomJson");
        }
    }

    protected Map<String, Object> createContext(String tenantId) {
        Map<String, Object> context = new LinkedHashMap<>();
        context.put("tenantId", tenantId);
        return context;
    }

    public WorkflowExecutor getWorkflowExecutor() {
        return workflowExecutor;
    }
}
