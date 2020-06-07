package io.neveroddoreven.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlantInfo {
    @JsonProperty(value = "name")
    private final String name;
    @JsonProperty(value = "alternate_name")
    private final String alternateName;
    @JsonProperty(value = "sow_instructions")
    private final String sowInstructions;
    @JsonProperty(value = "space_instructions")
    private final String spaceInstructions;
    @JsonProperty(value = "harvest_instructions")
    private final String harvestInstructions;
    @JsonProperty(value = "compatible_plants")
    private final String compatiblePlants;
    @JsonProperty(value = "avoid_instructions")
    private final String avoidInstructions;
    @JsonProperty(value = "culinary_hints")
    private final String culinaryHints;
    @JsonProperty(value = "culinary_preservation")
    private final String culinaryPreservation;
    @JsonProperty(value = "url")
    private final String url;
}
