package org.example.schoolrelational.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolrelational.Api.ApiException;
import org.example.schoolrelational.DTO.AddressDTO;

import org.example.schoolrelational.Model.Address;
import org.example.schoolrelational.Model.Teacher;
import org.example.schoolrelational.Repository.AdressRepository;
import org.example.schoolrelational.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AdressRepository adressRepository;
    private final TeacherRepository teacherRepository;



    public List<Address> getAllAddress(){
        return adressRepository.findAll();
    }


    public void addAddress(AddressDTO addressDTO) {
        Teacher t = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (t == null) {
            throw new ApiException("not found");
        }
        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), t);// null لانه مخفي
        adressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO){// ماحطيت ايدي لان فيه ايدي في dto

        Address address=adressRepository.findAddressById(addressDTO.getTeacher_id());
        if(address==null){
            throw new ApiException("not found");
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());

        adressRepository.save(address);
    }

    public void deleteAddress(Integer id){
        Address c=adressRepository.findAddressById(id);
        if (c==null){
            throw new ApiException("not found");
        }
        adressRepository.delete(c);
    }



}
