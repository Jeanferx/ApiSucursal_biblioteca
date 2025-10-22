Microservicio desarrollado en **Spring Boot** para la gestión de **sucursales** dentro del sistema de biblioteca.  
Permite registrar, actualizar, eliminar y consultar la información de las sucursales que pertenecen a la red de bibliotecas.

---

## Tecnologías utilizadas

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **MySQL** (o tu base de datos preferida)
- **Maven**
- **Lombok**
- **Swagger / Springdoc OpenAPI** (para documentación)

---

## Funcionalidades principales

- Registrar una nueva sucursal  
- Listar todas las sucursales  
- Buscar sucursal por ID o nombre  
- Actualizar datos de una sucursal  
- Eliminar sucursal existente  

---
## Endpoints principales

| Método | Endpoint | Descripción |
|--------|-----------|-------------|
| GET | `/api/sucursales` | Lista todas las sucursales |
| GET | `/api/sucursales/{id}` | Busca una sucursal por ID |
| POST | `/api/sucursales` | Registra una nueva sucursal |
| PUT | `/api/sucursales/{id}` | Actualiza datos de una sucursal |
| DELETE | `/api/sucursales/{id}` | Elimina una sucursal |

---

## Ejecución local

1. Clonar el repositorio  
   ```bash
   git clone https://github.com/Jeanferx/ApiSucursal_biblioteca.git
