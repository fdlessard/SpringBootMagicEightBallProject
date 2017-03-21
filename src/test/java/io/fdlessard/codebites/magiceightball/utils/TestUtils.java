package io.fdlessard.codebites.magiceightball.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fdlessard.codebites.magiceightball.domain.MagicEightBallAnswer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fdlessard on 17-03-17.
 */
public final class TestUtils {

    public static final Long TEST_ID = 0l;
    public static final String TEST_TENANT = "testTenant";
    public static final String TEST_MESSAGE = "A message";
    public static final String TEST_COLOR = "red";

    private TestUtils() {}

    public static String readFileIntoString(String fileName) throws IOException {
        return new Scanner(new File(fileName)).useDelimiter("\\Z").next();
    }

    public static MagicEightBallAnswer buildMagicEightBallAnswersFromFile(String fileName) throws IOException {
        String magicEightBallAnswerString = TestUtils.readFileIntoString(fileName);
        return new ObjectMapper().readValue(magicEightBallAnswerString, MagicEightBallAnswer.class);
    }

    public static MagicEightBallAnswer buildMagicEightBallAnswer() {

        MagicEightBallAnswer magicEightBallAnswer = new MagicEightBallAnswer();

        magicEightBallAnswer.setId(TestUtils.TEST_ID);
        magicEightBallAnswer.setVersion(0);
        magicEightBallAnswer.setTenantId(TestUtils.TEST_TENANT);
        magicEightBallAnswer.setMessage(TestUtils.TEST_MESSAGE);
        magicEightBallAnswer.setColor(TestUtils.TEST_COLOR);

        return magicEightBallAnswer;
    }

    public static List<MagicEightBallAnswer> buildMagicEightBallAnswers(int size) {
        List<MagicEightBallAnswer> magicEightBallAnswers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            MagicEightBallAnswer magicEightBallAnswer = new MagicEightBallAnswer();
            magicEightBallAnswer.setId((long) i);
            magicEightBallAnswer.setMessage("A message" + String.valueOf(i) );
            magicEightBallAnswer.setColor("red");
            magicEightBallAnswers.add(magicEightBallAnswer);
        }
        return magicEightBallAnswers;
    }
}
