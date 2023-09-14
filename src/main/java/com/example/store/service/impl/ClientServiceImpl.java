package com.example.store.service.impl;

import com.example.store.dtos.ClientDTO;
import com.example.store.dtos.ProductDTO;
import com.example.store.models.Category;
import com.example.store.models.Client;
import com.example.store.models.Product;
import com.example.store.repositories.CategoryRepository;
import com.example.store.repositories.ClientRepository;
import com.example.store.repositories.ProductRepository;
import com.example.store.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService<Integer> {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = modelMapper.map(clientDTO, Client.class);
        client = clientRepository.save(client);
        return modelMapper.map(client, ClientDTO.class);
    }
    @Override
    public Optional<ClientDTO> findClient(Long id) {
        return Optional.ofNullable(modelMapper.map(clientRepository.findById(id), ClientDTO.class));
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(client -> modelMapper.map(client, ClientDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO updateClient(Long clientID,ClientDTO clientDTO){
        Optional<Client> optionalClient = clientRepository.findById(clientID);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            modelMapper.map(clientDTO, client);
            return modelMapper.map(clientRepository.save(client), ClientDTO.class);
        }
        return null;
    }


    @Override
    public void delete(Long clientID) {
        clientRepository.deleteById(clientID);
    }

}
