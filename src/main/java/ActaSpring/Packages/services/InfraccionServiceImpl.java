package ActaSpring.Packages.services;

import ActaSpring.Packages.entities.Infraccion;
import ActaSpring.Packages.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class InfraccionServiceImpl extends BaseServiceImpl<Infraccion, Long> implements InfraccionService{
    public InfraccionServiceImpl(BaseRepository<Infraccion, Long> baseRepository) {
        super(baseRepository);
    }
}
