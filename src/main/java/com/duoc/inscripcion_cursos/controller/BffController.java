package com.duoc.inscripcion_cursos.controller;

import com.duoc.inscripcion_cursos.dto.BffInicioResponse;
import com.duoc.inscripcion_cursos.service.BffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bff")
public class BffController {

    private final BffService bffService;

    public BffController(BffService bffService) {
        this.bffService = bffService;
    }

    @GetMapping("/inicio")
    public ResponseEntity<BffInicioResponse> obtenerInicio() {
        return ResponseEntity.ok(
                bffService.obtenerInformacionInicio()
        );
    }
}