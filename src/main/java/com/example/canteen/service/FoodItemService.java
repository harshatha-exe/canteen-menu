package com.example.canteen.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.canteen.dto.CreateOrUpdateFoodItemDTO;
import com.example.canteen.dto.FoodItemDTO;
import com.example.canteen.entity.FoodItem;
import com.example.canteen.exception.ItemNotFoundException;
import com.example.canteen.repository.FoodItemRepository;
@Service
public class FoodItemService {
    private final FoodItemRepository repository;
    public FoodItemService(FoodItemRepository repository) {
        this.repository = repository;
    }
    public FoodItemDTO createItem(CreateOrUpdateFoodItemDTO dto) {
        FoodItem item = new FoodItem(dto.getName(), dto.getPrice(), dto.getCategory(), dto.getAvailability());
        return toDto(repository.save(item));
    }
    public List<FoodItemDTO> getAllItems() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }
    public FoodItemDTO updateItem(Long id, CreateOrUpdateFoodItemDTO dto) {
        FoodItem item = repository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setCategory(dto.getCategory());
        item.setAvailability(dto.getAvailability());
        return toDto(repository.save(item));
    }
    public void deleteItem(Long id) {
        if (!repository.existsById(id)) throw new ItemNotFoundException(id);
        repository.deleteById(id);
    }
    private FoodItemDTO toDto(FoodItem item) {
        return new FoodItemDTO(item.getId(), item.getName(), item.getPrice(), item.getCategory(), item.getAvailability());
    }
}