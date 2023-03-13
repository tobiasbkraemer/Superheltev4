package com.example.superheltev4.service;
import com.example.superheltev4.DTO.CityDTO;
import com.example.superheltev4.DTO.CountPowerDTO;
import com.example.superheltev4.DTO.HeroPowerDTO;
import com.example.superheltev4.model.Superhero;
import com.example.superheltev4.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    MyRepository myRepository;

    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public List<Superhero> getSuperheroes() {
        return myRepository.getSuperheroes();
    }

    public HeroPowerDTO heroPowerDTO (String name) {
        return myRepository.heroPower(name);
    }

    public CityDTO cityDTO(String name) {
        return myRepository.heroCity(name);
    }

    public CountPowerDTO countPowerDTO(String name) {
        return myRepository.heroPowerCount(name);
    }
}