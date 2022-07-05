package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.model.Avaliacao;
import br.com.api.feiraqui.service.AvaliacaoService;
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
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    private AvaliacaoService avaliacaoService;
    public AvaliacaoController(AvaliacaoService avaliacaoService){
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Avaliacao>> listaAvaliacaos (){
        return ResponseEntity.status(200).body(avaliacaoService.listarAvaliacao());
    }

    @PostMapping
    public ResponseEntity<Avaliacao> cadastrarAvaliacao (@Valid @RequestBody Avaliacao avaliacao){
        return ResponseEntity.status(201).body(avaliacaoService.criarAvaliacao(avaliacao));
    }

    @PutMapping
    public ResponseEntity<Avaliacao> editarAvaliacao (@Valid @RequestBody Avaliacao avaliacao){
        return ResponseEntity.status(200).body(avaliacaoService.editarAvaliacao(avaliacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirAvaliacao (@PathVariable long id){
        avaliacaoService.excluirAvaliacao(id);
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
