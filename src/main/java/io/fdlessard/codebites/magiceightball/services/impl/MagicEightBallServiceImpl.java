package io.fdlessard.codebites.magiceightball.services.impl;

import io.fdlessard.codebites.magiceightball.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.services.MagicEightBallService;
import io.fdlessard.codebites.magiceightball.utils.MagicEightBallUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Created by fdlessard on 16-11-25.
 */
@Service
public class MagicEightBallServiceImpl implements MagicEightBallService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MagicEightBallServiceImpl.class);

    private static final List<MagicEightBallAnswer> MAGIC_EIGHT_BALL_ANSWERS = MagicEightBallUtils.readMagicEightBallAnswerFromYamlFile("MagicEightBallAnswers.yml");

    public MagicEightBallAnswer shake() {

        LOGGER.debug("MagicEighBallServiceImpl.shake()");

        int randomResponseIndex = generateRandomNumberBetween(1, MAGIC_EIGHT_BALL_ANSWERS.size());

        return MAGIC_EIGHT_BALL_ANSWERS.get(randomResponseIndex);
    }

    public MagicEightBallAnswer getById(int id) {

        LOGGER.debug("MagicEighBallServiceImpl.getById({})", id);

        return MAGIC_EIGHT_BALL_ANSWERS.get(id);
    }

    public List<MagicEightBallAnswer> getAll() {

        LOGGER.debug("MagicEighBallServiceImpl.getAll()");

        return MAGIC_EIGHT_BALL_ANSWERS;
    }

    public void deleteById(int id) {

        LOGGER.debug("MagicEighBallServiceImpl.deleteById({})", id);

        throw new UnsupportedOperationException("deleteById()");
    }

    public void save(MagicEightBallAnswer magicEightBallAnswer) {

        LOGGER.debug("MagicEighBallServiceImpl.save()");

        throw new UnsupportedOperationException("save()");
    }


    public static int generateRandomNumberBetween(int lowerBound, int upperBound) {
        return (new Random()).nextInt(upperBound - lowerBound) + lowerBound;
    }

}
