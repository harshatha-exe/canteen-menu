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
public class FoodItemServiceImpl implements FoodItemService {
private final FoodItemRepository repository;
public FoodItemServiceImpl(FoodItemRepository repository) {
this.repository = repository;
}
@Override
public FoodItemDTO createItem(CreateOrUpdateFoodItemDTO dto) {
FoodItem item = new FoodItem(dto.getName(), dto.getPrice(),
dto.getCategory(), dto.getAvailability());
FoodItem saved = repository.save(item);
return toDto(saved);
}
@Override
public List<FoodItemDTO> getAllItems() {
return
repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
}
@Override
public FoodItemDTO updateItem(Long id, CreateOrUpdateFoodItemDTO dto) {
FoodItem existing = repository.findById(id).orElseThrow(() -> new
ItemNotFoundException(id));
existing.setName(dto.getName());
existing.setPrice(dto.getPrice());
existing.setCategory(dto.getCategory());
existing.setAvailability(dto.getAvailability());
FoodItem updated = repository.save(existing);
return toDto(updated);
}
@Override
public void deleteItem(Long id) {
if (!repository.existsById(id)) throw new ItemNotFoundException(id);
repository.deleteById(id);
}
private FoodItemDTO toDto(FoodItem item) {
return new FoodItemDTO(item.getId(), item.getName(), item.getPrice(),
item.getCategory(), item.getAvailability());
}
}