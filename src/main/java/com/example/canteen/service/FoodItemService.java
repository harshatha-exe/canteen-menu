package com.example.canteen.service;
import java.util.List;
import com.example.canteen.dto.CreateOrUpdateFoodItemDTO;
import com.example.canteen.dto.FoodItemDTO;
public interface FoodItemService {
FoodItemDTO createItem(CreateOrUpdateFoodItemDTO dto);
List<FoodItemDTO> getAllItems();
FoodItemDTO updateItem(Long id, CreateOrUpdateFoodItemDTO dto);
void deleteItem(Long id);
}