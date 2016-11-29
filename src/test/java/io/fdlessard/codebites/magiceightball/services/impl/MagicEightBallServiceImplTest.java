package io.fdlessard.codebites.magiceightball.services.impl;

import io.fdlessard.codebites.magiceightball.domain.MagicEightBallResponse;
import io.fdlessard.codebites.magiceightball.services.MagicEightBallService;
import org.junit.Before;
import org.junit.Test;

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

        MagicEightBallResponse magicEightBallResponse = magicEightBallService.shake();

        assertNotNull(magicEightBallResponse);

    }

    @Test
    public void getById() throws Exception {

        MagicEightBallResponse magicEightBallResponse = magicEightBallService.getById(1);

        assertNotNull(magicEightBallResponse);
    }

    @Test
    public void getAll() throws Exception {

        List<MagicEightBallResponse> magicEightBallResponses = magicEightBallService.getAll();

        assertNotNull(magicEightBallResponses);
        assertEquals(20, magicEightBallResponses.size());
    }

}