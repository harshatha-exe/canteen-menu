package com.example.canteen.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.canteen.entity.FoodItem;
@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
}