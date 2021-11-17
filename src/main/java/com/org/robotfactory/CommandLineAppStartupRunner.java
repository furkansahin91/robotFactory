package com.org.robotfactory;

import com.org.robotfactory.model.*;
import com.org.robotfactory.repository.PartRepository;
import com.org.robotfactory.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private PartRepository partRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Part> partList = new ArrayList<>();
        partList.add(new FacePart("Humanoid Face", new BigDecimal(10.28), 9, "A"));
        partList.add(new FacePart("LCD Face", new BigDecimal( 24.07), 7, "B"));
        partList.add(new FacePart("Steampunk Face", new BigDecimal( 13.30), 0, "C"));
        partList.add(new ArmPart("Arms with Hands", new BigDecimal( 28.94), 1, "D"));
        partList.add(new ArmPart("Arms with Grippers", new BigDecimal( 12.30), 3, "E"));
        partList.add(new MobilityPart("Mobility with Wheels", new BigDecimal( 30.77), 2, "F"));
        partList.add(new MobilityPart("Mobility with Legs", new BigDecimal( 55.13), 15, "G"));
        partList.add(new MobilityPart("Mobility with Tracks", new BigDecimal( 50.00), 7, "H"));
        partList.add(new MaterialPart("Material Bioplastic", new BigDecimal( 90.12), 92, "I"));
        partList.add(new MaterialPart("Material Metallic", new BigDecimal( 82.31), 15, "J"));

        partList.forEach(partRepository::add);
    }
}