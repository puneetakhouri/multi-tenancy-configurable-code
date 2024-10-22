package com.puneet.mult_tenant.config;

import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Component
public class WorkflowExecutor {

    @Autowired
    private ApplicationContext applicationContext;

    public void execute(List<String> workflowSteps, Map<String, Object> context) {
        for (String stepName : workflowSteps) {
            Object stepBean = applicationContext.getBean(stepName + "Step");
            Method stepMethod = findWorkflowStepMethod(stepBean.getClass(), stepName);
            if (stepMethod != null) {
                try {
                    stepMethod.invoke(stepBean, context);
                } catch (Exception e) {
                    // Handle exceptions
                    e.printStackTrace();
                }
            } else {
                System.out.println("WorkflowStep method not found for: " + stepName);
            }
        }
    }

    private Method findWorkflowStepMethod(Class<?> clazz, String stepName) {
        for (Method method : clazz.getMethods()) {
            WorkflowStep annotation = method.getAnnotation(WorkflowStep.class);
            if (annotation != null && annotation.name().equals(stepName)) {
                return method;
            }
        }
        return null;
    }
}