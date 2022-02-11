# API REST CALCULADORA
Aplicación API Restful desarrollada con SpringBoot y java. Expone dos endpoint para realizar varias operaciones(sumar y restar).

### Pre-Requisitos 📋
```
- Java mínimo 1.8
- Maven 
```

# Instalación 🔧
```
git clone https://github.com/...
cd calculator
mvn clean install
```

# Librerías 📖
* Spring Boot 2.6.3
* Spring Boot Starter Web
* Spring Boot Starter Test
* Mockito 1.10.19

# Desarrollo 🛠
* Desarrollo de distintos endpoints, en este caso hay 2 endpoint que realizan distintas operaciones sumar y restar.
* Ambos endpoint devuelven un objeto(dto) con un 'result'.
* Declaracion e implementacion de la interfaz IOperacionService.
* Desarrollo de posibles excepciones, tanto en la capa de implementación como en la capa controladora.

