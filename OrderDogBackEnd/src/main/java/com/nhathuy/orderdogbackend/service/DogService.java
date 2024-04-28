package com.nhathuy.orderdogbackend.service;

import com.nhathuy.orderdogbackend.model.Dog;

import java.util.List;
import java.util.Optional;

public interface DogService {
    public List<Dog> getAllDog();
    public Optional<Dog> getDogById(int id);
    public Dog saveDog(Dog dog);
}
