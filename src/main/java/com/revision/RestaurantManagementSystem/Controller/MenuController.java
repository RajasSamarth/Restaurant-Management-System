package com.revision.RestaurantManagementSystem.Controller;


import com.revision.RestaurantManagementSystem.Entity.Menu;
import com.revision.RestaurantManagementSystem.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    //get full menu
    @GetMapping
    public ResponseEntity<List<Menu>> getFullMenu(){

        return ResponseEntity.ok(menuService.getFullMenu());
    }

    //get dish by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Menu>> getDishById(@PathVariable int id){
        Optional<Menu> dish = menuService.getById(id);
        return ResponseEntity.ok(dish);
    }

    //add dish
    @PostMapping("/add-dish")
    public Menu saveDish(@RequestBody Menu dish){

        return menuService.addDish(dish);
    }

    //delete dish
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDishById(@PathVariable int id){
        menuService.deleteDishById(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Menu> updateDishById(@PathVariable int id, @RequestBody Menu menu){

        Menu newDish = menuService.updateDish(id, menu);

        return ResponseEntity.ok(newDish);
    }


    //patchMapping

    @PatchMapping("/update/{id}")
    public ResponseEntity<Menu> partiallyUpdate(@PathVariable Integer id, @RequestBody Menu menu){

        Menu updateDish = menuService.partUpdateDish(id , menu);
        return ResponseEntity.ok(updateDish);

    }

}
