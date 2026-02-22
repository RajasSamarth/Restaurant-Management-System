package com.revision.RestaurantManagementSystem.Service;


import com.revision.RestaurantManagementSystem.Entity.Menu;
import com.revision.RestaurantManagementSystem.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {


    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getFullMenu(){
        List<Menu> menuList = menuRepository.findAll();

        return menuList;
    }


    //save dish

//    public Menu addDish(Menu dish){
//        return menuRepository.save(dish);
//
//    }
    public Menu addDish(Menu dish) {
        return menuRepository.save(dish);
    }

    public Optional<Menu> getById(int id){
        Optional<Menu> optionalMenu=  menuRepository.findById(id);
        return optionalMenu;
    }

    public void deleteDishById(int id){
         menuRepository.deleteById(id);
    }

    public Menu updateDish(int id, Menu menu){

        Optional<Menu> dish = menuRepository.findById(id);
        Menu saveDish = null;
        if(dish.isPresent()){

            Menu DBDish = dish.get();
            DBDish.setDish(menu.getDish());
            DBDish.setPrice(menu.getPrice());
            saveDish = menuRepository.save(DBDish);
        }

        return saveDish;
    }




    public Menu partUpdateDish(Integer id, Menu menu){
        Optional<Menu> updateDish = menuRepository.findById(id);
        if(updateDish.isPresent()){
            Menu DBDish = updateDish.get();

            if(menu.getDish()!=null){
                DBDish.setDish(menu.getDish());
            }

            if(menu.getPrice()!= null){
                DBDish.setPrice(menu.getPrice());
            }

            return menuRepository.save(DBDish);
        }

        return null;
    }


}
