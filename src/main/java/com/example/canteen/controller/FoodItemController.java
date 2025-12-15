package com.example.canteen.controller;
import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.canteen.dto.CreateOrUpdateFoodItemDTO;
import com.example.canteen.dto.FoodItemDTO;
import com.example.canteen.service.FoodItemService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/items")
public class FoodItemController {
    private final FoodItemService service;
    public FoodItemController(FoodItemService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<FoodItemDTO> createItem(@Valid @RequestBody CreateOrUpdateFoodItemDTO dto) {
        FoodItemDTO created = service.createItem(dto);
        return ResponseEntity.created(URI.create("/api/items/" + created.getId())).body(created);
    }
    @GetMapping
    public List<FoodItemDTO> getAllItems() {
        return service.getAllItems();
    }
    @PutMapping("/{id}")
    public FoodItemDTO updateItem(@PathVariable Long id, @Valid @RequestBody CreateOrUpdateFoodItemDTO dto) {
        return service.updateItem(id, dto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}