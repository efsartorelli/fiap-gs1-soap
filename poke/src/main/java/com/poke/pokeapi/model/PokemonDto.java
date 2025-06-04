package com.poke.pokeapi.model;

import java.util.List;

/**
 * DTO imutável para transportar dados do Pokémon.
 */
public record PokemonDto(
        String nome,
        int altura,
        int peso,
        List<String> habilidades,
        List<String> tipos
) {}
