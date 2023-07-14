package com.cclienteutp.cclienteutp.Controller;

import com.cclienteutp.cclienteutp.DTO.responseDTO;
import com.cclienteutp.cclienteutp.Entity.Cliente;
import com.cclienteutp.cclienteutp.Service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/APIUTP")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/Saludo")
    public String Saludo(){

        return "Hola desde mi API";

    }
    @GetMapping("/ListarClientes")
    public ResponseEntity<List<Cliente>> ListarClientes(){
        List<Cliente> lista = clienteService.ListarCliente();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/BuscarClienteTXT")
    public ResponseEntity<List<Cliente>> BuscarClienteTXT(@RequestParam("texto") String texto){
        return new ResponseEntity<>(clienteService.BuscarClienteTXT(texto), HttpStatus.OK);
    }
    @PostMapping("/InsertarCliente")
    public responseDTO InsertarCliente(@RequestBody Cliente cliente){
        return clienteService.InsertarCliente(cliente);
    }
    @PostMapping("/EliminarCliente")
    public responseDTO EliminarCliente(@RequestBody Cliente cliente){
        return clienteService.EliminarCliente(cliente);
    }
    @PostMapping("/BuscarCliente")
    public ResponseEntity<List<Cliente>> BuscarCliente(@RequestParam ("id") Integer id){
        return new ResponseEntity<>(clienteService.BuscarCliente(id), HttpStatus.OK);
    }
    @PostMapping("/ActualizarCliente")
    public responseDTO ActualizarCliente(@RequestBody Cliente cliente){
        return clienteService.ActualizarCliente(cliente);
    }
}
