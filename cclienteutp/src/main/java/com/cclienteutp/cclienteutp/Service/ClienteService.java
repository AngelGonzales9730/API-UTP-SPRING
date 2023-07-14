package com.cclienteutp.cclienteutp.Service;

import com.cclienteutp.cclienteutp.DTO.ResponseDTO;
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

    public List<Cliente> BuscarClienteText(String texto){
        return clienteRepository.BuscarClienteText(texto);
    }

    public List<Cliente> BuscarClienteId(Integer id){
        return clienteRepository.BuscarClienteId(id);
    }

    public ResponseDTO InsertarCliente(Cliente cliente){
        return clienteRepository.InsertarCliente(cliente.getNombre(),cliente.getApellido(), cliente.getEmail(), cliente.getTelefono(), cliente.getSaldo());
    }



    public ResponseDTO ActializarCliente(Cliente cliente){
        return clienteRepository.AcualizarCliente(
        cliente.getId_cliente(),
        cliente.getNombre(),
        cliente.getApellido(),
        cliente.getEmail(),
        cliente.getTelefono(),
        cliente.getSaldo());
    }


}
