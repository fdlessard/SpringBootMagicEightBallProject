package io.fdlessard.codebites.magiceightball.services;

import io.fdlessard.codebites.magiceightball.domain.MagicEightBallAnswer;

import java.util.List;

/**
 * Created by fdlessard on 16-11-25.
 */
public interface MagicEightBallService {

    MagicEightBallAnswer shake();

    MagicEightBallAnswer getById(int id);

    List<MagicEightBallAnswer> getAll();

    void deleteById(int id);

    void save(MagicEightBallAnswer magicEightBallAnswer);

}
