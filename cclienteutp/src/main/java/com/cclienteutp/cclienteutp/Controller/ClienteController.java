package com.cclienteutp.cclienteutp.Controller;

import com.cclienteutp.cclienteutp.DTO.ResponseDTO;
import com.cclienteutp.cclienteutp.Entity.Cliente;
import com.cclienteutp.cclienteutp.Service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    public String saludo(){
        return "Hola desde api Intellij";
    }

    @GetMapping("/ListarCliente")
    public ResponseEntity<List<Cliente>> ListarCliente(){
        List<Cliente> lista = clienteService.ListarCliente();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    
    @PostMapping("/BuscarClienteText")
    public ResponseEntity<List<Cliente>> BuscarClienteText(@RequestParam("texto")String texto){
        return new ResponseEntity<>(clienteService.BuscarClienteText(texto), HttpStatus.OK);
    }

    @PostMapping("/BuscarClienteId")
    public ResponseEntity<List<Cliente>> BuscarClienteId(Integer id){
        List<Cliente> lista = clienteService.BuscarClienteId(id);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping ("/InsertarCliente")
    public ResponseDTO InseratCliente(@RequestBody Cliente cliente){
        return clienteService.InsertarCliente(cliente);
    }

    @PostMapping ("/EliminarCliente")
    public ResponseDTO EliminarCliente(@RequestParam("id_cliente") int id_cliente){
        return clienteService.EliminarCliente(id_cliente);
    }

}
