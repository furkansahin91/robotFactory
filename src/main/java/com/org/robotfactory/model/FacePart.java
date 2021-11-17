package com.org.robotfactory.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class FacePart extends Part implements Serializable {
    private final PartType partType = PartType.FACE;

    public FacePart(String name, BigDecimal price, int stock, String code) {
        super(name, price, stock, code);
    }
}
