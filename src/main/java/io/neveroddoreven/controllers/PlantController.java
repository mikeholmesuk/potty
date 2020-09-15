package io.neveroddoreven.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.neveroddoreven.models.PlantInfo;
import io.neveroddoreven.services.PlantService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Controller(value = "/plants")
public class PlantController {

    private final PlantService plantService;

    @Inject
    public PlantController(final PlantService plantService) {
        this.plantService = plantService;
    }

    @Get(value = "/")
    public CompletableFuture<HttpResponse<List<PlantInfo>>> getPlantInfo() {
        log.info("Request to fetch plant info");

        return plantService.getPlantInfo()
                .thenApply(HttpResponse::ok);
    }
}
