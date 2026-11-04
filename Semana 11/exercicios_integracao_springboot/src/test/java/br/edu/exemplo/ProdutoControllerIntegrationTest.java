package br.edu.exemplo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ProdutoControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void deveCadastrarProdutoPelaApi() throws Exception {
        // TODO EX2: POST /produtos com JSON {"nome":"Mouse","preco":80.0}
        // Verificar HTTP 200, ID numérico, nome e preço no JSON de resposta.

        mockMvc.perform(post("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                    {"nome":"Mouse","preco":80.0}
                    """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.nome").value("Mouse"))
                .andExpect(jsonPath("$.preco").value(80.0));

    }

    @Test
    void deveBuscarProdutoPelaApi() throws Exception {
        // TODO EX2: cadastrar por POST, extrair o ID da resposta,
        // executar GET /produtos/{id} e conferir os dados retornados.
        MvcResult resultadoPost = mockMvc.perform(post("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                    {"nome":"Mouse","preco":80.0}
                    """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.nome").value("Mouse"))
                .andExpect(jsonPath("$.preco").value(80.0)).andReturn();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode nodePost = mapper.readTree(resultadoPost.getResponse().getContentAsString());
        Long idPost = nodePost.get("id").asLong();

        mockMvc.perform(get("/produtos/" + idPost))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(idPost))
                .andExpect(jsonPath("$.nome").value("Mouse"))
                .andExpect(jsonPath("$.preco").value(80.0));
    }
}