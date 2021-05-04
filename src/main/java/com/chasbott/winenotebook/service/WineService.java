package com.chasbott.winenotebook.service;

import com.chasbott.winenotebook.exception.UserNotFoundException;
import com.chasbott.winenotebook.model.Wine;
import com.chasbott.winenotebook.repository.WineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineService {
    private final WineRepo wineRepo;


    @Autowired
    public WineService(WineRepo wineRepo) {
        this.wineRepo = wineRepo;
    }

    public Wine addWine(Wine wine){
        return wineRepo.save(wine);
    }

    public List<Wine>findAllWine(){
        return wineRepo.findAll();
    }

    public Wine updateWine(Wine wine){
        return wineRepo.save(wine);
    }

    public void deleteWine(long id){
        wineRepo.deleteWineById(id);
    }

    public Wine findWine(Long id){
        return wineRepo.findWineById(id)
                .orElseThrow(() -> new UserNotFoundException("User by  " + id + " was not found"));
    }

    public Wine findBrand(String brand){
        return wineRepo.findWineByBrand(brand);
    }
    public Wine findWine(String name){
        return wineRepo.findWineByName(name);
    }
}
