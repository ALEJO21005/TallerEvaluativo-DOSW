# Taller Evaluativo - SOLID, Patrones de diseño y diagramas UML 

### Autor: 
* Sergio Alejandro Idarraga Torres

## ✅ Taller completado

Contexto: 
Se requiere realizar un sistema de gestión de inventarios donde el usuario pueda adicionar un producto con su nombre, precio, cantidad en stock y la categoría a la que pertenece. Adicionalmente se debe poder actualizar la cantidad disponible del producto y notificar a los clientes sobre estos cambios.

Para resolver este problema se baso en el ciclo TDD (Test Driven Development).
* La parte (roja) consiste en realizar las pruebas unitarias de cada requerimiento del sistema con el onjetivo de ver como se debería de comportar el sistema. Cabe aclarar que en esta parte del ciclo las pruebas no deben de pasar porque no existe una implementación para hacer esto posible.
* La parte (azul) consiste en implementar el mínimo código necesario para que las pruebas implementadas anteriormente pasen sin problemas.
* La parte (verde) es la etapa final de este ciclo, consiste en hacer un refactor del código implementado para que sea mantenible y duradero a largo plazo.

Se utilizaron dos de los principios SOLID:
* S: Single responsablity porque a cada clase se le esta asignando una única responsabilidad como producto que solo crea un producto en concreto, inventario donde hace todo el manejo de productos.
* L: Liskov substitution porque este principio establece que las clases derivadas deben poder sustituir a su clase base sin alterar el correcto funcionamiento del programa. En agente al definir métodos abstractos se obliga a las subclases a implementar ese comportamiento, asegurando la coherencia y la intercambiabilidad.

### Patrón de diseño implementado: 

* Patrón de comportamiento "Observer"
  - La clase Inventario mantiene una lista de Agente(s) (observadores).
  - Cuando ocurre un cambio relevante (agregar producto, modificar cantidad), se notifica a todos los agentes mediante los métodos notificarModificacion y notificarAdvertencia.
  - Este patrón permite que los agentes reaccionen a cambios en el inventario sin acoplar directamente la lógica de notificación a la clase principal.

### Comandos clave para ejecución: 
* mvn clean install / mvn compile: Para ver si el proyecto maven esta funcionando correctamente 
* mvn test: Para correr todas las pruebas de unidad y generar el archivo de JaCoCo
* docker run -d --name sonarqube -p 9000:9000 sonarqube:lts: Para iniciar Docker con un contenedor que crea un contenedor para correr Sonar qube
* docker ps: Verifica si el contenedor está corriendo
* mvn clean verify sonar:sonar `
  -Dsonar.projectKey=eci.edu.dosw.parcial `
  -Dsonar.host.url=http://localhost:9000 `
  -Dsonar.login=EL_TOKEN_GENERADO
Para ejecutar el análisis de sonar qube desde el proyecto maven

* docker ps -a: Para verificar si el contenedor existe
* docker start "sonarqube_nombre_contenedor": Para arrancar el contenedor si está detenido



## Pruebas unitarias por cada clase (Agente, Inventario, Producto)

### Ciclo TDD
<p align="center">
<img width="410" height="410" alt="image" src="https://github.com/user-attachments/assets/411d8d45-750a-47e1-b93b-eacbd73b7778" />
</p>

### AgenteTest
<img width="1323" height="878" alt="image" src="https://github.com/user-attachments/assets/de45e08e-1aa7-4cff-8339-016b140c8f03" />
<img width="1805" height="405" alt="image" src="https://github.com/user-attachments/assets/2679ad96-f164-4eaa-8ebc-ee300b3affdd" />

### ProductoTest
<img width="1816" height="814" alt="image" src="https://github.com/user-attachments/assets/cdea73fc-ccb0-4991-a91d-d483d701549f" />
<img width="1795" height="524" alt="image" src="https://github.com/user-attachments/assets/8f35618a-28f1-4429-afd2-964059a4a1f8" />

## InventarioTest
<img width="1788" height="633" alt="image" src="https://github.com/user-attachments/assets/1eaa1dd8-1168-4174-8fb8-58cc0be09fab" />
<img width="1779" height="408" alt="image" src="https://github.com/user-attachments/assets/f7b20d23-bbe0-4a88-9422-2adbe146389a" />


## Implementación del código

### Agente 
<img width="1220" height="248" alt="image" src="https://github.com/user-attachments/assets/3c739421-23a3-45fb-8d19-3310ae060258" />

### AgenteAdevertencia
<img width="1439" height="461" alt="image" src="https://github.com/user-attachments/assets/c8571ad3-baa3-4aad-9636-8f2ee54fecc7" />

### AgenteLog
<img width="1375" height="452" alt="image" src="https://github.com/user-attachments/assets/dc237ab1-133f-4330-b1e1-b7910bade2bc" />

### Inventario 
<img width="1279" height="671" alt="image" src="https://github.com/user-attachments/assets/1d60deda-b2e8-49b8-b27e-438a7fffae7f" />
<img width="1314" height="728" alt="image" src="https://github.com/user-attachments/assets/578c4347-cfeb-4174-bbf9-50f19ba0f0aa" />
<img width="1027" height="418" alt="image" src="https://github.com/user-attachments/assets/fca04eae-bece-43c0-aa71-ced027f62160" />


## 📊 Covertura de pruebas con JaCoCo

<img width="1553" height="241" alt="image" src="https://github.com/user-attachments/assets/96b01e33-87b9-4c52-8dee-158bfac98cea" />
Se ejecutaron pruebas unitarias sobre el proyecto gestiónInventario, obteniendo los siguientes resultados:

Cobertura de Instrucciones (Instructions Coverage): 90%
De 198 instrucciones, solo 18 no fueron ejecutadas durante las pruebas. Esto indica que la mayoría del código ha sido validado correctamente mediante casos de prueba.

Cobertura de Ramas (Branches Coverage): 85%
De 14 ramas condicionales, únicamente 2 no fueron cubiertas. Esto refleja que la mayoría de las estructuras de control (if, else, switch) fueron probadas, aunque aún existen escenarios no evaluados.


<img width="1450" height="306" alt="image" src="https://github.com/user-attachments/assets/b899e775-86bf-4e8e-a6e5-80a79edb873c" />
El reporte de pruebas muestra que el sistema tiene una cobertura muy alta: en general se alcanzó un 94% de cobertura de instrucciones y 85% de ramas. Las clases principales como Inventario y Producto están bien probadas (con 95% y 89% de cobertura respectivamente), mientras que otras clases como AgenteAdvertencia y AgenteLog tienen el 100% cubierto. Esto significa que la mayoría del código fue verificado con pruebas y solo faltan algunos pocos casos condicionales o escenarios específicos por probar.



## Diagramas UML 

### Diagrama de contexto 

<img width="1080" height="1143" alt="Diagrama de Contexto" src="https://github.com/user-attachments/assets/a4d2a513-d04d-45ac-8ea4-e486c2c9dec7" />

### Diagrama de clases

<img width="2180" height="1352" alt="Diagrama de Clases" src="https://github.com/user-attachments/assets/90460c47-b9a3-419a-b3b6-77113f436683" />

### Diagrama de casos de uso

<img width="1000" height="900" alt="Diagrama Casos de Uso" src="https://github.com/user-attachments/assets/0331b46d-bda2-4ff4-a6e7-8fb0c1a74002" />
