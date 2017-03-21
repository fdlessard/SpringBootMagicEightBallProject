package io.fdlessard.codebites.magiceightball.services;

import io.fdlessard.codebites.magiceightball.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.repositories.MagicEightBallRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by fdlessard on 16-11-25.
 */
@Service
public class MagicEightBallServiceImpl implements MagicEightBallService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MagicEightBallServiceImpl.class);

    @Autowired
    private MagicEightBallRepository magicEightBallRepository;

    public MagicEightBallAnswer shake() {
        LOGGER.debug("MagicEighBallServiceImpl.shake()");
        Iterable<MagicEightBallAnswer>  it = magicEightBallRepository.findAll();
        List<MagicEightBallAnswer> magicEightBallAnswers = new ArrayList<>();
        it.forEach(magicEightBallAnswers::add);
        int randomResponseIndex = generateRandomNumberBetween(1, magicEightBallAnswers.size());

        return magicEightBallAnswers.get(randomResponseIndex - 1);
    }

    public MagicEightBallAnswer getById(long id) {
        LOGGER.debug("MagicEighBallServiceImpl.getById({})", id);
        return magicEightBallRepository.findOne(id);
    }

    public List<MagicEightBallAnswer> getByIds(List<Long> ids) {
        LOGGER.debug("MagicEighBallServiceImpl.getByIds({})", ids);
        return magicEightBallRepository.findByIds(ids);
    }

    public Iterable<MagicEightBallAnswer> getAll() {
        LOGGER.debug("MagicEighBallServiceImpl.getAll()");
        return magicEightBallRepository.findAll();
    }

    public void deleteById(long id) {
        LOGGER.debug("MagicEighBallServiceImpl.deleteById({})", id);
        magicEightBallRepository.delete(id);
    }

    public void save(MagicEightBallAnswer magicEightBallAnswer) {
        LOGGER.debug("MagicEighBallServiceImpl.save()");
        magicEightBallRepository.save(magicEightBallAnswer);
    }

    public void save(Iterable<MagicEightBallAnswer> magicEightBallAnswers) {
        LOGGER.debug("MagicEighBallServiceImpl.save()");
        magicEightBallRepository.save(magicEightBallAnswers);
    }

    public static int generateRandomNumberBetween(int lowerBound, int upperBound) {
        if(upperBound <= lowerBound) {
            return upperBound;
        }
        return (new Random()).nextInt(upperBound - lowerBound) + lowerBound;
    }
}
