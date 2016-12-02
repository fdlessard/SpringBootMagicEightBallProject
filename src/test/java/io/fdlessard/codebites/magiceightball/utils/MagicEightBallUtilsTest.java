package io.fdlessard.codebites.magiceightball.utils;

import io.fdlessard.codebites.magiceightball.domain.MagicEightBallAnswer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by fdlessard on 16-12-01.
 */
public class MagicEightBallUtilsTest {

    @Before
    public void setUp() {

    }

    @Test
    public void readMagicEightBallAnswerFromYamlFile() throws Exception {

        List<MagicEightBallAnswer> magicEightBallAnswers = MagicEightBallUtils.readMagicEightBallAnswerFromYamlFile("MagicEightBallAnswers.yml");

        assertNotNull(magicEightBallAnswers);
        assertEquals(20, magicEightBallAnswers.size());
    }
    
}