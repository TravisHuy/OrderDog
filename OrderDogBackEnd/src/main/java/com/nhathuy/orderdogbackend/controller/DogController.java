package com.nhathuy.orderdogbackend.controller;

import com.nhathuy.orderdogbackend.model.Dog;
import com.nhathuy.orderdogbackend.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("dog")
@CrossOrigin("*")
public class DogController {
    @Autowired
    private DogService dogService;

    @PostMapping
    public Dog saveDog(@RequestBody Dog dog){
        return dogService.saveDog(dog);
    }
    @GetMapping
    public List<Dog> getAllDogs(){
        return dogService.getAllDog();
    }
    @GetMapping("/{id}")
    public Optional<Dog> getDogById(@PathVariable int id){
        return dogService.getDogById(id);
    }
}
