package org.example.credietoffrehabitat.Controller;

import jakarta.validation.Valid;
import org.example.credietoffrehabitat.Entity.NouveauteBanqueEntity;
import org.example.credietoffrehabitat.Service.NouveauteBanqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/nouveaute-banque")

public class NouveauteBanqueController {

    private final NouveauteBanqueService nouveauteBanqueService;

    public NouveauteBanqueController (NouveauteBanqueService nouveauteBanqueService){
        this.nouveauteBanqueService=nouveauteBanqueService;
    }

    //BBD Contact
    @PostMapping(value = "/add")
    public ResponseEntity<String>addNouveauteBanque(@Valid @RequestBody NouveauteBanqueEntity nouveauteBanqueEntity) {
        try {
            nouveauteBanqueService.save(nouveauteBanqueEntity);
            return ResponseEntity.ok("Nouveauté bancaire ajoutée avec succès");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Une erreur s'est produite lors de l'ajout de la nouveauté bancaire");
        }
    }

    @GetMapping(value = "/findAll")
    public List<NouveauteBanqueEntity> findNouveauteBanque() {
           return nouveauteBanqueService.findAll();
    }
}
