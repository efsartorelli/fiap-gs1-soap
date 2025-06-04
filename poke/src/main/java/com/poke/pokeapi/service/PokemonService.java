package com.poke.pokeapi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poke.pokeapi.data.PokeApiClient;
import com.poke.pokeapi.model.PokemonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PokemonService {

    @Autowired
    private PokeApiClient pokeApiClient;

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Lista nomes de Pokémons paginados.
     */
    public List<String> listarPokemons(int limit, int offset) throws Exception {
        String json = pokeApiClient.getPokemonList(limit, offset);
        JsonNode root = objectMapper.readTree(json);
        JsonNode results = root.path("results");
        return StreamSupport.stream(results.spliterator(), false)
                .map(p -> p.get("name").asText())
                .collect(Collectors.toList());
    }

    /**
     * Pesquisa nomes de Pokémons com ou sem wildcard (*).
     *
     * - Se o searchTerm começa com '*', faz CONTAINS (qualquer parte do nome).
     * - Caso contrário, faz STARTSWITH (prefixo).
     */
    public List<String> searchPokemons(String searchTerm) throws Exception {
        String json = pokeApiClient.getAllPokemonNames();
        JsonNode root = objectMapper.readTree(json);
        JsonNode results = root.path("results");

        String lower = searchTerm.toLowerCase(Locale.ROOT).trim();
        boolean isWildcard = lower.startsWith("*");
        String pattern = isWildcard ? lower.substring(1) : lower;

        return StreamSupport.stream(results.spliterator(), false)
                .map(p -> p.get("name").asText())
                .filter(name -> {
                    String nameLower = name.toLowerCase(Locale.ROOT);
                    if (isWildcard) {
                        // contém pattern em qualquer posição
                        return nameLower.contains(pattern);
                    } else {
                        // começa com pattern
                        return nameLower.startsWith(pattern);
                    }
                })
                .collect(Collectors.toList());
    }

    /**
     * Retorna detalhes de um Pokémon específico.
     */
    public PokemonDto buscarPokemonDetalhado(String nome) throws Exception {
        String json = pokeApiClient.getPokemonByName(nome);
        JsonNode root = objectMapper.readTree(json);

        List<String> habilidades = StreamSupport.stream(root.path("abilities").spliterator(), false)
                .map(abilityNode -> abilityNode.path("ability").path("name").asText())
                .collect(Collectors.toList());

        List<String> tipos = StreamSupport.stream(root.path("types").spliterator(), false)
                .map(typeNode -> typeNode.path("type").path("name").asText())
                .collect(Collectors.toList());

        return new PokemonDto(
                root.path("name").asText(),
                root.path("height").asInt(),
                root.path("weight").asInt(),
                habilidades,
                tipos
        );
    }
}
