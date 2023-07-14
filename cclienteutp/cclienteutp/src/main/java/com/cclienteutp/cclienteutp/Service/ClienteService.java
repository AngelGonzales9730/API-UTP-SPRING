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
        return clienteRepository.BuscarClienteText(texto); }

    public ResponseDTO InsertarCLiente(Cliente cliente) {
            return clienteRepository.InsertarCLiente(cliente.getNombre(), cliente.getApellido(), cliente.getEmail(), cliente.getTelefono(), cliente.getSaldo());
        }
    public ResponseDTO EliminarCliente(Cliente cliente){
        return clienteRepository.EliminarCliente(cliente.getId_cliente());
    }
    public ResponseDTO ActualizarCliente(Cliente cliente){
        return clienteRepository.ActualizarCliente (
            cliente.getId_cliente(),
            cliente.getNombre(),
            cliente.getApellido(),
            cliente.getEmail(),
            cliente.getTelefono(),
            cliente.getSaldo());

    }
    }

