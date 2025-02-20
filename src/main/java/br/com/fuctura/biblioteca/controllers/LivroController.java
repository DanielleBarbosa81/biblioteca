package br.com.fuctura.biblioteca.controllers;

import br.com.fuctura.biblioteca.dtos.LivroDto;
import br.com.fuctura.biblioteca.models.Livro;
import br.com.fuctura.biblioteca.services.LivroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<LivroDto> findById(@PathVariable Integer id) {
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(livro, LivroDto.class));

    }

    @GetMapping
    public ResponseEntity<List<LivroDto>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id) {
        List<Livro> list = livroService.findAll(id);
        return ResponseEntity.ok().body(list.stream().map(livro -> modelMapper.map(livro, LivroDto.class)).collect(Collectors.toList()));

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }


}