## **Spring vs Spring Boot — IoC Container y Spring Initializr**

---

Comprender las diferencias entre **Spring** y **Spring Boot**, los beneficios de usar Spring Boot para acelerar el desarrollo, y los fundamentos de la **Inversión de Control (IoC)** junto con el uso del **Spring Initializr** para crear nuevos proyectos.

---

### **Conceptos Clave**

* **Spring Framework**
* **Spring Boot**
* **Spring MVC / Spring Data / Spring Security**
* **Inversión de Control (IoC)**
* **Dependency Injection (DI)**
* **Spring Initializr**

---

### **Explicación**

**Spring** es un framework completo para construir aplicaciones Java de todo tipo. Ofrece múltiples módulos (Web, Data, Security, etc.), pero requiere **configuración manual extensa**.

**Spring Boot**, en cambio, es una versión simplificada y *opinionated* de Spring: incluye configuraciones predeterminadas y dependencias comunes para empezar rápidamente. Además, incluye un **servidor web embebido**, eliminando la necesidad de configurar uno externo.

En resumen:

* **Spring:** es muy flexible, pero complejo de configurar.
* **Spring Boot:** simplifica y acelera el desarrollo gracias a su configuración automática y herramientas integradas.

---

### ⚙️ **Flujo o funcionamiento (IoC y configuración)**

1. **Inversión de Control (IoC):** el framework controla la creación y gestión de objetos, no el desarrollador.
2. **Dependency Injection (DI):** es la técnica más común para implementar IoC — las dependencias se “inyectan” en tiempo de ejecución.
3. **Configuración externa:** Spring Boot permite definir configuraciones (por ejemplo, distintos tipos de bases de datos) sin modificar el código fuente.
4. **Spring Initializr:** es el punto de partida para cualquier proyecto. Permite seleccionar dependencias, añadir metadatos y generar una aplicación lista para ejecutar.

---

### **Anotaciones / tecnologías clave**

* `@SpringBootApplication` → punto de entrada principal
* `@Autowired` → inyección de dependencias
* `application.properties` → configuración externa
* **Spring Initializr ([https://start.spring.io/](https://start.spring.io/))** → generador de proyectos

---

### **Errores comunes / Buenas prácticas**

* ❌ **Error común:** confundir Spring Boot con un framework diferente; es una extensión simplificada de Spring.
* ✅ **Buena práctica:** usar configuración externa en lugar de hardcodear parámetros (por ejemplo, credenciales o URLs).
* ✅ **Recomendación:** comprender el flujo de IoC antes de avanzar con componentes más avanzados (como servicios o repositorios).

---

### **Ejemplo práctico (del curso)**

Usar **Spring Initializr** para crear un proyecto *Family Cash Card* con las dependencias:

* **Spring Web** → controladores REST
* **Spring Data JPA** → acceso a base de datos
* **Spring Security** → autenticación y autorización

Luego ejecutar la app directamente con el servidor embebido de Spring Boot.

---

### **Qué se aprendió / Conclusión**

Spring Boot simplifica la creación de aplicaciones basadas en Spring al automatizar la configuración y gestión de dependencias. Gracias al **IoC Container** y **Spring Initializr**, los desarrolladores pueden enfocarse en la lógica del negocio en lugar de la infraestructura.

---

### **Palabras clave**

> Spring · Spring Boot · IoC · Dependency Injection · Configuración externa · Initializr · Servidor embebido

*Important documentation: ([info IoC container](https://docs.spring.io/spring-framework/reference/core/beans.html))*

---

---

## **API Contracts & JSON**


### **Objetivo del tema**

Comprender qué son los **contratos de API**, por qué son esenciales para definir la comunicación entre servicios, y cómo **JSON** se usa como formato estándar para el intercambio de datos entre proveedor y consumidor.

---

### **Conceptos Clave**

* **API Contract (Contrato de API)**
* **Consumer Driven Contracts / Provider Driven Contracts**
* **Request / Response (URI, Verbos HTTP, Status Codes)**
* **JSON (JavaScript Object Notation)**
* **Serialización / Deserialización**

---

### **Explicación resumida**

Cuando desarrollamos una **API**, debemos definir con claridad cómo interactúan el <br>
**proveedor (API)** y el **consumidor (cliente)**.
Estas reglas se formalizan mediante **contratos**, que detallan:

* Qué datos se envían y reciben.
* Qué respuestas devuelve la API en distintos escenarios.
* Cómo se manejan los errores o casos no permitidos.

Estos contratos deben ser **claros, documentados y testeables** para garantizar una <br>
comunicación consistente entre sistemas, sin importar el lenguaje de programación usado.

---

### **Flujo o funcionamiento de un contrato**

Ejemplo del contrato del recurso `/cashcards/{id}`:

```
Request:
  URI: /cashcards/{id}
  HTTP Verb: GET
  Body: None

Response:
  HTTP Status:
    200 OK           → solicitud exitosa y usuario autorizado
    401 UNAUTHORIZED → usuario no autenticado o sin permiso
    404 NOT FOUND    → recurso no existe, aunque el usuario está autorizado
  Response Body (JSON):
    {
      "id": 99,
      "amount": 123.45
    }
```

Este contrato **describe exactamente** cómo el cliente y el servidor deben comunicarse y qué esperar en cada caso.

---

### **Anotaciones / tecnologías clave**

* **HTTP Verbs:** `GET`, `POST`, `PUT`, `DELETE`
* **HTTP Status Codes:** `200`, `401`, `404`, `500`
* **Formato de datos:** `JSON`
* **Campos ejemplo:** `id`, `amount`
* **Concepto clave:** Serialización ↔ Deserialización (convertir objetos Java ⇄ JSON)

---

### **Errores comunes / Buenas prácticas**

* ❌ No documentar los endpoints ni los códigos de estado esperados.
* ❌ Modificar la estructura de respuesta sin avisar a los consumidores.
* ✅ Mantener los contratos versionados y consistentes.
* ✅ Escribir **tests automatizados** que validen el contrato (test-first).
* ✅ Preferir JSON frente a XML por su simplicidad y compatibilidad.

---

### **Ejemplo práctico**

Cuando un cliente hace una solicitud:

```http
GET /cashcards/99
```

La API devuelve:

```json
{
  "id": 99,
  "amount": 123.45
}
```

Si el usuario no tiene permisos, la respuesta será:

```http
401 UNAUTHORIZED
```

Este comportamiento está **definido en el contrato** y debe cumplirse siempre.

---

### **Qué se aprendió / Conclusión**

Un **API Contract** define el comportamiento esperado entre un servicio y sus clientes.
El uso de **JSON** como formato de datos facilita la interoperabilidad, la lectura y las pruebas automatizadas.
En resumen: un contrato bien definido garantiza **consistencia, claridad y testabilidad** en la comunicación entre sistemas.

---

### **Palabras clave**

> API Contract · REST · JSON · HTTP Status Codes · Consumer/Provider · Serialización · Comunicación entre servicios

---

## **Capítulo 4 – Testing First**

### 1. **Descripción general**

Este capítulo introduce el enfoque de **Test Driven Development (TDD)** y explica cómo los tests <br>
no solo sirven para validar el código, sino también para **diseñarlo desde el comportamiento deseado**.<br>
Además, presenta la **pirámide de testing** y el ciclo **Red–Green–Refactor** como pilares del desarrollo guiado por pruebas.

---

### 2. **Objetivo principal**

Comprender cómo escribir primero los tests permite **definir los requisitos del sistema antes de implementarlo**, <br>
asegurando un desarrollo más limpio, predecible y fácil de mantener.

---

### 3. **Conceptos clave**

* **TDD (Test Driven Development):**
  * Técnica donde se escriben tests *antes* del código funcional.
* **Propósito:**
  * Diseñar el sistema a partir del comportamiento esperado y reducir errores futuros.
* **Beneficio:** 
  * El test guía la implementación y actúa como red de seguridad ante regresiones.
* **Testing Pyramid:**
  * Representa los tipos de tests según su alcance, coste y velocidad:
      * **Unit Tests:** Pequeños, rápidos, independientes y numerosos.
      * **Integration Tests:** Verifican que distintos módulos funcionen juntos.
      * **End-to-End Tests:** Simulan el uso real, pero son lentos y frágiles.

* **Red, Green, Refactor Loop:**

    1. 🔴 *Red:* Escribir un test que falla.
    2. 🟢 *Green:* Implementar el código mínimo necesario para hacerlo pasar.
    3. ♻️ *Refactor:* Mejorar el código manteniendo el comportamiento.
    4. Repetir.

---

### 4. **Ejemplo o fragmento relevante**

```java
// Ejemplo conceptual de ciclo TDD
@Test
void should_returnBalance_whenCashCardExists() {
    CashCard card = new CashCard(1L, 100.00);
    assertEquals(100.00, card.getBalance());
}

// Paso siguiente → Implementar clase CashCard hasta que el test pase
```

Primero se define el comportamiento esperado, luego se implementa el código mínimo para cumplirlo.

---

### 5. **Qué se aprende como desarrollador**

* A **pensar en términos de comportamiento**, no solo en implementación.
* A **refactorizar con seguridad** gracias a una base de tests confiable.
* A mantener un **equilibrio entre distintos niveles de pruebas** para maximizar cobertura y eficiencia.
* A **crear software modular y mantenible** aplicando el ciclo Red–Green–Refactor.

---

### 6. **Relación con proyectos reales**

En proyectos con Spring Boot, TDD ayuda a construir **REST APIs robustas y coherentes**, donde los tests <br>
aseguran que los contratos JSON se respeten.
Además, tener una pirámide de tests bien equilibrada acelera la entrega continua y reduce los errores en producción.

---

### 7. **Resumen final**

El capítulo enseña que **escribir tests antes del código** no retrasa el desarrollo, sino que **lo estructura**.<br>
El **TDD** permite construir funcionalidades confiables paso a paso, mientras el **Red–Green–Refactor loop** <br>
garantiza que el código sea limpio, simple y sin duplicaciones.
Una buena estrategia de testing es esencial para mantener la calidad y velocidad del desarrollo en proyectos Spring Boot.

---

## Laboratory 1 — *Writing a Failing Test*

### **Objetivo del laboratorio**

Aprender el enfoque **Test-First** en el desarrollo (TDD: *Test-Driven Development*), <br>
escribiendo primero una prueba fallida para luego escribir el código que la haga pasar.<br>
Además, se introduce el uso de **JUnit 5**, **AssertJ** y el sistema de construcción **Gradle** dentro de un proyecto Java.

---

### **Estructura del proyecto**

* **Código de producción:** `src/main/java`
* **Código de test:** `src/test/java`
* Paquete de ejemplo: `example.cashcard`
* Clase de test: `CashCardJsonTest.java`

Mantener una estructura clara de carpetas separa la lógica de negocio del código de pruebas, una práctica estándar en proyectos Java.

---

### **Paso 1: Crear la clase de prueba**

Ubicación:
`src/test/java/example/cashcard/CashCardJsonTest.java`

Código base:

```java
package example.cashcard;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CashCardJsonTest {
    @Test
    void myFirstTest() {
        assertThat(1).isEqualTo(42);
    }
}
```

**Explicación:**

* `@Test`: indica que el método es una prueba (JUnit 5).
* `assertThat`: proviene de AssertJ y permite escribir aserciones legibles.
* Convención: el sufijo `Test` en el nombre de clase (`CashCardJsonTest`) ayuda a identificar rápidamente que es un test unitario.

---

### **Paso 2: Ejecutar el test (fallido)**

Comando:

```bash
./gradlew test
```

**Resultado esperado:**

```
expected: 42
 but was: 1
```

Esto confirma que el test falla, como se esperaba.
**Importante:** en TDD, comenzar con un test fallido garantiza que el sistema de pruebas está funcionando y que la falla es real.

---

### **Paso 3: Corregir el test**

Actualizar el código a:

```java
assertThat(42).isEqualTo(42);
```

Ejecutar nuevamente:

```bash
./gradlew test
```

**Salida:**

```
BUILD SUCCESSFUL
CashCardJsonTest > myFirstTest() PASSED
```

✅ El test ahora pasa.

---

### **Ciclo de TDD aprendido**

1. **Escribe una prueba que falle** → confirma que tu test detecta errores.
2. **Haz que la prueba pase** → implementa el código mínimo necesario.
3. **Refactoriza** → mejora el código manteniendo los tests en verde.

Este ciclo se conoce como **“Red → Green → Refactor”**.

---

### **Conceptos clave aprendidos**

| Concepto         | Descripción                                                                                          |
| ---------------- | ---------------------------------------------------------------------------------------------------- |
| **JUnit 5**      | Framework para ejecutar pruebas unitarias en Java.                                                   |
| **AssertJ**      | Librería que mejora la legibilidad de las aserciones (`assertThat(...)`).                            |
| **Gradle**       | Herramienta de automatización para compilar y ejecutar tests.                                        |
| **Test-First**   | Estrategia donde primero se define el comportamiento esperado (test), luego se implementa el código. |
| **Failing Test** | Garantiza que el sistema de pruebas está correctamente configurado.                                  |

---

### **Buenas prácticas destacadas**

* Usar nombres descriptivos en los métodos de test: `should_doSomething_when_condition()`
* Mantener los tests simples y legibles.
* Ejecutar los tests con frecuencia durante el desarrollo.
* No modificar el código de producción hasta que exista una prueba que falle.

---
---

## Laboratory 2 — *Creating a JSON Data Contract with TDD*

### **Objetivo del laboratorio**

Aprender a escribir una **prueba unitaria para serialización JSON** en Spring Boot utilizando:

* `@JsonTest` para probar la conversión de objetos Java a JSON (y viceversa).
* `JacksonTester` como herramienta para verificar estructuras JSON.
* El enfoque **TDD**, creando el código de producción **solo después** de que el test falle.

---

### **Estructura del proyecto**

* **Código de pruebas:** `src/test/java/example/cashcard/CashCardJsonTest.java`
* **Código de producción:** `src/main/java/example/cashcard/CashCard.java`
* **Recursos del test (JSON esperado):** `src/test/resources/example/cashcard/expected.json`

---

### **Paso 1: Crear la clase de prueba JSON**

Archivo: `CashCardJsonTest.java`

```java
package example.cashcard;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class CashCardJsonTest {

    @Autowired
    private JacksonTester<CashCard> json;

    @Test
    void cashCardSerializationTest() throws IOException {
        CashCard cashCard = new CashCard(99L, 123.45);

        assertThat(json.write(cashCard)).isStrictlyEqualToJson("expected.json");
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id").isEqualTo(99);
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount").isEqualTo(123.45);
    }
}
```

---

### 🧩 **Conceptos clave**

| Elemento                                     | Descripción                                                                                                |
| -------------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| `@JsonTest`                                  | Carga solo los componentes de Spring necesarios para pruebas de JSON. No inicia toda la aplicación.        |
| `JacksonTester`                              | Facilita la serialización y deserialización con **Jackson**, y permite comparar JSON de forma declarativa. |
| `@Autowired`                                 | Le indica a Spring que debe inyectar (crear e inicializar) el objeto necesario (`JacksonTester`).          |
| `assertThat(...).isStrictlyEqualToJson(...)` | Compara la salida generada con un archivo JSON esperado.                                                   |
| `hasJsonPath...` y `extractingJsonPath...`   | Permiten verificar campos específicos dentro del JSON.                                                     |

---

### **Paso 2: Ejecutar la prueba (fallará)**

```bash
./gradlew test
```

**Resultado esperado:**

```
error: cannot find symbol
  class CashCard
```

Esto ocurre porque la clase `CashCard` **aún no existe**.

---

### **Paso 3: Crear la clase `CashCard`**

Archivo: `src/main/java/example/cashcard/CashCard.java`

```java
package example.cashcard;

record CashCard(Long id, Double amount) {
}
```

**Explicación:**

* `record` es una característica de Java moderna (desde Java 16) que genera automáticamente:

    * Constructor
    * Getters (`id()`, `amount()`)
    * `equals()`, `hashCode()`, y `toString()`
* Es ideal para representar **data models inmutables** (objetos de datos sin lógica de negocio).

---

### **Paso 4: Fallo por JSON no encontrado**

```bash
java.lang.IllegalStateException: Unable to load JSON from class path resource [example/cashcard/expected.json]
```

Esto indica que falta el archivo `expected.json`, que define el **contrato de datos** esperado.

---

### 📄 **Paso 5: Crear el archivo de contrato JSON**

Ruta:
`src/test/resources/example/cashcard/expected.json`

Contenido inicial:

```json
{}
```

**Propósito:**
Provocar un fallo de comparación, asegurando que la prueba valida correctamente la estructura JSON.

---

### **Paso 6: Verificar el error de comparación**

Ejecutar:

```bash
./gradlew test
```

**Salida esperada:**

```
JSON Comparison failure:
Unexpected: amount
Unexpected: id
```

✅ Esto confirma que el test está comprobando correctamente los campos faltantes.

---

### **Paso 7: Completar el contrato de datos**

Actualizar el archivo `expected.json`:

```json
{
  "id": 99,
  "amount": 123.45
}
```

---

### **Paso 8: Ejecutar nuevamente**

```bash
./gradlew test
```

**Resultado:**

```
BUILD SUCCESSFUL
```

El test pasa correctamente.

---

### **Ciclo de TDD aplicado**

1. **Test fallido:** no existía `CashCard`.
2. **Código mínimo:** se creó `record CashCard`.
3. **Test fallido:** faltaba `expected.json`.
4. **Test fallido (estructura incorrecta):** JSON vacío.
5. **Corrección final:** JSON coincide con el contrato.
6. ✅ **Test pasa** → se completa la iteración TDD.

---

### 💡 **Conceptos aprendidos**

| Concepto                          | Descripción                                                       |
| --------------------------------- | ----------------------------------------------------------------- |
| **TDD aplicado a contratos JSON** | Define cómo deben verse los datos antes de implementar el código. |
| **Data Contract Testing**         | Asegura que el modelo Java y el JSON sean consistentes.           |
| **Jackson + Spring Boot**         | Permite probar serialización sin iniciar todo el contexto web.    |
| **Gradle test automation**        | Ejecuta automáticamente las pruebas y reporta fallos.             |

---

### 🧭 **Buenas prácticas destacadas**

* **Crear los tests antes del código.**
* **Mantener los JSON esperados versionados en `/resources/`.**
* **Usar `record` para modelos inmutables simples.**
* **Nombrar claramente los tests:** `should_serializeCashCard_when_givenValidData`.
* **Comprobar campos específicos con `hasJsonPath...` en lugar de comparar JSON completo** (más robusto ante cambios no relevantes de formato).

---
---

## Laboratory 3 — *Testing Deserialization in Spring Boot*

### **Objetivo del laboratorio**

Aprender a probar el proceso de **deserialización JSON → Java Object** utilizando Spring Boot y `JacksonTester`, <br>
aplicando nuevamente el enfoque **Test-Driven Development (TDD)**.

Este laboratorio complementa el anterior (serialización) para cubrir el ciclo completo de conversión de datos.

---

### **Concepto clave**

> **Deserialización** es el proceso inverso a la serialización: convierte un JSON o flujo de bytes en un objeto Java.
> Esto permite intercambiar datos entre distintas plataformas o sistemas, por ejemplo:
>
> * Un cliente en **Windows** serializa un objeto a JSON.
> * Un servidor en **Linux** deserializa ese mismo JSON en una clase Java.

El formato **JSON** es el más popular para este intercambio gracias a su simplicidad, compatibilidad y legibilidad.

---

### **Paso 1: Agregar el test de deserialización**

En el archivo de test existente
`src/test/java/example/cashcard/CashCardJsonTest.java`,
añade el siguiente método:

```java
@Test
void cashCardDeserializationTest() throws IOException {
    String expected = """
            {
                "id": 99,
                "amount": 123.45
            }
            """;

    assertThat(json.parse(expected))
            .isEqualTo(new CashCard(1000L, 67.89));
    assertThat(json.parseObject(expected).id()).isEqualTo(1000);
    assertThat(json.parseObject(expected).amount()).isEqualTo(67.89);
}
```

---

### 🧠 **Qué hace este test**

* Usa un **string JSON multilínea** (`"""..."""`) que simula el contenido de un archivo o respuesta HTTP.
* Llama a `json.parse(expected)` para convertir el texto JSON en una instancia de `CashCard`.
* Verifica con **AssertJ** (`assertThat`) que el objeto deserializado coincida con lo esperado.
* Intencionadamente, se escriben valores **incorrectos** para que el test **falle primero** (TDD).

---

### **Paso 2: Ejecutar el test (falla esperada)**

```bash
./gradlew test
```

**Resultado esperado:**

```bash
CashCardJsonTest > cashCardDeserializationTest() FAILED
 org.opentest4j.AssertionFailedError:
 expected: CashCard[id=1000, amount=67.89]
  but was: CashCard[id=99, amount=123.45]
```

El test falla correctamente, indicando que el JSON fue deserializado con los valores reales `"id":99` y `"amount":123.45`, mientras el test esperaba otros distintos.

---

### **Paso 3: Corregir los valores esperados**

Corrige las aserciones para que coincidan con los valores del JSON:

```java
assertThat(json.parse(expected))
        .isEqualTo(new CashCard(99L, 123.45));
assertThat(json.parseObject(expected).id()).isEqualTo(99);
assertThat(json.parseObject(expected).amount()).isEqualTo(123.45);
```

---

### ✅ **Paso 4: Ejecutar nuevamente el test**

```bash
./gradlew test
```

**Salida esperada:**

```
BUILD SUCCESSFUL
```

🎉 ¡El test pasa!
Ya tienes un par completo de pruebas que garantizan que la clase `CashCard`:

* Se **serializa** correctamente (Java → JSON).
* Se **deserializa** correctamente (JSON → Java).

---

### **Resumen técnico**

| Proceso             | Método utilizado       | Verificación                                     |
| ------------------- | ---------------------- | ------------------------------------------------ |
| **Serialización**   | `json.write(cashCard)` | Compara JSON generado con `expected.json`        |
| **Deserialización** | `json.parse(expected)` | Compara objeto resultante con instancia esperada |

Ambos tests confirman que el **contrato de datos** entre el modelo Java y el formato JSON se mantiene consistente.

---

### **Conceptos reforzados**

| Concepto                           | Descripción                                                                                                |
| ---------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| **JSON Contract Testing**          | Garantiza que los datos intercambiados cumplen el formato esperado, previniendo errores entre servicios.   |
| **Test-First Development (TDD)**   | Se escribe primero el test fallido, luego se implementa o corrige el código hasta que pase.                |
| **JacksonTester**                  | Permite probar tanto la escritura (serialización) como la lectura (deserialización) de JSON con facilidad. |
| **assertThat(...).isEqualTo(...)** | Compara objetos `record` de Java basados en sus valores de campo (`id`, `amount`).                         |

---

### **Ciclo TDD aplicado**

1. **Escribir un test que falle intencionadamente.**
2. **Analizar el fallo:** ver qué parte no cumple.
3. **Corregir los datos o el código.**
4. **Re-ejecutar el test hasta que pase.**

> Este ciclo rápido (Red → Green → Refactor) ayuda a validar comportamientos pieza por pieza.

---

### **Buenas prácticas**

* Nombrar los tests claramente, por ejemplo:
  `should_deserializeCashCard_when_givenValidJson`.
* Mantener los JSON esperados **dentro de `/resources/**`** o como texto multilínea.
* Evitar lógica compleja en los tests; deben ser **declarativos** y **legibles**.
* Cada test debe validar **una sola responsabilidad** (ej. solo deserialización).

---

### **Resumen del laboratorio**

Has aprendido:

1. Qué es la deserialización y su papel en la comunicación entre plataformas.
2. Cómo probar deserialización con Spring Boot usando `@JsonTest`.
3. Cómo combinar **serialización y deserialización** para validar la integridad del modelo.
4. Cómo aplicar TDD para definir primero los comportamientos deseados y luego el código que los cumple.

---

## **Capítulo 4: Implementing GET**

### **1️⃣ Concepto Central**

En este capítulo aprendes cómo crear un **endpoint RESTful con Spring Boot**, comenzando por el método **GET**, que permite **leer recursos (READ)** desde tu API.
El objetivo es comprender qué es **REST**, cómo se relaciona con **CRUD** y **HTTP**, y cómo se implementa un endpoint en Spring usando anotaciones como `@RestController`, `@GetMapping` y `@PathVariable`.

---

### **2️⃣ Qué es REST y su relación con CRUD**

**REST (Representational State Transfer)** es un estilo arquitectónico para manejar **recursos** mediante peticiones HTTP.
Cada recurso representa un objeto con estado (por ejemplo, una tarjeta CashCard con su `id` y `amount`).

| CRUD       | Acción                | Método HTTP | Descripción                   |
| ---------- | --------------------- | ----------- | ----------------------------- |
| **C**reate | Crear un recurso      | `POST`      | Inserta un nuevo recurso      |
| **R**ead   | Leer un recurso       | `GET`       | Recupera un recurso existente |
| **U**pdate | Actualizar un recurso | `PUT`       | Modifica un recurso existente |
| **D**elete | Borrar un recurso     | `DELETE`    | Elimina un recurso            |

Cada operación se asocia a una **URI** (`/cashcards/{id}`) y un **status code** que confirma su resultado (200, 201, 204…).

---

### **3️⃣ Flujo HTTP de una Operación REST**

#### **Request**

* **Método (HTTP Verb):** Ej. `GET`
* **URI (Endpoint):** Ej. `/cashcards/123`
* **Body:** vacío en GET

#### **Response**

* **Status Code:** 200 (OK)
* **Body:** JSON con el recurso solicitado

  ```json
  {
    "id": 123,
    "amount": 25.00
  }
  ```

REST se apoya en el protocolo **HTTP** para intercambiar información estructurada en formato **JSON**, el formato más usado por su legibilidad y compatibilidad entre plataformas.

---

### **4️⃣ Cómo REST se Implementa en Spring Boot**

Spring simplifica la creación de APIs REST a través de su **IoC Container (Inversión de Control)** y **Component Scan**, que crean e inyectan automáticamente objetos (Beans).

#### 🔹 **Anotaciones Clave**

* `@RestController`: convierte la clase en un controlador REST que maneja solicitudes web.
* `@GetMapping`: asocia un método a una petición HTTP GET.
* `@PathVariable`: vincula variables de la ruta (`{id}`) a parámetros del método.

#### **Ejemplo Base**

```java
@RestController
class CashCardController {

  @GetMapping("/cashcards/{requestedId}")
  private ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
     CashCard cashCard = /* lógica para obtener la CashCard */;
     return ResponseEntity.ok(cashCard);
  }
}
```

**Explicación paso a paso:**

1. **Spring crea el controlador** automáticamente gracias a `@RestController`.
2. **`@GetMapping`** indica que el método responde a solicitudes **GET** dirigidas a `/cashcards/{requestedId}`.
3. **`@PathVariable`** extrae el valor del ID desde la URL.
4. **`ResponseEntity.ok(...)`** genera una respuesta HTTP 200 con el recurso solicitado.

---

### **5️⃣ Buenas Prácticas Aprendidas**

✅ Sigue la convención REST: una URI representa un recurso y el método HTTP indica la acción.
✅ Usa códigos de estado HTTP correctos (`200`, `201`, `204`).
✅ Mantén el **controlador limpio**, delegando la lógica de negocio a otros componentes (Services, Repositories).
✅ Usa **ResponseEntity** para un control más explícito de las respuestas.

---

### **6️⃣ Qué Aprendes en Este Capítulo**

🔸 Entiendes el concepto de **REST y CRUD**.
🔸 Aprendes cómo **Spring Boot maneja peticiones HTTP** mediante controladores.
🔸 Creas tu **primer endpoint RESTful** usando **GET**.
🔸 Comprendes el uso de **anotaciones Spring** para mapear rutas y parámetros.
🔸 Te introduces al flujo **Request → Controller → Response** con Spring Web.

---

## **LAB: Implementing GET**

### **1️⃣ Crear el Test con SpringBootTest**

* **Archivo:** `src/test/java/example/cashcard/CashCardApplicationTests.java`
* **Objetivo:** Probar el endpoint `GET /cashcards/{id}` antes de implementarlo.
* **Código clave del test:**

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CashCardApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldReturnACashCardWhenDataIsSaved() {
        ResponseEntity<String> response = restTemplate.getForEntity("/cashcards/99", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
```

#### **Elementos importantes del test**

1. `@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)`
    * Inicia la aplicación en un **puerto aleatorio** para pruebas HTTP.

2. `@Autowired TestRestTemplate restTemplate`
    * Spring inyecta un **cliente HTTP de prueba** que permite enviar requests a la app.

3. `restTemplate.getForEntity("/cashcards/99", String.class)`
    * Realiza un **GET request** al endpoint.

4. `assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK)`
    * Verifica que el **status code** devuelto sea 200 OK.

---

### **2️⃣ Ejecutar el test**

* Comando para ejecutar tests:

```bash
./gradlew test
```

* **Resultado esperado:** Falla el test.

```bash
CashCardApplicationTests > shouldReturnACashCardWhenDataIsSaved() FAILED
  expected: 200 OK
   but was: 404 NOT_FOUND
```

---

### **3️⃣ Entender el error**

* `404 NOT_FOUND` → Spring Web no encuentra la ruta `/cashcards/99`.
* Esto es **normal en TDD**: escribimos primero la prueba antes de implementar el endpoint.
* El fallo confirma que **el test realmente está verificando algo**.

---

### **4️⃣ Conclusión del LAB**

✅ Hemos creado un test SpringBoot que espera un **GET endpoint funcional**.
✅ Aprendemos el ciclo **Red → Green → Refactor**:

1. **Red:** Test falla (endpoint no existe).
2. **Green:** Implementar endpoint para pasar el test.
3. **Refactor:** Mejorar la implementación si es necesario.

---
---

# **Implementando GET en Spring Boot – Resumen Detallado**

## **2: Crear un REST Controller**

**Objetivo:** Que Spring Web reconozca una clase como controlador para manejar solicitudes HTTP.

### **Pasos**

1. Crear la clase `CashCardController` en:

   ```
   src/main/java/example/cashcard/CashCardController.java
   ```
2. Agregar un método handler básico `findById()` que devuelva una respuesta HTTP vacía:

   ```java
   private ResponseEntity<String> findById() {
       return ResponseEntity.ok("{}");
   }
   ```
3. Ejecutar el test de GET:

    * Resultado: **404 NOT_FOUND**.
    * Razón: Aunque la clase se llama `Controller`, Spring no la reconoce hasta que se use la anotación adecuada.

**Concepto clave:** Nombrar una clase `Controller` no es suficiente; Spring necesita `@RestController` para registrarla como bean manejador de requests.

---

## **3: Configurar el endpoint GET**

**Objetivo:** Hacer que Spring Web redirija las solicitudes GET a nuestro método.

### **Pasos**

1. Anotar la clase y método:

   ```java
   @RestController
   @RequestMapping("/cashcards")
   class CashCardController {

       @GetMapping("/{requestedId}")
       private ResponseEntity<String> findById() {
           return ResponseEntity.ok("{}");
       }
   }
   ```
2. Significado de las anotaciones:

    * `@RestController`: Indica que la clase maneja solicitudes REST y Spring la registra como bean.
    * `@RequestMapping("/cashcards")`: Todas las rutas de esta clase comienzan con `/cashcards`.
    * `@GetMapping("/{requestedId}")`: El método maneja GET a `/cashcards/{requestedId}`.

3. Ejecutar test:

    * Resultado: **200 OK**.
    * Ahora Spring reconoce la ruta y responde, aunque el contenido JSON todavía no es correcto.

**Concepto clave:** Spring utiliza anotaciones para mapear URLs y métodos HTTP a métodos específicos del controlador.

---

## **4: Completar el GET endpoint con datos correctos**

**Objetivo:** Que la respuesta contenga datos válidos (`id` y `amount`) según el contrato JSON de CashCard.

### **Pasos**

1. Actualizar el test para validar el contenido JSON:

   ```java
   DocumentContext documentContext = JsonPath.parse(response.getBody());
   Number id = documentContext.read("$.id");
   assertThat(id).isEqualTo(99);

   Double amount = documentContext.read("$.amount");
   assertThat(amount).isEqualTo(123.45);
   ```
2. Inicialmente, el controlador devuelve datos incorrectos para ilustrar fallos por la razón correcta:

   ```java
   CashCard cashCard = new CashCard(1000L, 0.0);
   return ResponseEntity.ok(cashCard);
   ```

    * Test falla correctamente porque los valores no coinciden con las expectativas (`id=99`, `amount=123.45`).
3. Corregir el controlador:

   ```java
   @GetMapping("/{requestedId}")
   private ResponseEntity<CashCard> findById() {
       CashCard cashCard = new CashCard(99L, 123.45);
       return ResponseEntity.ok(cashCard);
   }
   ```
4. Ejecutar test:

    * Resultado: **BUILD SUCCESSFUL**
    * Ahora la respuesta tiene el JSON correcto con `id=99` y `amount=123.45`.

**Conceptos clave**

* Validación progresiva:

    1. Status HTTP → 200 OK.
    2. Contenido JSON → `id` no nulo.
    3. Contenido JSON completo → `id` y `amount` correctos.
* Importancia de TDD: Los tests pasan o fallan **por la razón correcta**, evitando falsos positivos.

---

# **5: Uso de @PathVariable**

**Objetivo:** Que el controlador devuelva un Cash Card solo si el ID solicitado coincide con uno existente, y devuelva un 404 si no existe.

---

## **2: Crear un nuevo test para ID desconocido**

* Nuevo test en `CashCardApplicationTests`:

```java
@Test
void shouldNotReturnACashCardWithAnUnknownId() {
    ResponseEntity<String> response = restTemplate.getForEntity("/cashcards/1000", String.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(response.getBody()).isBlank();
}
```

* **Qué valida:**

    * Si se solicita un `id` que no existe (`1000`), el servicio debe responder `404 NOT_FOUND`.
    * El cuerpo de la respuesta debe estar vacío.

---

## **3: Ejecutar el test**

* Resultado esperado: **404 NOT_FOUND**
* Resultado actual: **200 OK** → Test falla porque actualmente el controlador siempre devuelve el Cash Card `99`.

**Concepto clave:** Los tests deben reflejar la semántica correcta de HTTP, en este caso, `NOT_FOUND` si el recurso no existe.

---

## **4: Usar @PathVariable en el controlador**

1. Modificar el método handler para que Spring reciba el `requestedId` desde la URL:

```java
@GetMapping("/{requestedId}")
private ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
    CashCard cashCard = new CashCard(99L, 123.45);
    return ResponseEntity.ok(cashCard);
}
```

* **@PathVariable:** Indica a Spring que inyecte el valor de `{requestedId}` de la URL en el parámetro del método.

2. Actualizar la lógica para manejar correctamente IDs desconocidos:

```java
@GetMapping("/{requestedId}")
private ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
    if (requestedId.equals(99L)) {
        CashCard cashCard = new CashCard(99L, 123.45);
        return ResponseEntity.ok(cashCard);
    } else {
        return ResponseEntity.notFound().build();
    }
}
```

* **Qué hace la lógica:**

    * Si `requestedId` es `99`, devuelve `200 OK` con el Cash Card.
    * Si no, devuelve `404 NOT_FOUND` con cuerpo vacío.

---

## **5: Ejecutar los tests finales**

* Todos los tests ahora pasan:

    * `GET /cashcards/99` → 200 OK con JSON correcto.
    * `GET /cashcards/1000` → 404 NOT_FOUND.

**Conceptos clave:**

* `@PathVariable` permite usar dinámicamente valores de la URL en el controlador.
* TDD garantiza que el controlador solo devuelva datos válidos y que falle correctamente para IDs no válidos.
* La semántica HTTP (`200 OK` vs `404 NOT_FOUND`) se respeta según la existencia del recurso.
