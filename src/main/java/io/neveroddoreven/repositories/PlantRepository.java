package io.neveroddoreven.repositories;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.CSVReader;
import io.micronaut.context.annotation.Property;
import io.micronaut.core.io.ResourceResolver;
import io.neveroddoreven.models.PlantInfo;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Singleton
@Slf4j
public class PlantRepository {
    private final List<PlantInfo> plantInfoList;

    @Inject
    public PlantRepository(final ResourceResolver resourceResolver,
                           @Property(name = "micronaut.data.local.file-name") final String fileName) throws Exception {
        log.info("Initialising plant data from source file: {}", fileName);

        final InputStream inputStream = resourceResolver
                .getResourceAsStream(String.format("classpath:data/%s", fileName)).get();

        this.plantInfoList = new CSVReader(new InputStreamReader(inputStream)).readAll().stream()
                .skip(1L)
                .map(strings -> {
                    return PlantInfo.builder()
                            .name(strings[0])
                            .alternateName(strings[1])
                            .sowInstructions(strings[2])
                            .spaceInstructions(strings[3])
                            .harvestInstructions(strings[4])
                            .compatiblePlants(strings[5])
                            .avoidInstructions(strings[6])
                            .culinaryHints(strings[7])
                            .culinaryPreservation(strings[8])
                            .url(strings[9])
                            .build();
                }).collect(Collectors.toList());
    }

    public CompletableFuture<List<PlantInfo>> getAllPlantInfo() {
        return CompletableFuture.completedFuture(this.plantInfoList);
    }
}
