package co.develhope.logging.services;

import co.develhope.logging.controllers.BasicController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BasicService {

    Logger logger = LoggerFactory.getLogger(BasicService.class);

    @Autowired
    private Environment environment;

    public int getPow() {
        int n1 = Integer.parseInt(Objects.requireNonNull(environment.getProperty("customEnvs.n1")));
        int n2 = Integer.parseInt(Objects.requireNonNull(environment.getProperty("customEnvs.n2")));
        int pow = (int) Math.pow(n1, n2);
        try {
            logger.info("INFO logging: getPow() - Starting pow calculation of {}^{}", n1, n2);
            logger.info("The result is {}", pow);
            return pow;
        } finally {
            logger.info("INFO logging: getPow() - Finished pow calculation");
        }
    }
}