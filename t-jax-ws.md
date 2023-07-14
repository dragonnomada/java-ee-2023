# Servicios Web de JAX-WS

JAX-WS (Java API for Web Services) es un mecanismo en el que podemos definir servicios web a través de métodos web. Por ejemplo, un método tradicional tiene parámetros de entrada y un parámetro de salida. Pues de forma similar el Servicio Web de *JAX-WS* nos permite definir este método como una clase de Java, la cual ha sido anotada como servicio web (`@WebService`) y cada uno de sus métodos será maracado como un método web (`@WebMethod`) para que un cliente pueda consumir este método enviando parámetros anotados como parámetros web (`@WebParam`) y produzcan un resultado anotado como el resultado web (`@WebResult`) para que podemos mandar a llamar este método web de forma remota usando *SOAP* (con XML) o *RMI* (con Java).

> **VENTAJAS**

- Hay una única ruta final para todo el servicio (un único *endpoint*) que consume todos los métodos web de ese servicio. Por ejemplo, `/FacturaWS?wsdl`, `/ClienteWS?wsdl`, `/ConsultaWS?wsdl`, `ReporteWS?wsdl`, etc.
- Todos los métodos web definidos dentro del servicio web *están bien definidos*, es decir, anotan perfectamente qué parámetros web necesitan y cuál será el resultado web esperado. Con esto un cliente puede enviar los datos de los parámetros sin tener que recodar o documentarse qué tipo de parámetros recibe y cuál es resultado esperado. Así por ejemplo, en 10 años, podríamos consumir el mismo servicio web, sin tener que recordar o acceder a la documentación de qué parámetros requiere para operar.
- Un fácil intercambio de objetos `XML` (a través de SOAP), por lo que, siempre se espera recibir un `XML` y devolver un `XML`, es decir, las entradas y salidas se encuentran estandarizadas a *SOAP*.
- Además de clientes *SOAP* podemos atender a clientes Java para que el *WSDL* que define nuestro servicio pueda ser traducido a clases de Java que utilicen *RMI* y a través de un proceso de Proxy consumamos nuestro servicio cómo si se tratara de un servicio local, pero que en realidad es remoto.

> **DESVENTAJAS**

- No están diseñados para la carga archivos (esa se podría hacer con *WebServlet* o *JAX-RS*), sin embargo, existen otras alternativas.
- Los clientes requieren procesar *SOAP*, lo que podría volverlo complejo para clientes web como los basados en HTML y Javascript, quiénes están más acostumbrados a utilizar JSON. Esto requiere un desarrollo intermedio (un conciliador) que haga la traducción de JSON a SOAP y viceversa.

> **Ejemplo de un Servicio Web**

```java
@WebService(serviceName="HelloWS")
public class HelloWebService {

    @WebMethod
    @WebResult(name="message")
    public String sayHello() {
        return "Hello world :D";
    }

    @WebMethod
    @WebResult(name="report")
    public String generarReporte(@WebParam(name="min") double min, 
                                    @WebParam(name="max") double max) {
        return String.format("Hello, min=%.2f, max=%.2f, avg=%.2f", min, max, (min + max) / 2);
    }

    // ... Otros métodos

}
```

**CUIDADO:** La configuración del `serviceName="XXXX"` no debe empezar en minúsculas, por ejemplo, `serviceName="HelloWS"` es correcto, y `serviceName="helloWS"` es incorrecto. El problema es que un cliente Java no podría traducir los códigos. 

> **Ejemplo de un cliente Java (otro proyecto) que consume de forma remota (con RMI) nuestros métodos web**

```java
@Path("/hello")
public class HelloRest {

	// No es correcto -> Envolver en Bean
	HelloWebService helloWebService = new HelloWebServiceProxy();
	
	@GET
	@Path("/report")
	public String report(@QueryParam("min") Double min, @QueryParam("max") Double max) {
		if (min == null) {
			min = 0.0;
		}
		
		if (max == null) {
			max = 0.0;
		}
		
		try {
			return helloWebService.generarReporte(min, max);
		} catch (RemoteException e) {
			return "Error: " + e.getMessage();
		}
	}
	
}
```