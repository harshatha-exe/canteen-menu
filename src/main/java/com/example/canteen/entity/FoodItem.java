package com.example.canteen.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "food_items")
public class FoodItem {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false)
private String name;
@Column(nullable = false)
private Double price;
private String category;
@Column(nullable = false)
private Boolean availability;
public FoodItem() {}
public FoodItem(String name, Double price, String category, Boolean
availability) {
this.name = name;
this.price = price;
this.category = category;
this.availability = availability;
}
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getName() { return name; }
public void setName(String name) { this.name = name; }
public Double getPrice() { return price; }
public void setPrice(Double price) { this.price = price; }
public String getCategory() { return category; }
public void setCategory(String category) { this.category = category; }
public Boolean getAvailability() { return availability; }
public void setAvailability(Boolean availability) { this.availability =
availability; }
}