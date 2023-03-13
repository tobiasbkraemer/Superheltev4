package com.example.superheltev4.repository;

import com.example.superheltev4.DTO.CityDTO;
import com.example.superheltev4.DTO.CountPowerDTO;
import com.example.superheltev4.DTO.HeroPowerDTO;
import com.example.superheltev4.model.Superhero;

import java.util.List;

public interface Repository {

    public List<Superhero> getSuperheroes();

    public HeroPowerDTO heroPower(String name);

    public CityDTO heroCity(String name);

    public CountPowerDTO heroPowerCount(String name);

}
