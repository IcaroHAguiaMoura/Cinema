package com.curso.services;

import com.curso.domains.Cliente;
import com.curso.domains.Filme;
import com.curso.domains.GrupoFilme;
import com.curso.domains.Sessao;
import com.curso.domains.enums.ClassificacaoFilme;
import com.curso.domains.enums.EstadoFilme;
import com.curso.repositories.ClienteRepository;
import com.curso.repositories.FilmeRepository;
import com.curso.repositories.GrupoFilmeRepository;
import com.curso.repositories.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DBService {

    @Autowired
    private GrupoFilmeRepository grupoFilmeRepo;

    @Autowired
    private FilmeRepository filmeRepo;

    @Autowired
    private SessaoRepository sessaoRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    public void initDB(){

        //Grupo de filmes
        GrupoFilme grupo01 = new GrupoFilme(null,"Ação");
        GrupoFilme grupo02 = new GrupoFilme(null,"Terror");
        GrupoFilme grupo03 = new GrupoFilme(null,"Comédia");

        grupoFilmeRepo.save(grupo01);
        grupoFilmeRepo.save(grupo02);
        grupoFilmeRepo.save(grupo03);

        Filme filme1 = new Filme(null,"Vingadores: Ultimato", "Ação", 181, EstadoFilme.EM_ANDAMENTO, ClassificacaoFilme.DOZE_ANOS, grupo01);
        Filme filme2 = new Filme(null,"Terrifier 3", "Terror", 125, EstadoFilme.FINALIZADO, ClassificacaoFilme.DEZOITO_ANOS, grupo02);
        Filme filme3 = new Filme(null,"Vizinhança Do Barulho", "Comédia", 88, EstadoFilme.PAUSADO, ClassificacaoFilme.DEZOITO_ANOS, grupo03);

        //Filmes
        filmeRepo.save(filme1);
        filmeRepo.save(filme2);
        filmeRepo.save(filme3);

        filmeRepo.flush();



        //Sessões
        Sessao sessao1 = new Sessao(null,LocalDateTime.of(2024, 12, 1, 18, 30), 1, filme1);
        Sessao sessao2 = new Sessao(null,LocalDateTime.of(2024, 12, 2, 20, 00), 2, filme2);
        Sessao sessao3 = new Sessao(null,LocalDateTime.of(2024, 12, 3, 15, 00), 3, filme3);

        sessaoRepo.save(sessao1);
        sessaoRepo.save(sessao2);
        sessaoRepo.save(sessao3);

        sessaoRepo.flush();




        //Clientes

        Cliente cliente1 = new Cliente(null, "Matheus Mendes", "12345678901", "Matheus@gmail.com", "Rua 1, Nº 10", 30, "17996288606");
        Cliente cliente2 = new Cliente(null, "Icaro H. Aguia Moura", "09876543210", "icaro@gmail.com", "Rua 2, Nº 20", 25, "17988301108");
        Cliente cliente3 = new Cliente(null, "Mateus Duran", "11223344556", "duran@gmail.com", "Rua 3, Nº 30", 40, "17996672507");

        clienteRepo.save(cliente1);
        clienteRepo.save(cliente2);
        clienteRepo.save(cliente3);


    }
}
