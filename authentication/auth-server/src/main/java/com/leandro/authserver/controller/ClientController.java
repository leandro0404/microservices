package com.leandro.authserver.controller;


import com.leandro.authserver.entity.Client;
import com.leandro.authserver.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public String showClients(Model model) {
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "client/list";
    }

    @GetMapping("/new")
    public String showCreateClientForm(Model model) {
        model.addAttribute("id", UUID.randomUUID().toString());
        return "client/create";
    }

    @PostMapping("/new")
    public String createClient(@ModelAttribute Client client) {
         clientService.create(client);
        return "redirect:/clients";
    }
}
