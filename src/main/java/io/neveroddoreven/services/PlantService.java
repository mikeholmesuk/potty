package io.neveroddoreven.services;

import io.neveroddoreven.models.PlantInfo;
import io.neveroddoreven.repositories.PlantRepository;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Singleton
@Slf4j
public class PlantService {

    private final PlantRepository plantRepository;

    @Inject
    public PlantService(final PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public CompletableFuture<List<PlantInfo>> getPlantInfo() {
        log.info("Returning all plant info");

        return plantRepository.getAllPlantInfo();
    }
}
