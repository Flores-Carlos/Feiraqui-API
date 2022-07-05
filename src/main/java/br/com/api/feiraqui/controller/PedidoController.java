package br.com.api.feiraqui.controller;

import br.com.api.feiraqui.model.Pedido;
import br.com.api.feiraqui.service.PedidoService;
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
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoService pedidoService;
    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listaPedidos (){
        return ResponseEntity.status(200).body(pedidoService.listarPedido());
    }

    @PostMapping
    public ResponseEntity<Pedido> cadastrarPedido (@Valid @RequestBody Pedido pedido){
        return ResponseEntity.status(201).body(pedidoService.criarPedido(pedido));
    }

    @PutMapping
    public ResponseEntity<Pedido> editarPedido (@Valid @RequestBody Pedido pedido){
        return ResponseEntity.status(200).body(pedidoService.editarPedido(pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirPedido (@PathVariable long id){
        pedidoService.excluirPedido(id);
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
