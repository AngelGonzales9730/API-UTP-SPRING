package com.cclienteutp.cclienteutp.Service;


import com.cclienteutp.cclienteutp.DTO.responseDTO;
import com.cclienteutp.cclienteutp.Entity.Cliente;
import com.cclienteutp.cclienteutp.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> ListarCliente(){

        return clienteRepository.ListarCliente();
    }

    public List<Cliente> BuscarClienteTXT(String texto){

        return clienteRepository.BuscarClienteTXT(texto);

    }
    public responseDTO InsertarCliente(Cliente cliente){
        return clienteRepository.InsertarCliente(cliente.getNombre(),cliente.getApellido(),cliente.getEmail(),cliente.getTelefono(),cliente.getSaldo());
    }

    public responseDTO EliminarCliente(String idcliente) {
        return clienteRepository.EliminarCliente(idcliente);
    }
}
