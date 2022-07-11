package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.model.Barraca;
import br.com.api.feiraqui.service.BarracaService;
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
@RequestMapping("/barraca")
public class BarracaController {

    @Autowired
    private BarracaService barracaService;
    public BarracaController(BarracaService barracaService){
        this.barracaService = barracaService;
    }

    @GetMapping
    public ResponseEntity<List<Barraca>> listaBarracas (){
        return ResponseEntity.status(200).body(barracaService.listarBarraca());
    }

    @PostMapping
    public ResponseEntity<Barraca> cadastrarBarraca (@Valid @RequestBody Barraca barraca){
        return ResponseEntity.status(201).body(barracaService.criarBarraca(barraca));
    }

    @PutMapping
    public ResponseEntity<Barraca> editarBarraca (@Valid @RequestBody Barraca barraca){
        return ResponseEntity.status(200).body(barracaService.editarBarraca(barraca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirBarraca (@PathVariable long id){
        barracaService.excluirBarraca(id);
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
