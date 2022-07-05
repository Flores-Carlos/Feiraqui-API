package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.model.Telefone;
import br.com.api.feiraqui.service.TelefoneService;
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
@RequestMapping("/telefone")
public class TelefoneController {

    private TelefoneService telefoneService;
    public TelefoneController(TelefoneService telefoneService){
        this.telefoneService = telefoneService;
    }

    @GetMapping
    public ResponseEntity<List<Telefone>> listaTelefones (){
        return ResponseEntity.status(200).body(telefoneService.listarTelefone());
    }

    @PostMapping
    public ResponseEntity<Telefone> cadastrarTelefone (@Valid @RequestBody Telefone telefone){
        return ResponseEntity.status(201).body(telefoneService.criarTelefone(telefone));
    }

    @PutMapping
    public ResponseEntity<Telefone> editarTelefone (@Valid @RequestBody Telefone telefone){
        return ResponseEntity.status(200).body(telefoneService.editarTelefone(telefone));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirTelefone (@PathVariable long id){
        telefoneService.excluirTelefone(id);
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
