package org.example.credietoffrehabitat.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import jakarta.validation.Valid;
import org.example.credietoffrehabitat.Entity.NouveauteBanqueEntity;
import org.example.credietoffrehabitat.Service.NouveauteBanqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping(value = "/nouveauteBanque")

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
    public  String findNouveauteBanque(Model model) {
        List<NouveauteBanqueEntity> nouveautes = nouveauteBanqueService.findAll();
        model.addAttribute("nouveautes", nouveautes);
        return "nouveauteBanque";
    }
}
