package io.fdlessard.codebites.magiceightball.services.impl;

import io.fdlessard.codebites.magiceightball.domain.MagicEightBallResponse;
import io.fdlessard.codebites.magiceightball.services.MagicEightBallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by fdlessard on 16-11-25.
 */
@Service
public class MagicEightBallServiceImpl implements MagicEightBallService {


    private static final Logger LOGGER = LoggerFactory.getLogger(MagicEightBallServiceImpl.class);

    private static final String GREEN = "green";
    private static final String BLUE = "blue";
    private static final String RED = "red";

    private static Map<Integer, MagicEightBallResponse> responseMap = new HashMap<>();

    static {
        responseMap.put(1, new MagicEightBallResponse("1", "It is certain", GREEN));
        responseMap.put(2, new MagicEightBallResponse("2", "It is decidedly so", GREEN));
        responseMap.put(3, new MagicEightBallResponse("3", "Without a doubt", GREEN));
        responseMap.put(4, new MagicEightBallResponse("4", "Yes, definitely", GREEN));
        responseMap.put(5, new MagicEightBallResponse("5", "You may rely on it", GREEN));
        responseMap.put(6, new MagicEightBallResponse("6", "As I see it, yes", GREEN));
        responseMap.put(7, new MagicEightBallResponse("7", "Most likely", GREEN));
        responseMap.put(8, new MagicEightBallResponse("8", "Outlook good", GREEN));
        responseMap.put(9, new MagicEightBallResponse("9", "Yes", GREEN));
        responseMap.put(10, new MagicEightBallResponse("10", "Signs point to yes", GREEN));

        responseMap.put(11, new MagicEightBallResponse("11", "Reply hazy try again", BLUE));
        responseMap.put(12, new MagicEightBallResponse("12", "Ask again later", BLUE));
        responseMap.put(13, new MagicEightBallResponse("13", "Better not tell you now", BLUE));
        responseMap.put(14, new MagicEightBallResponse("14", "Cannot predict now", BLUE));
        responseMap.put(15, new MagicEightBallResponse("15", "Concentrate and ask again", BLUE));

        responseMap.put(16, new MagicEightBallResponse("16", "Don't count on it", RED));
        responseMap.put(17, new MagicEightBallResponse("17", "My reply is no", RED));
        responseMap.put(18, new MagicEightBallResponse("18", "My sources say no", RED));
        responseMap.put(19, new MagicEightBallResponse("19", "Outlook not so good", RED));
        responseMap.put(20, new MagicEightBallResponse("20", "Very doubtful", RED));
    }


    public MagicEightBallResponse shake() {

        LOGGER.debug("MagicEighBallServiceImpl.shake()");

        int randomResponseIndex = generateRandomNumberBetween(1, responseMap.size());

        return responseMap.get(randomResponseIndex);
    }

    public static int generateRandomNumberBetween(int lowerBound, int upperBound) {
        return (new Random()).nextInt(upperBound - lowerBound) + lowerBound;
    }

}
