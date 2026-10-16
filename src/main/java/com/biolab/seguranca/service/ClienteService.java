package com.biolab.seguranca.service;

import com.biolab.seguranca.dto.ClienteDTO;
import com.biolab.seguranca.entities.Cliente;
import com.biolab.seguranca.entities.Role;
import com.biolab.seguranca.repository.ClienteRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final PasswordEncoder passwordEncoder;
    private final ClienteRepository clienteRepository;

    public ClienteService(PasswordEncoder passwordEncoder, ClienteRepository clienteRepository) {
        this.passwordEncoder = passwordEncoder;
        this.clienteRepository = clienteRepository;
    }

    public Cliente criarCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setSenha(passwordEncoder.encode(dto.getSenha()));
        cliente.setEmail(dto.getEmail());
        if (dto.getRole() == null) {
            cliente.setRole(Role.ROLE_USER);
        } else {
            cliente.setRole(dto.getRole());

        }
        return cliente;
    }
}