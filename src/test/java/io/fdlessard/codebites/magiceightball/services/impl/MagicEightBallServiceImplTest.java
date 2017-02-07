package io.fdlessard.codebites.magiceightball.services.impl;

import io.fdlessard.codebites.magiceightball.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.services.MagicEightBallService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by fdlessard on 16-11-27.
 */
public class MagicEightBallServiceImplTest {

    private MagicEightBallService magicEightBallService;

    @Before
    public void setUp() {
        magicEightBallService = new MagicEightBallServiceImpl();
    }

    @Test
    public void shake() throws Exception {

        MagicEightBallAnswer magicEightBallAnswer = magicEightBallService.shake();

        assertNotNull(magicEightBallAnswer);

    }

    @Test
    public void getById() throws Exception {

        MagicEightBallAnswer magicEightBallAnswer = magicEightBallService.getById(1);

        assertNotNull(magicEightBallAnswer);
    }

    @Test
    public void getAll() throws Exception {

        Iterable<MagicEightBallAnswer> magicEightBallAnswers = magicEightBallService.getAll();

        assertNotNull(magicEightBallAnswers);

       // assertEquals(20, magicEightBallAnswers.());
    }

}