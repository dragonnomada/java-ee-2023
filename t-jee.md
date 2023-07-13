# Java EE

Consiste en montar componentes de Java, anotados o adaptados mediante
documentos XML o anotaciones tipo `@` las cuales hacen que estos componentes
se auto-administren por los contenedores.

## Contenedor *Web Container*

Nos permite contener componentes como:

> **WebServlet** - Permite controlar peticiones web (tipo HTTP) de entrada y respuestas de salida a clientes web como navegadores o aplicaciones tipo API que lancen peticiones tipo GET y tipo POST para ser controladas en métodos `doGet`, `doPost`, etc. El Servlet tiene el objetivo de controlar la petición cruda y controlar la respuesta cruda. Es decir, recuperar *cabeceras* y *streams* de la petición y formar una respuesta completa con el *estatus http*, el *cuerpo de respuesta*, etc.

    Configuración manual en el XML

```xml
<servlet>
<servlet-name>Hello Servlet</servlet-name>
<servlet-class>com.example.servlet.HelloServlet</servlet-class>
</servlet>

<servlet-mapping>
<servlet-name>Hello Servlet</servlet-name>
<url-pattern>/hello</url-pattern>
</servlet-mapping>
```

    Auto-configuración con anotaciones (sin XML)

```java
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

// La anotación equivale a configurar el web.xml
// indicando el <servlet> y el <servlet-mapping> con sus detalles
@WebServlet(name="HelloServlet", urlPatterns={ "/hello" })
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 8655324001834130179L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		resp.getWriter().printf("Hello, %s", name);
	}
	
}
```

> **JAX-RS** - Permite controlar peticiones web (tipo HTTP) de entrada y respuesta a clientes web como navegadores o aplicaciones tipo API que lancen peticiones tipo GET, tipo POST, tipo PUT, tipo DELETE, tipo PATCH (Métodos HTTP RESTful), bajo las anotaciones `@GET`, `@POST`, `@PUT`, etc. Para recibir parámetros de la URL con `@QueryParam`, o entre la URL `@PathParam` y producir o consumir resultados complejos en clases POJO (`@Produces` o `@Consumes`).

    Activador de una aplicación JAX-RS

```java
import javax.ws.rs.core.Application;
import javax.ws.rs.core.ApplicationPath;

@ApplicationPath("/api") // /api
class RestApplication extends Application {

    // TODO: Configuraciones avanzadas

}
```

    Controlador de una ruta JAX-RS

```java
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;

// continuando de /api
@Path("/hello") // /api/hello
class HelloRest {

    @GET // GET /api/hello
    public String hello(@QueryParam("name") String name) {
        return String.format("Hello, %s", name);
    }

}
```

> **JAX-WS** - Permiten controlar peticiones *SOAP* (tipo *WSDL*) de entrada y respuesta a clientes *SOAP* o aplicaciones que integren Java RMI con conversiones a nuestros servicios. Se basan en definir *Métodos Web* (`@WebMethod`) para definir un método que pueda ser consumido en forma remota, es decir, consumir el método mediante un documento `XML` que contenga los parámetros que requiere el método web en formato *SOAP*.

    Definición de Web Service y sus métodos de una aplicación JAX-WS

```java
package com.example.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.example.model.Greeting;

@WebService(serviceName="HelloWS") // /HelloWS/?wsdl
public class HelloWebService {

    @WebMethod // <ws:sayHello> <firstName>Ana</firstName> </ws:sayHello>
    @WebResult(name="greeting") // <greeting> <title> ... </title> </greeting>
    public Greeting sayHello(@WebParam(name="firstName") String name) {
        return new Greeting(name); // <title> Hello, Ana </soap>
    }

}
```

**IMPORTANTE:** El `serviceName` no debe iniciar con minúsculas porque habrá errores en la traducción a código de Java RMI.

**IMPORTANTE:** La clase debe ser pública (`public class`).

**IMPORTANTE:** Se recomienda devolver tipos adaptados a *SOAP*.

**IMPORTANTE:** Se recomienda generar el proyecto con su `WebContent/WEB-INF/web.xml`

**IMPORTANTE:** Se recomienda establecer un nombre diferente (sin empezar en minúsculas) entre el nombre de la clase del *Web Service* y el nombre de servicio *WSDL*.

    Definir modelos POJO adaptadas a XML (para SOAP)

```java
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

// SOAP -> Literal

@XmlRootElement
public class Greeting {

	private String title;
	
	public Greeting() {
		title = "Hello, you";
	}
	
	public Greeting(String name) {
		title = String.format("Hello, %s", name);
	}

	@XmlElement
	public String getTitle() {
		return title;
	}
	
}
```

    Obtenemos la definición del esquema WSDL

    http://localhost:8080/WebappHelloJAXWS/HelloWS?wsdl

```xml
<?xml version='1.0' encoding='UTF-8'?><!-- Published by JAX-WS RI at http://jax-ws.dev.java.net. RI's
version is Metro/2.3 (tags/2.3-7528; 2013-04-29T19:34:10+0000) JAXWS-RI/2.2.8 JAXWS/2.2
svn-revision#unknown. --><!-- Generated by JAX-WS RI at http://jax-ws.dev.java.net. RI's
version is Metro/2.3 (tags/2.3-7528; 2013-04-29T19:34:10+0000) JAXWS-RI/2.2.8 JAXWS/2.2
svn-revision#unknown. -->
<definitions
    xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"
    xmlns:wsp="http://www.w3.org/ns/ws-policy"
    xmlns:wsp1_2="http://schemas.xmlsoap.org/ws/2004/09/policy"
    xmlns:wsam="http://www.w3.org/2007/05/addressing/metadata"
    xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tns="http://ws.example.com/"
    xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns="http://schemas.xmlsoap.org/wsdl/"
    targetNamespace="http://ws.example.com/" name="HelloWS">
    <types>
        <xsd:schema>
            <xsd:import namespace="http://ws.example.com/"
                schemaLocation="http://localhost:8080/WebappHelloJAXWS/HelloWS?xsd=1" />
        </xsd:schema>
    </types>
    <message name="sayHello">
        <part name="parameters" element="tns:sayHello" />
    </message>
    <message name="sayHelloResponse">
        <part name="parameters" element="tns:sayHelloResponse" />
    </message>
    <portType name="HelloWebService">
        <operation name="sayHello">
            <input wsam:Action="http://ws.example.com/HelloWebService/sayHelloRequest"
                message="tns:sayHello" />
            <output wsam:Action="http://ws.example.com/HelloWebService/sayHelloResponse"
                message="tns:sayHelloResponse" />
        </operation>
    </portType>
    <binding name="HelloWebServicePortBinding" type="tns:HelloWebService">
        <soap:binding transport="http://schemas.xmlsoap.org/soap/http" style="document" />
        <operation name="sayHello">
            <soap:operation soapAction="" />
            <input>
                <soap:body use="literal" />
            </input>
            <output>
                <soap:body use="literal" />
            </output>
        </operation>
    </binding>
    <service name="HelloWS">
        <port name="HelloWebServicePort" binding="tns:HelloWebServicePortBinding">
            <soap:address location="http://localhost:8080/WebappHelloJAXWS/HelloWS" />
        </port>
    </service>
</definitions>
```

    Lanzamos la petición tipo SOAP al servicio WSDL

    http://localhost:8080/WebappHelloJAXWS/HelloWS

    Consumimos el Método Web SOAP con alguna herramienta como:

    - CURL
    - POSTMAN
    - SOAP-UI

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://ws.example.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <ws:sayHello>
         <!--Optional:-->
         <firstName>Ana</firstName>
      </ws:sayHello>
   </soapenv:Body>
</soapenv:Envelope>
```

    Esperamos la respuesta tipo SOAP

```xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <ns2:sayHelloResponse xmlns:ns2="http://ws.example.com/">
         <greeting>
            <title>Hello, Ana</title>
         </greeting>
      </ns2:sayHelloResponse>
   </S:Body>
</S:Envelope>
```

    Generamos las librerías para consumir el Método Web remoto
    hacia nuestro SOAP / WSDL.

    File > New > Web Service Cliente

    >> http://localhost:8080/WebappHelloJAXWS/HelloWS?wsdl

    * Nos generará el paquete com.example.ws con los archivos
      de Java para consumir el Web Service mediante RMI.

    Los archivos generados más importantes son:

    - `HelloWebService.java` que contiene
      la interfaz para consumir los Métodos Web
    - `HelloWebServiceProxy` que contiene
      la implementación de la interfaz para consumir los Métodos Web
      usando RMI (Remote Method Invoke)

    ---

    Podemos crear un cliente remoto que consuma los Métodos Web
    generando código de Java mediante el WSDL descrito.
    Y usando el Web Service implementado por Proxy RMI.

```java
package com.example.test;

import java.rmi.RemoteException;

import com.example.ws.Greeting;
import com.example.ws.HelloWebService;
import com.example.ws.HelloWebServiceProxy;

// Creamos una aplicación de escritorio
public class HelloWebServiceTest {

	// Creamos el punto de entrada principal de esta prueba
	public static void main(String[] args) {
		
		HelloWebService helloWebService = new HelloWebServiceProxy();
		
		try {
			Greeting greeting = helloWebService.sayHello("Pepe el Toro");
			
			System.out.println(greeting.getTitle());
		} catch (RemoteException e) {
			System.out.println("Error al consumir el método web: " + e.getMessage());
		}
		
	}
	
}
```