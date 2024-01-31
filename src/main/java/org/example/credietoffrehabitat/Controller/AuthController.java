package org.example.credietoffrehabitat.Controller;

import jakarta.validation.Valid;
import org.example.credietoffrehabitat.Entity.ClientEntity;
import org.example.credietoffrehabitat.Service.ClientService;
import org.example.credietoffrehabitat.dto.ClientDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {

    private ClientService clientService;

    public AuthController(ClientService clientService) {
        this.clientService = clientService;
    }

    // handler method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    // handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        ClientDto clientEntity = new ClientDto();
        model.addAttribute("client", clientEntity);
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") ClientDto clientDto,
                               BindingResult result,
                               Model model){
        ClientEntity existingClientEntity = clientService.findUserByEmail(clientDto.getEmail());

        if(existingClientEntity != null && existingClientEntity.getEmail() != null && !existingClientEntity.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", clientDto);
            return "/register";
        }

        clientService.saveUser(clientDto);
        return "redirect:/register?success";
    }

    // handler method to handle list of users
    @GetMapping("/users")
    public String users(Model model){
        List<ClientDto> users = clientService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
