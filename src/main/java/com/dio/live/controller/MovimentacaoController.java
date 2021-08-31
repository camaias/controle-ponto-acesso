package com.dio.live.controller;

        import com.dio.live.model.BancoHoras;
        import com.dio.live.model.Movimentacao;
        import com.dio.live.service.BancoService;
        import com.dio.live.service.MovimentacaoService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping
    public Movimentacao createMovimentacao(@RequestBody Movimentacao movimentacaoId){
        return movimentacaoService.saveMovimentacao(movimentacaoId);
    }

    @GetMapping
    public List<Movimentacao> getBancoList(){
        return movimentacaoService.findAll();

    }

    @GetMapping("/{movimentacaoIdMovimentacao}")
    public ResponseEntity<Movimentacao> getBancoByID(@PathVariable("movimentacaoIdMovimentacao") Long movimentacaoIdMovimentacao) throws Exception {
        return  ResponseEntity.ok(movimentacaoService.getById(movimentacaoIdMovimentacao).orElseThrow(() -> new NoSuchElementException("Not found!")));

    }

    @PutMapping
    public Movimentacao updateMovimentacao(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.updateMovimentacao(movimentacao);
    }

    @DeleteMapping("/{movimentacaoIdMovimentacao}")
    public ResponseEntity deleteByID(@PathVariable("movimentacaoIdMovimentacao") Long movimentacaoIdMovimentacao) throws Exception {
        try {
            movimentacaoService.deleteMovimentacao(movimentacaoIdMovimentacao);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Movimentacao>) ResponseEntity.ok();

    }



}

