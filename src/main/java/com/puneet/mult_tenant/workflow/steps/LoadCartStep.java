package com.puneet.mult_tenant.workflow.steps;

import com.puneet.mult_tenant.config.WorkflowExecutor;
import com.puneet.mult_tenant.config.WorkflowStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("loadCartStep")
public class LoadCartStep {

    @Autowired
    private WorkflowExecutor workflowExecutor;
    @WorkflowStep(name="loadCart")
    public void execute(Map<String, Object> context) {
        List<String> strategies = getStrategies(context);

        Map<String, Object> loadCartContext = new HashMap<>();
        workflowExecutor.execute(strategies, loadCartContext);

        final Map<String, Object> map = new HashMap<>();
        map.put("prop1", loadCartContext.get("loadCartStrategy"));
        map.put("prop2", "value2");
        context.put("loadCart", map);
    }

    private List<String> getStrategies(Map<String, Object> context) {
        final String tenantId = (String) context.get("tenantId");
        switch(tenantId) {
            case "AJIO":
                return List.of("loadCartStrategy1");
            case "RCPL":
                return List.of("loadCartStrategy2");
            default:
                return List.of("loadCartStrategy3");
        }
    }
}