package io.fdlessard.codebites.magiceightball.services;

import io.fdlessard.codebites.magiceightball.domain.MagicEightBallResponse;

import java.util.List;

/**
 * Created by fdlessard on 16-11-25.
 */
public interface MagicEightBallService {

    MagicEightBallResponse shake();

    MagicEightBallResponse getById(int id);

    List<MagicEightBallResponse> getAll();

    void deleteById(int id);

    void save(MagicEightBallResponse magicEightBallResponse);

}
