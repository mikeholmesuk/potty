package io.neveroddoreven.services;

import io.micronaut.context.annotation.Property;
import io.neveroddoreven.models.ApplicationInfo;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import java.util.concurrent.CompletableFuture;

@Singleton
@Slf4j
public class ApplicationService {
    private final String applicationName;
    private final String applicationAuthor;

    public ApplicationService(@Property(name = "micronaut.application.name") String applicationName,
                          @Property(name = "micronaut.application.author") String applicationAuthor) {
        this.applicationName = applicationName;
        this.applicationAuthor = applicationAuthor;
    }

    public CompletableFuture<ApplicationInfo> getLatestApplicationInfo() {
        log.info("fetching latest application Info");

        return CompletableFuture.supplyAsync(() -> ApplicationInfo.builder()
                .applicationName(this.applicationName)
                .applicationAuthor(this.applicationAuthor)
                .build());
    }
}
