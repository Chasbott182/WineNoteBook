package com.chasbott.winenotebook;

import com.chasbott.winenotebook.model.Wine;
import com.chasbott.winenotebook.service.WineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wine")
public class WineResource {
    private final WineService wineService;

    public WineResource(WineService wineService) {
        this.wineService = wineService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Wine>> getAllWine() {
        List<Wine> wines = wineService.findAllWine();
        return new ResponseEntity<>(wines, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Wine> getWineById(@PathVariable("id") long id) {
        Wine wine = wineService.findWine(id);
        return new ResponseEntity<>(wine, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Wine> addWine(@RequestBody Wine wine) {
        Wine newWine = wineService.addWine(wine);
        return new ResponseEntity<>(newWine, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Wine> updateWine(@RequestBody Wine wine) {
        Wine updateWine = wineService.updateWine(wine);
        return new ResponseEntity<>(updateWine, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteWine(@PathVariable("id") long id) {
        wineService.deleteWine(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}