package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.model.Conta;
import br.com.api.feiraqui.service.ContaService;
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
@RequestMapping("/conta")
public class ContaController {

    private ContaService contaService;
    public ContaController(ContaService contaService){
        this.contaService = contaService;
    }

    @GetMapping
    public ResponseEntity<List<Conta>> listaContas (){
        return ResponseEntity.status(200).body(contaService.listarConta());
    }

    @PostMapping
    public ResponseEntity<Conta> cadastrarConta (@Valid @RequestBody Conta conta){
        return ResponseEntity.status(201).body(contaService.criarConta(conta));
    }

    @PutMapping
    public ResponseEntity<Conta> editarConta (@Valid @RequestBody Conta conta){
        return ResponseEntity.status(200).body(contaService.editarConta(conta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirConta (@PathVariable long id){
        contaService.excluirConta(id);
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
