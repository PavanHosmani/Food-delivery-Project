package com.genpact.fd.service;

import java.util.List;

import com.genpact.fd.entity.FoodItems;

public interface FoodItemsService {

	List<FoodItems> getAllFoodItems();

	FoodItems saveFoodItem(FoodItems foodItems);

	FoodItems getFoodItemById(Long id);

	void deleteFoodItemById(Long id);
}
