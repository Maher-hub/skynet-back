package com;

import com.dao.ClientRepository;
import com.dao.ReservationRepository;
import com.dao.SpectacleRepository;
import com.entities.Client;
import com.entities.Reservation;
import com.entities.Spectacle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.yaml.snakeyaml.util.ArrayUtils;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Stream;

@EnableJpaRepositories(basePackages = "com.dao")
@SpringBootApplication
public class SkynetApplication implements CommandLineRunner {
    @Autowired
    private SpectacleRepository specRepos;
    @Autowired
    private ReservationRepository resRepo;
    @Autowired
    private ClientRepository cliRepos;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(SkynetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Spectacle.class);
        int[] nbr = new int[] { 11, 20, 9, 15, 10 };
        int[] index = new int[] { 0, 1, 2, 3 };
        String[] names = new String[]{"Inès Reg","Panayotis Pascot","Jason Brokerss","Benjamin Tranié"};
        Collection<Reservation> reservations = resRepo.findAll();
        Client c = new Client();
        c.setAdresse("123 rue ");
        c.setMail("test@test.com");
        c.setNom("Esseddi");
        c.setPrenom("maher");
        c.setNumero_Telephone("0450501233");
        c.setMdp("test");
        cliRepos.save(c);
        Stream.of("Hors normes ", "Presque", "21ème Seconde", "Le dernier relais").forEach(spName -> {
            Spectacle s = new Spectacle();
            s.setAuteur(names[new Random().nextInt(index.length)]);
            s.setNbrPlace(""+ nbr[new Random().nextInt(nbr.length)]);
            s. setReservations(reservations);
            s.setTitre(spName);
            specRepos.save(s);
        });
        System.out.println("run");
    }
}
