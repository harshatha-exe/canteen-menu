package com.example.canteen.exception;
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long id) {
        super("Item with id " + id + " not found");
    }
}