package com.controller;

import com.dao.ClientRepository;
import com.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@CrossOrigin("*")
public class skynetRestController {
    @Autowired
    private ClientRepository cliRepo;

    @RequestMapping(value = "/connecter", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Client connecter(@RequestBody Map<String, infoAuth> payload) {
      Client c =   cliRepo.findAll()
                .stream()
                .filter(client -> client.getMail().equals(payload.get("creditials").getPseudo()))
                .filter(client -> client.getMdp().equals(payload.get("creditials").getMdp()))
                .findFirst().orElse(new Client());
        return  c;
    }

}

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
class infoAuth {
    private String mdp;
    private String pseudo;
}