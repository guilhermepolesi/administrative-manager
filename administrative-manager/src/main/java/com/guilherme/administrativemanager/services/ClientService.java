package com.guilherme.administrativemanager.services;

import com.guilherme.administrativemanager.entities.Client;
import com.guilherme.administrativemanager.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client insert(Client obj) {
        return clientRepository.save(obj);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        Optional<Client> obj = clientRepository.findById(id);
        return obj.get();
    }

    public Client update(Long id, Client obj) {
        Client entity = clientRepository.getReferenceById(id);
        updateData(entity, obj);
        return clientRepository.save(entity);
    }

    private void updateData(Client entity, Client obj) {
        entity.setEinSsn(obj.getEinSsn());
        entity.setName(obj.getName());
        entity.setAddress(obj.getAddress());
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
    
}
