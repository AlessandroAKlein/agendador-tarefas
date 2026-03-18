package com.javanauta.agendadortarefas.controller;


import com.javanauta.agendadortarefas.business.TarefaService;
import com.javanauta.agendadortarefas.business.dto.TarefaDTO;
import com.javanauta.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefa")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;
    private final JwtUtil jwtUtil;



    @PostMapping
    public ResponseEntity<TarefaDTO> salvaTarefa (@RequestBody TarefaDTO tarefaDTO,
                                                  @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(tarefaService.gravarTarefa(token, tarefaDTO));
    }

}
