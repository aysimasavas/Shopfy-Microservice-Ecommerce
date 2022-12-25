package com.aysimasavas.inventoryservice.service;


import com.aysimasavas.inventoryservice.repository.InventoryRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        log.info("Checking Inventory");
       return inventoryRepository.findBySkuCode().isPresent();

    }
}
