package com.org.robotfactory.model;

import java.util.List;

public class OrderRequest {
    public List<String> components;

    public List<String> getComponents() {
        return components;
    }

    public void setComponents(List<String> components) {
        this.components = components;
    }
}
