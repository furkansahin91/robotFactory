package com.org.robotfactory.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class MaterialPart extends Part implements Serializable {
    private final PartType partType = PartType.MATERIAL;

    public MaterialPart(String name, BigDecimal price, int stock, String code) {
        super(name, price, stock, code);
    }
}
