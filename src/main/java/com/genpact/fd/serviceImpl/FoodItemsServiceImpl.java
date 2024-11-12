package com.genpact.fd.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.fd.entity.FoodItems;
import com.genpact.fd.repository.FoodItemsRepository;
import com.genpact.fd.service.FoodItemsService;

@Service
public class FoodItemsServiceImpl implements FoodItemsService{
	
	@Autowired
	private FoodItemsRepository foodItemsRepository;
	

	@Override
	public List<FoodItems> getAllFoodItems() {
		// TODO Auto-generated method stub
		return foodItemsRepository.findAll();
	}

	@Override
	public FoodItems saveFoodItem(FoodItems foodItems) {
		// TODO Auto-generated method stub
		return foodItemsRepository.save(foodItems);
	}

	@Override
	public FoodItems getFoodItemById(Long id) {
		// TODO Auto-generated method stub
		return foodItemsRepository.findById(id).get();
	}

	@Override
	public void deleteFoodItemById(Long id) {
		// TODO Auto-generated method stub
		foodItemsRepository.deleteById(id);;
	}

	
}
