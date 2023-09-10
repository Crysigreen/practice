package com.example.store.service;

import com.example.store.dtos.ClientDTO;

import java.util.List;
import java.util.Optional;

public interface ClientService<ID> {

    List<ClientDTO> getAllClients();
    ClientDTO createClient(ClientDTO clientDTO);

    Optional<ClientDTO> findClient (Long id);

    ClientDTO updateClient (Long clientID, ClientDTO clientDTO);

    void delete(Long clientID);
}
