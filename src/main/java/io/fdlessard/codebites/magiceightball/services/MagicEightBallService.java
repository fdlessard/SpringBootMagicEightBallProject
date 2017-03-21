package io.fdlessard.codebites.magiceightball.services;

import io.fdlessard.codebites.magiceightball.domain.MagicEightBallAnswer;

import java.util.List;

/**
 * Created by fdlessard on 16-11-25.
 */
public interface MagicEightBallService {

    MagicEightBallAnswer shake();

    MagicEightBallAnswer getById(long id);

    List<MagicEightBallAnswer> getByIds(List<Long> ids);

    Iterable<MagicEightBallAnswer> getAll();

    void deleteById(long id);

    void save(MagicEightBallAnswer magicEightBallAnswer);

    void save(Iterable<MagicEightBallAnswer> magicEightBallAnswer);
}
