package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.conta.ContaBancaria;
import com.example.demo.conta.ContaBancariaRepository;
import com.example.demo.conta.ContaBancariaRequestDTO;
import com.example.demo.conta.ContaBancariaResponseDTO;

public class ContaBancariaController {
    @Autowired
    private ContaBancariaRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveContaBancaria(@RequestBody ContaBancariaRequestDTO data) {
        ContaBancaria contaData = new ContaBancaria(data);
        repository.save(contaData);
        return;
    }

    @GetMapping
    public List<ContaBancariaResponseDTO> getAll() {
        List<ContaBancariaResponseDTO> conta = repository.findAll().stream()
                .map(ContaBancariaResponseDTO::new).toList();
        return conta;
    }
}
