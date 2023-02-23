package co.develhope.logging.controllers;

import co.develhope.logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    Logger logger = LoggerFactory.getLogger(BasicController.class);

    @Autowired
    private BasicService basicService;

    @GetMapping("/")
    public String welcomeMsg() {
        try {
            logger.info("INFO logging: welcomeMsg() - START");
            return "Welcome!";
        } finally {
            logger.info("INFO logging: welcomeMsg() - END");
        }
    }

    @GetMapping("/exp")
    public double power() {
        return basicService.getPow();
    }

    @GetMapping("/get-errors")
    public void getErrors() {
        Error error = new Error("This is the custom error");
        logger.error("ERROR logging:", error);
    }
}