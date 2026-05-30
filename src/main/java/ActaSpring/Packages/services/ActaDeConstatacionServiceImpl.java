package ActaSpring.Packages.services;

import ActaSpring.Packages.entities.ActaDeConstatacion;
import ActaSpring.Packages.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class ActaDeConstatacionServiceImpl extends BaseServiceImpl<ActaDeConstatacion,Long> implements ActaDeConstatacionService{

    public ActaDeConstatacionServiceImpl(BaseRepository<ActaDeConstatacion,Long> baseRepository) {
        super(baseRepository);
    }
}
