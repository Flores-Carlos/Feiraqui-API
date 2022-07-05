package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.model.Fregues;
import br.com.api.feiraqui.service.FreguesService;
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
@RequestMapping("/fregues")
public class FreguesController {

    private FreguesService freguesService;
    public FreguesController(FreguesService freguesService){
        this.freguesService = freguesService;
    }

    @GetMapping
    public ResponseEntity<List<Fregues>> listaFreguess (){
        return ResponseEntity.status(200).body(freguesService.listarFregues());
    }

    @PostMapping
    public ResponseEntity<Fregues> cadastrarFregues (@Valid @RequestBody Fregues fregues){
        return ResponseEntity.status(201).body(freguesService.criarFregues(fregues));
    }

    @PutMapping
    public ResponseEntity<Fregues> editarFregues (@Valid @RequestBody Fregues fregues){
        return ResponseEntity.status(200).body(freguesService.editarFregues(fregues));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirFregues (@PathVariable long id){
        freguesService.excluirFregues(id);
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
