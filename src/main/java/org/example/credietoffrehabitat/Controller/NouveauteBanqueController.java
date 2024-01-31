package org.example.credietoffrehabitat.Controller;

import org.example.credietoffrehabitat.Entity.NouveauteBanqueEntity;
import org.example.credietoffrehabitat.Service.NouveauteBanqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@Controller
@RequestMapping(value = "NouveuteBanque")

public class NouveauteBanqueController {

    private final NouveauteBanqueService nouveauteBanqueService;

    public NouveauteBanqueController (NouveauteBanqueService nouveauteBanqueService){
        this.nouveauteBanqueService=nouveauteBanqueService;
    }

    //BBD Contact
    @PostMapping(value = "add")
    public ResponseEntity<String>addNouveauteBanque(@RequestBody NouveauteBanqueEntity nouveauteBanqueEntity) {
        try {
            nouveauteBanqueService.save(nouveauteBanqueEntity);
            return ResponseEntity.ok("Nouveauté bancaire ajoutée avec succès");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Une erreur s'est produite lors de l'ajout de la nouveauté bancaire");
        }
    }
}
