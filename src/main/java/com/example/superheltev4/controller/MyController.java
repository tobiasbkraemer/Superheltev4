package com.example.superheltev4.controller;

import com.example.superheltev4.DTO.CityDTO;
import com.example.superheltev4.DTO.CountPowerDTO;
import com.example.superheltev4.DTO.HeroPowerDTO;
import com.example.superheltev4.model.Superhero;
import com.example.superheltev4.service.MyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "kea")
public class MyController {
    private MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping(path = "/superheroes")
    public ResponseEntity<List<Superhero>> getSuperheroes() {
        List<Superhero> superheroesList = myService.getSuperheroes();
        return new ResponseEntity<>(superheroesList, HttpStatus.OK);
    }
    @GetMapping(path = "/superheroes/superpower/{name}")
    public ResponseEntity<HeroPowerDTO> heroPowerByName(@PathVariable String name){
        HeroPowerDTO heroPowerDTO = myService.heroPowerDTO(name);
        return new ResponseEntity<>(heroPowerDTO,HttpStatus.OK);
    }
    @GetMapping(path = "/city/{name}")
    public ResponseEntity<CityDTO> cityByHeroName(@PathVariable String name){
        CityDTO cityDTO = myService.cityDTO(name);
        return new ResponseEntity<>(cityDTO,HttpStatus.OK);
    }
    @GetMapping(path = "/superpower/count/{name}")
    public ResponseEntity<CountPowerDTO> powerCountByName(@PathVariable("name") String name) {
        CountPowerDTO countPowerDTO = myService.countPowerDTO(name);
        return new ResponseEntity<>(countPowerDTO, HttpStatus.OK);
    }
}
