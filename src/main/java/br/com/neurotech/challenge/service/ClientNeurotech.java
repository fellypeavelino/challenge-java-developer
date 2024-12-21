/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.neurotech.challenge.service;

import br.com.neurotech.challenge.entity.NeurotechClient;
import br.com.neurotech.challenge.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author felly
 */

public class ClientNeurotech implements ClientService{
    
    @Autowired
    private ClientRepository clientRepository;
    
    @Override
    public String save(NeurotechClient client) {
        clientRepository.save(client);
        return client.getId().toString();
    }

    @Override
    public NeurotechClient get(String id) {
        long idCliente = Long.parseLong(id);
        return clientRepository.getReferenceById(idCliente);
    }
    
}
