package io.fdlessard.codebites.magiceightball.domain;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fdlessard.codebites.magiceightball.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by fdlessard on 17-03-17.
 */
public class MagicEightBallAnswerTest {

    private MagicEightBallAnswer magicEightBallAnswerX;
    private MagicEightBallAnswer magicEightBallAnswerY;
    private MagicEightBallAnswer magicEightBallAnswerZ;
    private MagicEightBallAnswer emptyMagicEightBallAnswer;

    @Before
    public void setUp() throws Exception {
        magicEightBallAnswerX = TestUtils.buildMagicEightBallAnswer();
        magicEightBallAnswerY = TestUtils.buildMagicEightBallAnswersFromFile("target/test-classes/MagicEightBallAnswer.json");
        magicEightBallAnswerZ = TestUtils.buildMagicEightBallAnswer();
        emptyMagicEightBallAnswer = new MagicEightBallAnswer();
    }

    @Test
    public void marshallingMagicEightBallAnswerToJson() {
        JsonNode node = new ObjectMapper().convertValue(magicEightBallAnswerX, JsonNode.class);
        assertNotNull(node);
        assertEquals(TestUtils.TEST_ID.longValue(), node.get("id").asLong());
        assertEquals(TestUtils.TEST_MESSAGE, node.get("message").asText());
        assertEquals(TestUtils.TEST_COLOR, node.get("color").asText());
        assertNull(node.get("tenantId"));
        assertNull(node.get("version"));
    }

    @Test
    public void unmarshallingJsonToMagicEightBallAnswer() throws IOException {
        assertNotNull(magicEightBallAnswerY);
        assertEquals(TestUtils.TEST_ID, magicEightBallAnswerY.getId());
        assertEquals(null, magicEightBallAnswerY.getTenantId());
        assertEquals(0, magicEightBallAnswerY.getVersion());
        assertEquals(TestUtils.TEST_MESSAGE, magicEightBallAnswerY.getMessage());
        assertEquals(TestUtils.TEST_COLOR, magicEightBallAnswerY.getColor());
    }

    @Test
    public void toStringWithEmptyMagicEightBallAnswer() throws Exception {
        assertNotNull(emptyMagicEightBallAnswer.toString());
    }

    @Test
    public void notEquals() {
        assertFalse(magicEightBallAnswerX.equals(magicEightBallAnswerY));
    }

    @Test
    public void equalsReflexivity() throws Exception {
        assertTrue(magicEightBallAnswerX.equals(magicEightBallAnswerX));
    }

    @Test
    public void equalsSymmetry() throws Exception {
        magicEightBallAnswerY.setTenantId(TestUtils.TEST_TENANT);
        assertTrue(magicEightBallAnswerX.equals(magicEightBallAnswerY));
        assertTrue(magicEightBallAnswerY.equals(magicEightBallAnswerX));
    }

    @Test
    public void equalsTransitivity() throws Exception {
        magicEightBallAnswerY.setTenantId(TestUtils.TEST_TENANT);
        assertTrue(magicEightBallAnswerX.equals(magicEightBallAnswerY));
        assertTrue(magicEightBallAnswerY.equals(magicEightBallAnswerZ));
        assertTrue(magicEightBallAnswerZ.equals(magicEightBallAnswerX));
    }

    @Test
    public void equalsConsistency() throws Exception {
        magicEightBallAnswerY.setTenantId(TestUtils.TEST_TENANT);
        assertTrue(magicEightBallAnswerX.equals(magicEightBallAnswerY));
        assertTrue(magicEightBallAnswerY.equals(magicEightBallAnswerY));
    }

    @Test
    public void equalsWithEmptyMagicEightBallAnswers() {
        assertTrue(emptyMagicEightBallAnswer.equals(emptyMagicEightBallAnswer));
    }

    @Test
    public void equalsWithMagicEightBallAnswerAndNull() {
        assertFalse(emptyMagicEightBallAnswer.equals(null));
    }

    @Test
    public void hashCodeWithEmptyhMagicEightBallAnswer() throws Exception {
        emptyMagicEightBallAnswer.hashCode();
    }

    @Test
    public void hashCodeAndEquals() {
        magicEightBallAnswerY.setTenantId(TestUtils.TEST_TENANT);
        assertTrue(magicEightBallAnswerX.equals(magicEightBallAnswerY));
        assertEquals(magicEightBallAnswerX.hashCode(), magicEightBallAnswerY.hashCode());
    }
}