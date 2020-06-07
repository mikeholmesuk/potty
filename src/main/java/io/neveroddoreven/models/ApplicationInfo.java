package io.neveroddoreven.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ApplicationInfo {
    @JsonProperty(value = "application_name")
    private final String applicationName;
    @JsonProperty(value = "application_author")
    private final String applicationAuthor;
    @Builder.Default
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    @JsonProperty(value = "request_time")
    private final Instant requestTime = Instant.now();
}
