package com.nhathuy.orderdogbackend.service;

import com.nhathuy.orderdogbackend.model.Dog;
import com.nhathuy.orderdogbackend.respository.DogRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    private DogRespository dogRespository;
    @Override
    public List<Dog> getAllDog() {
        return dogRespository.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }
    @Override
    public Optional<Dog> getDogById(int id) {
        return dogRespository.findById(id);
    }

    @Override
    public Dog saveDog(Dog dog) {
        return dogRespository.save(dog);
    }
}
