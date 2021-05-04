package com.chasbott.winenotebook.repository;

import com.chasbott.winenotebook.model.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WineRepo extends JpaRepository<Wine, Long> {


    void deleteWineById(long id);

    Wine findWineByName(String name);

    Optional <Wine> findWineById(Long id);

    Wine findWineByBrand(String brand);
}
