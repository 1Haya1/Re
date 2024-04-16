package org.example.schoolrelational.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.schoolrelational.Api.ApiResponse;
import org.example.schoolrelational.DTO.AddressDTO;
import org.example.schoolrelational.Service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {


    private final AddressService addressService ;


    @GetMapping("/get")
    public ResponseEntity getAddress(){
        return ResponseEntity.status(200).body(addressService.getAllAddress());
    }


    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){

        addressService.addAddress(addressDTO);

        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }


    @PutMapping("/update")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO addressDTO){

        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){

        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));

    }





}
