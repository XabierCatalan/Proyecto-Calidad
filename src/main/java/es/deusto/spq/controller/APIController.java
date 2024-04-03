package es.deusto.spq.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class APIController {
    private JuegoService juegoService;

    @GetMapping("/crearjuego")
    public void crearJuego() {
        juegoService.crearJuego();
    }
    
    
}
