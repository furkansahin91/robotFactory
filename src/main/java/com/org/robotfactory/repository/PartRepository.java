package com.org.robotfactory.repository;

import com.org.robotfactory.exception.StockNotAvailableException;
import com.org.robotfactory.model.Part;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class PartRepository {
    private static ConcurrentHashMap<String, Part> partStorage = new ConcurrentHashMap<>();

    public Part add(Part part) {
        partStorage.put(part.getCode(), part);

        return part;
    }

    public Part delete(String code) {
        Part p = partStorage.get(code);
        partStorage.remove(code);

        return p;
    }

    public Part findByCode(String code) {
        return partStorage.get(code);
    }

    public List<Part> findByCodeList(List<String> code) {
        return partStorage.values().parallelStream().
                filter(i -> code.stream().anyMatch(c -> i.getCode().equalsIgnoreCase(c)))
                .collect(Collectors.toList());
    }

    public List<Part> findAll() {
        return partStorage
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    public void reduceStockByOne(String code) {
        Part p = partStorage.get(code);
        if (p.getStock() >= 1) {
            p.setStock(p.getStock() - 1);
        }
    }

    public void checkStockByCode(String code) {
        Part p = partStorage.get(code);
        if (p.getStock() < 1) {
            throw new StockNotAvailableException("stock not available for ", code, " part code");
        }
    }
}
