package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.model.Mercadoria;
import br.com.api.feiraqui.service.MercadoriaService;
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
@RequestMapping("/mercadoria")
public class MercadoriaController {

    private MercadoriaService mercadoriaService;
    public MercadoriaController(MercadoriaService mercadoriaService){
        this.mercadoriaService = mercadoriaService;
    }

    @GetMapping
    public ResponseEntity<List<Mercadoria>> listaMercadorias (){
        return ResponseEntity.status(200).body(mercadoriaService.listarMercadoria());
    }

    @PostMapping
    public ResponseEntity<Mercadoria> cadastrarMercadoria (@Valid @RequestBody Mercadoria mercadoria){
        return ResponseEntity.status(201).body(mercadoriaService.criarMercadoria(mercadoria));
    }

    @PutMapping
    public ResponseEntity<Mercadoria> editarMercadoria (@Valid @RequestBody Mercadoria mercadoria){
        return ResponseEntity.status(200).body(mercadoriaService.editarMercadoria(mercadoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirMercadoria (@PathVariable long id){
        mercadoriaService.excluirMercadoria(id);
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
