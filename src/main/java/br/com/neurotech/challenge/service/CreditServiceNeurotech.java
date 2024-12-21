/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.neurotech.challenge.service;

import br.com.neurotech.challenge.entity.NeurotechClient;
import br.com.neurotech.challenge.entity.VehicleModel;
import br.com.neurotech.challenge.repository.ClientRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author felly
 */
public class CreditServiceNeurotech implements CreditService{

    @Autowired
    private ClientNeurotech clientNeurotech;
    
    @Autowired
    private ClientRepository clientRepository;
    
    @Override
    public boolean checkCredit(String clientId, VehicleModel model) {
        NeurotechClient cliente = clientNeurotech.get(clientId);
        if(model == model.HATCH){
            return this.isAptoParaHatch(cliente);
        }
        if(model == model.SUV){
            return this.isAptoParaSUV(cliente);
        }
        return false;
    }
    
    private boolean isAptoParaHatch(NeurotechClient cliente) {
        return cliente.getIncome()>= 5000 && cliente.getIncome() <= 15000;
    }

    private boolean isAptoParaSUV(NeurotechClient cliente) {
        return cliente.getAge()> 20 && cliente.getIncome() > 8000;
    }
    
    public List<NeurotechClient> findClientesCreditoFixoHatch(){
        return clientRepository.findAll().stream()
                .filter(cliente -> cliente.getAge()>= 23 && cliente.getAge()<= 49 && isAptoParaHatch(cliente))
                .toList();
    }
}
