package com.poke.pokeapi.data;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokeApiClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://pokeapi.co/api/v2/";

    public String getPokemonList(int limit, int offset) {
        String url = BASE_URL + "pokemon?limit=" + limit + "&offset=" + offset;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

    /**
     * Busca *todos* os pokemons de uma vez, usando um limit grande.
     * Atenção: se no futuro a PokéAPI aumentar muito, talvez seja necessário iterar paginas.
     */
    public String getAllPokemonNames() {
        // Limit alto para pegar todos (por volta de 1200 pokemons atualmente)
        String url = BASE_URL + "pokemon?limit=2000&offset=0";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

    public String getPokemonByName(String name) {
        String url = BASE_URL + "pokemon/" + name;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
}
