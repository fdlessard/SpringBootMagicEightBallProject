package io.fdlessard.codebites.magiceightball.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.fdlessard.codebites.magiceightball.domain.MagicEightBallAnswer;
import org.springframework.core.io.ClassPathResource;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fdlessard on 16-12-01.
 */
public class MagicEightBallUtils {

    private MagicEightBallUtils() {

    }
    
    public static List<MagicEightBallAnswer> readMagicEightBallAnswerFromYamlFile(String fileName) {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            return Arrays.asList(
                    mapper.readValue(
                            new ClassPathResource(fileName).getInputStream(),
                            MagicEightBallAnswer[].class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}