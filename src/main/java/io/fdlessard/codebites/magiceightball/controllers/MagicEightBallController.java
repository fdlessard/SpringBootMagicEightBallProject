package io.fdlessard.codebites.magiceightball.controllers;

import io.fdlessard.codebites.magiceightball.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.services.MagicEightBallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fdlessard on 16-11-25.
 */
@RestController
@RequestMapping(value = "/MagicEightBall")
public class MagicEightBallController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MagicEightBallController.class);

    @Autowired
    private MagicEightBallService magicEightBallService;


    @GetMapping(value = "/isAlive", produces = "application/json")
    public String isAlive() {
        LOGGER.debug("MagicEightBallController.isAlive()");
        return "Hello World from MagicEightBallController";
    }

    @GetMapping(value = "/shake", produces = "application/json")
    @ResponseBody
    public MagicEightBallAnswer shake() {
        LOGGER.debug("MagicEightBallController.shake()");
        return magicEightBallService.shake();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    public MagicEightBallAnswer getById(@PathVariable long id) {
        LOGGER.debug("MagicEightBallController.getById({})", id);
        return magicEightBallService.getById(id);
    }

    @GetMapping(value = "/", produces = "application/json")
    @ResponseBody
    public Iterable<MagicEightBallAnswer> getAll() {
        LOGGER.debug("MagicEightBallController.getAll()");
        return magicEightBallService.getAll();
    }

    @PostMapping(value = "/", produces = "application/json")
    public void create(@RequestBody MagicEightBallAnswer magicEightBallAnswer)  {
        LOGGER.debug("MagicEightBallController.create({})", magicEightBallAnswer);
        magicEightBallService.save(magicEightBallAnswer);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void deleteById(@PathVariable long id) {
        LOGGER.debug("MagicEightBallController.deleteById({})", id);
        magicEightBallService.deleteById(id);
    }


}
