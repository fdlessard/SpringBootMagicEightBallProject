package io.fdlessard.codebites.magiceightball.repositories;

import io.fdlessard.codebites.magiceightball.domain.MagicEightBallAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by fdlessard on 17-02-04.
 */
@Repository
public interface MagicEightBallRepository extends CrudRepository<MagicEightBallAnswer, Long> {

}
