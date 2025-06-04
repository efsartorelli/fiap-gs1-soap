package com.poke.pokeapi.controller;

import com.poke.pokeapi.model.PokemonDto;
import com.poke.pokeapi.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    /**
     * Se receber 'search', retorna lista filtrada (com ou sem wildcard).
     * Caso contrário, retorna lista paginada.
     */
    @GetMapping("/pokemons")
    public List<String> getPokemons(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "20") int limit,
            @RequestParam(defaultValue = "0") int offset) throws Exception {

        if (search != null && !search.trim().isEmpty()) {
            return pokemonService.searchPokemons(search);
        } else {
            return pokemonService.listarPokemons(limit, offset);
        }
    }

    @GetMapping("/pokemon/{nome}")
    public PokemonDto getPokemonDetalhado(@PathVariable String nome) throws Exception {
        return pokemonService.buscarPokemonDetalhado(nome);
    }
}
