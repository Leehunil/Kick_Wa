package DSC.Kick_Wa.service;

import DSC.Kick_Wa.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ApiService {

    private final PlaceRepository placeRepository;


}
