package com.revision.RestaurantManagementSystem.Controller;


import com.revision.RestaurantManagementSystem.Entity.Staff;
import com.revision.RestaurantManagementSystem.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService service;


    @PostMapping("/add-staff")
    public ResponseEntity<Staff> addStaff(@RequestBody Staff staff){

        Staff newStaff = service.addStaff(staff);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStaff);
    }

    @GetMapping
    public ResponseEntity<List<Staff>> getAllStaff(){

        return ResponseEntity.ok(service.findAllStaff());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Staff>> findStaffById(@PathVariable int id){
        Optional<Staff> staff = service.findStaffById(id);
        return ResponseEntity.ok(staff);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable int id){
        service.deleteStaffById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/update/{id}")
    public Staff updateStaff(@PathVariable int id, @RequestBody Staff staff)
    {
        Staff staff1 =  service.updateStaff(id, staff);
        return staff1;

    }


}
