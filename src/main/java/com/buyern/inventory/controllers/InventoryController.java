package com.buyern.inventory.controllers;

import com.buyern.inventory.dtos.InventoryDto;
import com.buyern.inventory.models.Inventory;
import com.buyern.inventory.models.InventoryVariation;
import com.buyern.inventory.services.InventoryService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {
    final InventoryService inventoryService;

    @GetMapping("")
    public ResponseEntity<Optional<Inventory>> getInventory(@RequestParam Long inventoryId) {
        return ResponseEntity.ok(inventoryService.getInventory(inventoryId));
    }

    @GetMapping("all")
    public ResponseEntity<List<Inventory>> getInventoriesByEntityId(String entityId, int page, int pageSize) {
        return ResponseEntity.ok(inventoryService.getEntityInventories(entityId, page, pageSize));
    }
    @GetMapping("allByIds")
    public ResponseEntity<List<Inventory>> getInventoriesById(@RequestBody List<Long> inventoryIds) {
        return ResponseEntity.ok(inventoryService.getInventoriesById(inventoryIds));
    }

    @GetMapping("allByEntityId")
    public ResponseEntity<List<Inventory>> getInventoriesByEntityId(String entityId) {
        return ResponseEntity.ok(inventoryService.getInventoriesByEntityId(entityId));
    }

    @PostMapping("")
    public ResponseEntity<Inventory> createInventory(@RequestBody InventoryDto inventory) {
        return ResponseEntity.of(inventoryService.createInventory(inventory));
    }

    @DeleteMapping("")
    public ResponseEntity<Inventory> deleteInventory(Long id) {
        return null;
    }

    /**
     * <h2><b>VARIATIONS</b></h2>
     */
    @GetMapping("/variations")
    public ResponseEntity<List<InventoryVariation>> getInventoryVariations(@RequestParam Long inventoryId) {
        return ResponseEntity.ok(inventoryService.getInventoryVariations(inventoryId));
    }
}
