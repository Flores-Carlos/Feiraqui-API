package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.model.Entregador;
import br.com.api.feiraqui.service.EntregadorService;
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
@RequestMapping("/entregador")
public class EntregadorController {

    private EntregadorService entregadorService;
    public EntregadorController(EntregadorService entregadorService){
        this.entregadorService = entregadorService;
    }

    @GetMapping
    public ResponseEntity<List<Entregador>> listaEntregadors (){
        return ResponseEntity.status(200).body(entregadorService.listarEntregador());
    }

    @PostMapping
    public ResponseEntity<Entregador> cadastrarEntregador (@Valid @RequestBody Entregador entregador){
        return ResponseEntity.status(201).body(entregadorService.criarEntregador(entregador));
    }

    @PutMapping
    public ResponseEntity<Entregador> editarEntregador (@Valid @RequestBody Entregador entregador){
        return ResponseEntity.status(200).body(entregadorService.editarEntregador(entregador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirEntregador (@PathVariable long id){
        entregadorService.excluirEntregador(id);
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
