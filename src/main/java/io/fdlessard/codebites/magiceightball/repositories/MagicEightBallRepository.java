package io.fdlessard.codebites.magiceightball.repositories;

import io.fdlessard.codebites.magiceightball.domain.MagicEightBallAnswer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fdlessard on 17-02-04.
 */
@Repository
public interface MagicEightBallRepository extends CrudRepository<MagicEightBallAnswer, Long> {

    @Query("select m from MagicEightBallAnswer m where m.id in :ids")
    List<MagicEightBallAnswer> findByIds(@Param("ids") List<Long> ids);

}
