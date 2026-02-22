package com.revision.RestaurantManagementSystem.Repository;

import com.revision.RestaurantManagementSystem.Entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {


}
