package com.aysimasavas.inventoryservice;

import com.aysimasavas.inventoryservice.model.Inventory;
import com.aysimasavas.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);


	}
    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("xiaomi_note_10");
            inventory.setQuantity(50);

            Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("xiaomi_redmi_9");
            inventory1.setQuantity(0);

            Inventory inventory2 = new Inventory();
            inventory1.setSkuCode("iphone_8");
            inventory1.setQuantity(10);

            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory1);
            inventoryRepository.save(inventory2);
        };
    }


}
