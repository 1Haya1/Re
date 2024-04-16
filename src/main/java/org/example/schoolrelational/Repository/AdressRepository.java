package org.example.schoolrelational.Repository;

import org.example.schoolrelational.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Address,Integer> {

    Address findAddressById(Integer id);
}
