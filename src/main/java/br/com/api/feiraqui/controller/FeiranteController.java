package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.model.Feirante;
import br.com.api.feiraqui.service.FeiranteService;
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
@RequestMapping("/feirante")
public class FeiranteController {

    @Autowired
    private FeiranteService feiranteService;
    public FeiranteController(FeiranteService feiranteService){
        this.feiranteService = feiranteService;
    }

    @GetMapping
    public ResponseEntity<List<Feirante>> listaFeirantes (){
        return ResponseEntity.status(200).body(feiranteService.listarFeirante());
    }

    @PostMapping
    public ResponseEntity<Feirante> cadastrarFeirante (@Valid @RequestBody Feirante feirante){
        return ResponseEntity.status(201).body(feiranteService.criarFeirante(feirante));
    }

    @PutMapping
    public ResponseEntity<Feirante> editarFeirante (@Valid @RequestBody Feirante feirante){
        return ResponseEntity.status(200).body(feiranteService.editarFeirante(feirante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirFeirante (@PathVariable long id){
        feiranteService.excluirFeirante(id);
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
