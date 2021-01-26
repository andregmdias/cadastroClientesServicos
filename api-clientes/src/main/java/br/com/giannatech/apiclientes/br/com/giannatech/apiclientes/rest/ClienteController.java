package br.com.giannatech.apiclientes.br.com.giannatech.apiclientes.rest;

import br.com.giannatech.apiclientes.br.com.giannatech.model.repository.ClientesRepository;
import br.com.giannatech.apiclientes.br.com.gianntech.apiclientes.model.entity.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {

    private final ClientesRepository clientesRepository;


    public ClienteController(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @GetMapping("/clientes")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> findAll(){
        return clientesRepository.findAll();
    }

    @GetMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente findById(@PathVariable Integer id)  {
        return clientesRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado") );
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente createCliente(@RequestBody @Valid Cliente cliente){
        return clientesRepository.save(cliente);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
         clientesRepository
                .findById(id)
                .map( cliente -> {
                    clientesRepository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado") );
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateById (@PathVariable Integer id, @RequestBody Cliente clienteAtualizado){
        clientesRepository
                .findById(id)
                .map( cliente -> {
                    clienteAtualizado.setId(cliente.getId());
                    clientesRepository.save(clienteAtualizado);
                    return Void.TYPE;
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "{cliente.nao.encontrado}") );
    }
}
