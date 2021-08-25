// package com.apple.caat.controller;
package com.produtos.apirest.resources;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Tag(name = "Swagger Example", description = "An example about how to documment your API...")
@RequestMapping("/api/swagger-example")
public class SwaggerExample {
    Logger logger = (Logger) LoggerFactory.getLogger(SwaggerExample.class);

    @GetMapping()
    @Operation(summary = "It's only show different log types on console", description = "Call the route and see the console")
    @Parameter(name = "Any", description = "Any parameter is necessary, it's only to show how doc if necessary")
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    public String logMessage() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }
}