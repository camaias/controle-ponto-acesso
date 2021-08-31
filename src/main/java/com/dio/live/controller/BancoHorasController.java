package com.dio.live.controller;

        import com.dio.live.model.BancoHoras;
        import com.dio.live.service.BancoService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.NoSuchElementException;

@RestController
@RequestMapping("/banco")
public class BancoHorasController {
    @Autowired
    BancoService bancoService;

    @PostMapping
    public BancoHoras createBanco(@RequestBody BancoHoras bancoHorasId){
        return bancoService.saveBanco(bancoHorasId);
    }

    @GetMapping
    public List<BancoHoras> getBancoList(){
        return bancoService.findAll();

    }

    @GetMapping("/{bancoHorasIdBanco}")
    public ResponseEntity<BancoHoras> getBancoByID(@PathVariable("bancoHorasIdBanco") Long bancoHorasIdBanco) throws Exception {
        return  ResponseEntity.ok(bancoService.getById(bancoHorasIdBanco).orElseThrow(() -> new NoSuchElementException("Not found!")));

    }

    @PutMapping
    public BancoHoras updateBanco(@RequestBody BancoHoras bancoHoras){
        return bancoService.updateBanco(bancoHoras);
    }

    @DeleteMapping("/{bancoHorasIdBanco}")
    public ResponseEntity deleteByID(@PathVariable("bancoHorasIdBanco") Long bancoHorasIdBanco) throws Exception {
        try {
            bancoService.deleteBanco(bancoHorasIdBanco);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<BancoHoras>) ResponseEntity.ok();

    }



}
