package io.fdlessard.codebites.magiceightball.services.impl;

import io.fdlessard.codebites.magiceightball.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.repositories.MagicEightBallRepository;
import io.fdlessard.codebites.magiceightball.services.MagicEightBallService;
import io.fdlessard.codebites.magiceightball.utils.MagicEightBallUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MagicEightBallRepository magicEightBallRepository;

    public MagicEightBallAnswer shake() {

        LOGGER.debug("MagicEighBallServiceImpl.shake()");

        int randomResponseIndex = generateRandomNumberBetween(1, (int) magicEightBallRepository.count());

        magicEightBallRepository.findOne((long) randomResponseIndex);

        return MAGIC_EIGHT_BALL_ANSWERS.get(randomResponseIndex);
    }

    public MagicEightBallAnswer getById(long id) {

        LOGGER.debug("MagicEighBallServiceImpl.getById({})", id);

        return magicEightBallRepository.findOne(id);
    }

    public Iterable<MagicEightBallAnswer> getAll() {

        LOGGER.debug("MagicEighBallServiceImpl.getAll()");

        return magicEightBallRepository.findAll();
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
