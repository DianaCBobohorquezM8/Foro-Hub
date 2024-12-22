package com.forohub.foro.controller;

import com.forohub.foro.dominio.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
    @RequestMapping("/topicos")
    public class TopicoController {

        @Autowired
        private TopicoRepository topicoRepository;


        @PostMapping("/registrar")
        public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid  DatosRegistroTopico datosRegistroTopico,
                                                                    UriComponentsBuilder uricComponentsBuilder){
            Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
            DatosRespuestaTopico datosRespuestaTopico = new  DatosRespuestaTopico(
                    topico.getTitulo(),
                    topico.getMensaje(),
                    topico.getFechaCreacion(),
                    topico.getCurso(),
                    topico.getStatus(),
                    topico.getAutor());
            URI url = uricComponentsBuilder.path("/topicos/registrar/{id}").buildAndExpand(topico.getId()).toUri();
            return ResponseEntity.created(url).body(datosRespuestaTopico);
        }

        @GetMapping("/listar")
        public ResponseEntity<Page<DatosListadoTopicos>>  listadoTopicos(@PageableDefault(size = 10) Pageable paginacion){
            return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopicos::new));
        }

        @PutMapping("/actualizar/{id}")
        @Transactional
        public ResponseEntity actualizarTopico(@PathVariable Long id,@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
            Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
            topico.actualizarDatos(datosActualizarTopico);
            return ResponseEntity.ok(new  DatosRespuestaTopico(
                    topico.getTitulo(),
                    topico.getMensaje(),
                    topico.getFechaCreacion(),
                    topico.getCurso(),
                    topico.getStatus(),
                    topico.getAutor()
            ));
        }

        @DeleteMapping("/eliminar/{id}")
        @Transactional
        public ResponseEntity<Long> eliminarTopico(@PathVariable Long id){
            Topico topico = topicoRepository.getReferenceById(id);
            topicoRepository.delete(topico);
            return ResponseEntity.noContent().build();
        }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new  DatosRespuestaTopico(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getCurso(),
                topico.getStatus(),
                topico.getAutor());
        return ResponseEntity.ok(datosTopico);
    }




    }
