package org.example.credietoffrehabitat.Service;

import org.example.credietoffrehabitat.Entity.NouveauteBanqueEntity;

import java.util.List;

public interface NouveauteBanqueService {
void save (NouveauteBanqueEntity nouveauteBanque);
List<NouveauteBanqueEntity>findAll();
}

