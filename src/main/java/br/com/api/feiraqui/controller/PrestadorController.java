package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.model.Prestador;
import br.com.api.feiraqui.service.PrestadorService;
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
@RequestMapping("/prestador")
public class PrestadorController {

    @Autowired
    private PrestadorService prestadorService;
    public PrestadorController(PrestadorService prestadorService){
        this.prestadorService = prestadorService;
    }

    @GetMapping
    public ResponseEntity<List<Prestador>> listaPrestadores (){
        return ResponseEntity.status(200).body(prestadorService.listarPrestador());
    }

    @PostMapping
    public ResponseEntity<Prestador> cadastrarPrestador (@Valid @RequestBody Prestador prestador){
        return ResponseEntity.status(201).body(prestadorService.criarPrestador(prestador));
    }

    @PutMapping
    public ResponseEntity<Prestador> editarPrestador (@Valid @RequestBody Prestador prestador){
        return ResponseEntity.status(200).body(prestadorService.editarPrestador(prestador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirPrestador (@PathVariable long id){
        prestadorService.excluirPrestador(id);
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
