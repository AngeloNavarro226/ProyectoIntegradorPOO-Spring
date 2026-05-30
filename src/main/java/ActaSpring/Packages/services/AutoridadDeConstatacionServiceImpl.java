package ActaSpring.Packages.services;


import ActaSpring.Packages.entities.AutoridadDeConstatacion;
import ActaSpring.Packages.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class AutoridadDeConstatacionServiceImpl extends BaseServiceImpl<AutoridadDeConstatacion,Long> implements AutoridadDeConstatacionService{

    public AutoridadDeConstatacionServiceImpl(BaseRepository<AutoridadDeConstatacion, Long> baseRepository) {
        super(baseRepository);
    }
}
