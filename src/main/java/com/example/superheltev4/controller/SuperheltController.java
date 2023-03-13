package com.example.superheltev4.controller;

import com.example.superheltev4.service.SuperheltService;
import com.example.superheltev4.model.Superhelt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("Superhelt")
public class SuperheltController {

   SuperheltService superheltService;

    public SuperheltController (SuperheltService superheltService) {
        this.superheltService=superheltService;
    }


    @RequestMapping("/")
    public ResponseEntity<?> printSuperhelte(@RequestParam(required = false) String format) {
        List<Superhelt> superhelte = superheltService.getSuperhelte();
        for (Superhelt helt : superhelte) {
            helt.getName();
            helt.getSuperpower();
            helt.isHuman();
            helt.getIntroYear();
            helt.getStrengthPoint();
        }
        return new ResponseEntity<>(superhelte, HttpStatus.OK);

    }

    @RequestMapping(path = "/{navn}")
    public ResponseEntity<List<Superhelt>> printSpecifikSuperhelt(@PathVariable String navn) {
        List<Superhelt> searchResults = superheltService.searchForSuperhero(navn);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

    @PostMapping(path = "/opret")
    public ResponseEntity<Superhelt> opretSuperhelt(@RequestBody Superhelt superhelt) {
        Superhelt newSuperhelt = superheltService.createSuperhelt(superhelt.getName(), superhelt.getSuperpower(), superhelt.isHuman(), superhelt.getIntroYear(), superhelt.getStrengthPoint());
        return new ResponseEntity<Superhelt>(newSuperhelt, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/slet/{navn}")
    public ResponseEntity<List<Superhelt>> sletSuperhelt(@PathVariable String navn) {
        superheltService.deleteSuperhero(navn);
        return new ResponseEntity(HttpStatus.OK);
    }
}
