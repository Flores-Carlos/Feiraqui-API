package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.model.FeiraBarracas;
import br.com.api.feiraqui.service.FeiraBarracasService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/feira-barracas")
public class FeiraBarracasController {

    @Autowired
    private FeiraBarracasService feiraBarracasService;
    public FeiraBarracasController(FeiraBarracasService feiraBarracasService){
        this.feiraBarracasService = feiraBarracasService;
    }

    @GetMapping
    public ResponseEntity<List<FeiraBarracas>> listaFeiraBarracas (){
        return ResponseEntity.status(200).body(feiraBarracasService.listarFeiraBarracas());
    }

    @PostMapping
    public ResponseEntity<FeiraBarracas> cadastrarFeiraBarracas (@Valid @RequestBody FeiraBarracas feiraBarracas){
        return ResponseEntity.status(201).body(feiraBarracasService.criarFeiraBarracas(feiraBarracas));
    }

    @PutMapping
    public ResponseEntity<FeiraBarracas> editarFeiraBarracas (@Valid @RequestBody FeiraBarracas feiraBarracas){
        return ResponseEntity.status(200).body(feiraBarracasService.editarFeiraBarracas(feiraBarracas));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirFeiraBarracas (@PathVariable long id){
        feiraBarracasService.excluirFeiraBarracas(id);
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
