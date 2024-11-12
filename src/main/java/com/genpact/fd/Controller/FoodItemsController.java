package com.genpact.fd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.genpact.fd.entity.FoodItems;
import com.genpact.fd.service.FoodItemsService;

@Controller
public class FoodItemsController {
	
	@Autowired
	private FoodItemsService foodItemsService;

	public FoodItemsController(FoodItemsService foodItemsService) {
		super();
		this.foodItemsService = foodItemsService;
	}

	@GetMapping("/FoodItems")
	public String listFoodItems(Model model) {
		model.addAttribute("foodItems",foodItemsService.getAllFoodItems() );
		return "FoodItems";
	}
	
	@GetMapping("/FoodItems/new")
	public String createFoodItemForm(Model model) {
//		create student object to hold student form data
		FoodItems foodItems=new FoodItems(); 
		model.addAttribute("foodItems",foodItems);
		return "addnewitem";
		
	}
	
	@PostMapping("/FoodItems")
	public String saveFoodItem(@ModelAttribute("foodItems") FoodItems foodItems) {
		foodItemsService.saveFoodItem(foodItems);
		return "redirect:/FoodItems";
	}

	@GetMapping("/FoodItems/edit/{id}")
	public String editFoodItemForm(@PathVariable Long id,Model model) {
		model.addAttribute("foodItem", foodItemsService.getFoodItemById(id));
		return "editfooditem";
		
	}
	@PostMapping("/FoodItems/{id}")
	public String updateSFoodItem(@PathVariable Long id,@ModelAttribute("foodItems") FoodItems foodItems,Model model) {
		FoodItems existingfoodItems=foodItemsService.getFoodItemById(id);
		existingfoodItems.setId(id);
		existingfoodItems.setName(foodItems.getName());
		existingfoodItems.setType(foodItems.getType());
		existingfoodItems.setPrice(foodItems.getPrice());
		
		foodItemsService.saveFoodItem(foodItems);
		return "redirect:/FoodItems";
	}
	
	@GetMapping("/FoodItems/{id}")
	public String deleteFoodItem(@PathVariable Long id) {
		foodItemsService.deleteFoodItemById(id);
		return "redirect:/FoodItems";
	}
}
