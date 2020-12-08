# Car Insurance Challenge

## Tecnilogias, depdendencias usadas
* Java 8
* [Maven](https://maven.apache.org/como), administrador de depedencias y ciclo de vida del proyecto.
* [JaCoCo](https://www.eclemma.org/jacoco/), libreria para java utilizada para cobertura de código.
* [Junit5](https://junit.org/junit5/), framework de testing.
* [mockito](https://site.mockito.org/), mocking framework para test unitarios.

## Cómo se encaró la solución
Trate de ir encarando los distintos puntos manteniendo el mismo enfoque que usaría para una aplicación productiva. Teniendo a `develop` como branch defualt y subiendo al mismo código funcional y testeable. El orden que utilicé fue:
1. Agregar cobertura al código inicial y generar reporte de cobertura. 
2. Solucionar el problema implementación de "Super Sale".
3. Refactorizar el caso de uso de CarInsurance y la actualizacion de precios de los productos.
4. Agregar el script para mostrar los productos después de 30 dias.

Los únicos pasos en donde dude si invertir el orden fue el primero y el segundo. Ya que dependiendo el impacto y los mecanismos que se tengan para revertir esa nueva feauture o por lo menos que no utilizable la misma; por ahi va a depender la prioridad con la que se atacá ese fix. Por otro lado, tratar de solucionar dicho problema, en un código como este puede ser contra producente ya que hay muchas posibilidades en meter un comportamiento no esperado en otros productos que si estaban funcionando correctamente. Y esto es más problable justamente por no tener cubierto los otros casos.


## Diagrama de clase de la solución
![image](https://user-images.githubusercontent.com/11875266/101401136-a7782300-38b0-11eb-9add-a7238a873012.png)


## Consideraciones sobre la solución
* Java al ser un lenguaje con típado estático obliga a definir los tipos de las clases, variables, etc. Dicho la anterior para el tipo de `price` se decantó por usar un `int`. Tomé esta decisión por el uso que se estaba dando en el ejercicío y sus casos de usos. En una aplicación productiva donde el precio puede llegar a ser más complejo, con valores decimales y sus actualizaciones es el producto de varias operaciones que pueden incluir productos, divisiones, porcentajes no iría por ese tipo sino por un `BigDecimal`. Pero afectos del ejercicio y lo que se buscaba en el mismo me parecio la más adecuado.
* Respecto "Mega Coverage". Aunque el dominio habla de que es un producto legendario, en más de una oportunidad. No queda claro si hay más productos legendarios actualmente y si entre ellos comparten comportamiento o estado. Por esta razón, al hacer el refactor y modelizar los productos me decidí por no modelizar el concepto de legendario.
* Sobre "Special Full Coverage" y "Mega Coverage": Acá me paso algo similar al punto anterior. En los casos de uso de "Special Full Coverage" nos dice que dada cierta condiciónl, el producto no esta más habilitado. Y respecto a "Mega Coverage" nos dice que no se puede vender. No me quedó muy claro si no estar habilitado y no que se pueda vender tenían la misma semántica. Además, el ejercició,  no deja claro si un producto aunque haya pasado sus días para venderlo, posteriormente no se puede vender o si pasa lo mismo al llegar al un valor 0. Por estos motivos en mi solución no modelicé estado o comportamiento relacionado a estar habilitado o disponible para su venta.

## Ejemplo para ejecutar desde docker
```
docker image build -t demo .
docker container run -d -t demo bash
docker exec -it {container_id} bash

//Dentro del bash
cd home/app
```
Una vez realizado esto se pueden ejecutar los distintos comandos. 

## Comandos
* `mvn test`, ejecuta los test y genera el reporte de cobertura. Una vez completado el comando el reporte se puede observar dentro de _home/app/target/site/jacoco/index.html_
* `mvn compile exec:java -Dexec.mainClass="After30DaysMain"`, compila la aplicacón y ejecuta el script que muestra por la salida standar el resultado de actualizar los precios por 30 días. 
* `mvn clean verify`, ejecuta los test y goals de verificación de cobertura. 

