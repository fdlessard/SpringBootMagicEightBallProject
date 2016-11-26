package io.fdlessard.codebites.magiceightball.controllers;

import io.fdlessard.codebites.magiceightball.domain.MagicEightBallResponse;
import io.fdlessard.codebites.magiceightball.services.MagicEightBallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fdlessard on 16-11-25.
 */
@RestController
public class MagicEightBallController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MagicEightBallController.class);

    @Autowired
    private MagicEightBallService magicEightBallService;


    @RequestMapping(value = "/isAlive", method = RequestMethod.GET, produces = "application/json")
    public String isAlive() {

        LOGGER.debug("MagicEightBallController.isAlive()");

        return "Hello World from MagicEightBallController";
    }

    @RequestMapping(value = "/shake", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    MagicEightBallResponse shake() {

        LOGGER.debug("MagicEightBallController.shake()");

        return magicEightBallService.shake();
    }
}
