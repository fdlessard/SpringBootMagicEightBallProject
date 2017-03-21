package io.fdlessard.codebites.magiceightball.services;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import io.fdlessard.codebites.magiceightball.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.repositories.MagicEightBallRepository;
import io.fdlessard.codebites.magiceightball.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;

/**
 * Created by fdlessard on 16-11-27.
 */
@RunWith(MockitoJUnitRunner.class)
public class MagicEightBallServiceImplTest {

    @Mock
    private MagicEightBallRepository magicEightBallRepository;
    @InjectMocks
    private MagicEightBallServiceImpl magicEightBallService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(magicEightBallService);
    }

    @Test
    public void shake() throws Exception {
        Mockito.when(magicEightBallRepository.findAll()).thenReturn( TestUtils.buildMagicEightBallAnswers(5) );
        MagicEightBallAnswer magicEightBallAnswer = magicEightBallService.shake();
        assertNotNull(magicEightBallAnswer);
    }

    // @Test
    public void shakeWithEmptyList() throws Exception {
        Mockito.when(magicEightBallRepository.findAll()).thenReturn(new ArrayList<MagicEightBallAnswer>());
        MagicEightBallAnswer magicEightBallAnswer = magicEightBallService.shake();
        assertNotNull(magicEightBallAnswer);
    }

    @Test
    public void getById() throws Exception {
        MagicEightBallAnswer magicEightBallAnswer = TestUtils.buildMagicEightBallAnswer();
        Mockito.when(magicEightBallRepository.findOne(any())).thenReturn(magicEightBallAnswer);
        MagicEightBallAnswer magicEightBallAnswerResponse = magicEightBallService.getById(1);
        assertNotNull(magicEightBallAnswerResponse);
        assertEquals(magicEightBallAnswer.toString(), magicEightBallAnswerResponse.toString());
    }

    //@Test
    public void getByIdNotFound() throws Exception {
    }

/*
    @Test
    public void getByIds() throws Exception {
        Iterable<Long> ids = Collections.unmodifiableList(Arrays.asList(0l, 1l, 2l, 3l, 4l));
        Iterable<MagicEightBallAnswer> magicEightBallAnswersResponse = TestUtils.buildMagicEightBallAnswers(5);
        Mockito.when(magicEightBallRepository.findAll(ids)).thenReturn(magicEightBallAnswersResponse);
        List<MagicEightBallAnswer> magicEightBallAnswers = magicEightBallService.getByIds(ids);
        assertNotNull(magicEightBallAnswers);
        assertEquals(5, Iterables.size(magicEightBallAnswers));
    }
*/

    @Test
    public void getAll() throws Exception {
        Mockito.when(magicEightBallRepository.findAll()).thenReturn(TestUtils.buildMagicEightBallAnswers(5));
        Iterable<MagicEightBallAnswer> magicEightBallAnswers = magicEightBallService.getAll();
        assertNotNull(magicEightBallAnswers);
        List<MagicEightBallAnswer> target = new ArrayList<>();
        magicEightBallAnswers.forEach(target::add);
        assertEquals(5, target.size());
    }

    @Test
    public void getAllWithEmptyList() throws Exception {
        Mockito.when(magicEightBallRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
        Iterable<MagicEightBallAnswer> magicEightBallAnswers = magicEightBallService.getAll();
        assertNotNull(magicEightBallAnswers);
        assertEquals(0, Iterables.size(magicEightBallAnswers));
    }

    @Test
    public void saveSingleMagicEightBallAnswer() {
        MagicEightBallAnswer magicEightBallAnswer = TestUtils.buildMagicEightBallAnswer();
        magicEightBallService.save(magicEightBallAnswer);
        Mockito.verify(magicEightBallRepository, times(1)).save(magicEightBallAnswer);
    }

    @Test
    public void saveMultipleMagicEightBallAnswers() {
        Iterable<MagicEightBallAnswer> magicEightBallAnswers = TestUtils.buildMagicEightBallAnswers(5);
        magicEightBallService.save(magicEightBallAnswers);
        Mockito.verify(magicEightBallRepository, times(1)).save(magicEightBallAnswers);
    }

    @Test
    public void delete() {
        magicEightBallService.deleteById(0);
        Mockito.verify(magicEightBallRepository, times(1)).delete(0l);
    }
}