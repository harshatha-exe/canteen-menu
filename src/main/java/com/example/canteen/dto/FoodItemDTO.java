package com.example.canteen.dto;
public class FoodItemDTO {
    private Long id;
    private String name;
    private Double price;
    private String category;
    private Boolean availability;
    public FoodItemDTO(Long id, String name, Double price, String category, Boolean availability) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.availability = availability;
    }
    public Long getId() { return id; }
    public String getName() { return name; }
    public Double getPrice() { return price; }
    public String getCategory() { return category; }
    public Boolean getAvailability() { return availability; }
}