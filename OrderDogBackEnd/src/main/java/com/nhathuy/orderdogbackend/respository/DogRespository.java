package com.nhathuy.orderdogbackend.respository;

import com.nhathuy.orderdogbackend.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRespository extends JpaRepository<Dog,Integer> {

}
