package org.example.credietoffrehabitat.Service;

import org.example.credietoffrehabitat.Entity.NouveauteBanqueEntity;
import org.example.credietoffrehabitat.Repository.NouveauteBanqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NouveauteBanqueServiceImpl implements NouveauteBanqueService {
    private final NouveauteBanqueRepository nouveauteBanqueRepository;

    public NouveauteBanqueServiceImpl(NouveauteBanqueRepository nouveauteBanqueRepository) {
        this.nouveauteBanqueRepository = nouveauteBanqueRepository;
    }

    @Override
    public void save(NouveauteBanqueEntity nouveauteBanque) {
        nouveauteBanqueRepository.save(nouveauteBanque);
    }

    @Override
    public List<NouveauteBanqueEntity> findAll() {
        return nouveauteBanqueRepository.findAll();
    }

    public void addNouveauteBanque() {
        NouveauteBanqueEntity nouveaute = new NouveauteBanqueEntity();
        nouveaute.setContenu("Découvrez notre nouvelle offre de prêt hypothécaire à taux fixe !");

        nouveauteBanqueRepository.save(nouveaute);
    }

}