package com.javanauta.agendadortarefas.controller;


import com.javanauta.agendadortarefas.business.TarefaService;
import com.javanauta.agendadortarefas.business.dto.TarefaDTO;
import com.javanauta.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.javanauta.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefa")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;
    private final JwtUtil jwtUtil;


    @PostMapping
    public ResponseEntity<TarefaDTO> salvaTarefa(@RequestBody TarefaDTO tarefaDTO,
                                                 @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefaService.gravarTarefa(token, tarefaDTO));
    }

    @GetMapping("/eventos")
    public ResponseEntity<List<TarefaDTO>> buscaListadeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal
    ) {
        return ResponseEntity.ok(tarefaService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal));
    }

    @GetMapping("/user")
    public ResponseEntity<List<TarefaDTO>> buscarPorEmail(
            @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefaService.buscarporUser(token));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarPorId(@RequestParam("id") String id) {
        tarefaService.excluirPorId(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<TarefaDTO> alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                                             @RequestParam("id") String id) {
        return ResponseEntity.ok(tarefaService.alteraStatus(status, id));
    }

    @PutMapping
    public ResponseEntity<TarefaDTO> editarTarefa(@RequestBody TarefaDTO dto,
                                                  @RequestParam("id") String id){
        return ResponseEntity.ok(tarefaService.updateTarefas(dto,id));
    }



}
