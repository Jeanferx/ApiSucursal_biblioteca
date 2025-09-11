package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.impl.DaoImplSuc;
import com.example.demo.dao.jpa.Entity.EntitySuc;
import com.example.demo.dao.jpa.Entity.Entityciudad;
import com.example.demo.dao.jpa.Repository.RepositoryCiudad;
import com.example.demo.dao.jpa.Repository.RepositorySuc;
import com.example.demo.model.ModelSuc;

@SpringBootTest
class ApiSucursalApplicationTests {

	@Mock
    private RepositorySuc repositorySuc;

    @Mock
    private RepositoryCiudad repositoryCiudad;

    @InjectMocks
    private DaoImplSuc daoImplSuc; // Clase que vamos a probar

    private Entityciudad ciudad;
    private EntitySuc entitySuc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Datos de prueba
        ciudad = new Entityciudad();
        ciudad.setId(1);
        ciudad.setNombre("Guayaquil");

        entitySuc = new EntitySuc();
        entitySuc.setId("123");
        entitySuc.setName("Sucursal New");
        entitySuc.setTelefono("0999999991");
        entitySuc.setCiudad(ciudad);
    }

    @Test
    void testPostSucursal() {
        // Modelo de entrada
        ModelSuc model = new ModelSuc();
        model.setName("Sucursal New");
        model.setTelefono("0999999991");
        model.setCiudad(1);

        // Mock: cuando se busca ciudad, devolver el objeto
        when(repositoryCiudad.findById(1)).thenReturn(Optional.of(ciudad));

        // Mock: cuando se guarda la sucursal, devolver la entidad con ID
        when(repositorySuc.save(org.mockito.ArgumentMatchers.any(EntitySuc.class)))
                .thenReturn(entitySuc);

        // Llamar al método
        ModelSuc result = daoImplSuc.postSucursal(model);

        // Verificaciones
        assertEquals("123", result.getId());
        assertEquals("Sucursal New", result.getName());
        assertEquals("0999999991", result.getTelefono());
        assertEquals("Guayaquil", result.getCiudadNombre());
    }
    @Test
    void testPostSucursal_CiudadNoExiste() {
        // Modelo de entrada
        ModelSuc model = new ModelSuc();
        model.setName("Sucursal Fantasma");
        model.setTelefono("0999999991");
        model.setCiudad(99); // Ciudad que NO existe

        // Mock: cuando se busca la ciudad, devolver Optional vacío
        when(repositoryCiudad.findById(99)).thenReturn(Optional.empty());

        // Verificar que se lance la excepción
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            daoImplSuc.postSucursal(model);
        });

        // Verificar mensaje de la excepción
        assertEquals("❌ La ciudad con id 99 no existe", exception.getMessage());
    }
    @Test
    void testGetSucursal_Existe() {
        // Mock: cuando se busca la sucursal, devolver la entidad
        when(repositorySuc.findById("123")).thenReturn(Optional.of(entitySuc));

        // Llamar al método
        ModelSuc result = daoImplSuc.getSucursal("123");

        // Verificaciones
        assertEquals("123", result.getId());
        assertEquals("Sucursal Central", result.getName());
        assertEquals("0999999999", result.getTelefono());
        assertEquals("Guayaquil", result.getCiudadNombre());
    }

    @Test
    void testGetSucursal_NoExiste() {
        // Mock: cuando se busca una sucursal que no existe
        when(repositorySuc.findById("999")).thenReturn(Optional.empty());

        // Llamar al método
        ModelSuc result = daoImplSuc.getSucursal("999");

        // Verificar que devuelve un modelo vacío (sin datos)
        assertNull(result.getId());
        assertNull(result.getName());
        assertNull(result.getTelefono());
        assertNull(result.getCiudadNombre());
    }


}
