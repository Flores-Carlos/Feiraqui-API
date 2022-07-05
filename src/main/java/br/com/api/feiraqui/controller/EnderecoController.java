package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.model.Endereco;
import br.com.api.feiraqui.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/endereco")
public class EnderecoController {

    private EnderecoService enderecoService;
    public EnderecoController(EnderecoService enderecoService){
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listaEnderecos (){
        return ResponseEntity.status(200).body(enderecoService.listarEndereco());
    }

    @PostMapping
    public ResponseEntity<Endereco> cadastrarEndereco (@Valid @RequestBody Endereco endereco){
        return ResponseEntity.status(201).body(enderecoService.criarEndereco(endereco));
    }

    @PutMapping
    public ResponseEntity<Endereco> editarEndereco (@Valid @RequestBody Endereco endereco){
        return ResponseEntity.status(200).body(enderecoService.editarEndereco(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirEndereco (@PathVariable long id){
        enderecoService.excluirEndereco(id);
        return ResponseEntity.status(204).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
