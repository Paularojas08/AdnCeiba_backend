package com.ceiba.pedido.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.pedido.ComandoControladorPedido;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.ComandoSolcitudPedido;
import com.ceiba.pedido.servicio.ComandoPedidoTestDataBuilder;
import com.ceiba.pedido.servicio.ComandoSolicitudPedidoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorPedido.class)
public class ComandoControladorPedidoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoSolcitudPedido solicituPedido = new ComandoSolicitudPedidoTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/pedido")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(solicituPedido)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }
    @Test
    public void actualizar() throws Exception{

        ComandoPedido pedido = new ComandoPedidoTestDataBuilder().build();

        mocMvc.perform(put("/pedido/{id}",1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pedido)))
                .andExpect(status().isOk());
    }
    @Test
    public void eliminar() throws Exception{

        mocMvc.perform(delete("/pedido/{id}",1L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
