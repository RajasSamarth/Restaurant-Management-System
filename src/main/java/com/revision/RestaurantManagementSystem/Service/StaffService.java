package com.revision.RestaurantManagementSystem.Service;


import com.revision.RestaurantManagementSystem.Entity.Staff;
import com.revision.RestaurantManagementSystem.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {


    @Autowired
    private StaffRepository staffRepository;


    public Staff addStaff(Staff staff){

        return staffRepository.save(staff);
    }

    public List<Staff> findAllStaff(){
        List<Staff> staffs = staffRepository.findAll();
        return staffs;
    }

    public Optional<Staff> findStaffById(int id){
        Optional<Staff> staff = staffRepository.findById(id);
        return staff;
    }

    public void deleteStaffById(int id){
        staffRepository.deleteById(id);

    }

    public Staff updateStaff(int id, Staff staff){

        Optional<Staff> dbStaff = staffRepository.findById(id);

        if(dbStaff.isPresent()){

            Staff saveStaff = dbStaff.get();

            if(staff.getAddress()!=null)
                saveStaff.setAddress(staff.getAddress());

            if(staff.getDob()!=null)
                saveStaff.setDob(staff.getDob());

            if(staff.getName()!=null)
                saveStaff.setName(staff.getName());

            if(staff.getRole()!=null)
                saveStaff.setRole(staff.getRole());

            if(staff.getSalary()!=null){
                saveStaff.setSalary(staff.getSalary());

            }

            if(staff.getContactNumber()!=null){
                saveStaff.setContactNumber(staff.getContactNumber());

            }


            return staffRepository.save(saveStaff);
        }

        return null;
    }
}
