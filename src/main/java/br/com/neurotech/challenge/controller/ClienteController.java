/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.neurotech.challenge.controller;

import br.com.neurotech.challenge.entity.NeurotechClient;
import br.com.neurotech.challenge.service.ClientNeurotech;
import br.com.neurotech.challenge.service.ClientService;
import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author felly
 */
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    @Autowired
    private ClientNeurotech clienteService;

    @PostMapping
    public ResponseEntity<Void> createCliente(@Valid @RequestBody NeurotechClient cliente) {
        String id = clienteService.save(cliente);
        return ResponseEntity.created(URI.create("/api/clientes/" + id)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NeurotechClient> getClienteById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.get(id.toString()));
    }

    /*@GetMapping("/apto/hatch/{id}")
    public ResponseEntity<Boolean> checkHatchEligibility(@PathVariable Long id) {
        NeurotechClient cliente = clienteService.getReferenceById(id);
        return ResponseEntity.ok(clienteService.isAptoParaHatch(cliente));
    }

    @GetMapping("/apto/suv/{id}")
    public ResponseEntity<Boolean> checkSuvEligibility(@PathVariable Long id) {
        NeurotechClient cliente = clienteService.getReferenceById(id);
        return ResponseEntity.ok(clienteService.isAptoParaSUV(cliente));
    }

    @GetMapping("/fixo-hatch")
    public ResponseEntity<List<NeurotechClient>> getClientesCreditoFixoHatch() {
        return ResponseEntity.ok(clienteService.findClientesCreditoFixoHatch());
    }*/
}
