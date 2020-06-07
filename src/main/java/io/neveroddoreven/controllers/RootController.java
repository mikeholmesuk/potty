package io.neveroddoreven.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.neveroddoreven.models.ApplicationInfo;
import io.neveroddoreven.services.ApplicationService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Controller(value = "/")
public class RootController {

    private final ApplicationService applicationService;

    @Inject
    public RootController(final ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Get
    public CompletableFuture<HttpResponse<ApplicationInfo>> getApplicationInfo() {
        log.info("Requested application info");

        return applicationService.getLatestApplicationInfo()
                .thenApply(HttpResponse::ok);
    }
}
