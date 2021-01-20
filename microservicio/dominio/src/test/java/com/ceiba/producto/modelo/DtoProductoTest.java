package com.ceiba.producto.modelo;

import com.ceiba.producto.modelo.dto.DtoProducto;
import org.junit.Assert;
import org.junit.Test;

public class DtoProductoTest {
    @Test
    public void validacionConstruccionDtoProductoTest(){
        DtoProducto dtoProducto=new DtoProducto(1L,"56","cepillo",124222.0);
        Assert.assertEquals("56",dtoProducto.getCodigo());
    }
}
