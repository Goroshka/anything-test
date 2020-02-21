package com.koldakov.springbasic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BasicBean {

    private int existingProperty;
    private int notExistingProperty;

    @Value("${existing.property:4}")
    public void setExistingProperty(int existingProperty) {
        this.existingProperty = existingProperty;
    }

    @Value("${not.existing.property:77}")
    public void setNotExistingProperty(int notExistingProperty) {
        this.notExistingProperty = notExistingProperty;
    }

    public int getExistingProperty() {
        return existingProperty;
    }

    public int getNotExistingProperty() {
        return notExistingProperty;
    }
}
