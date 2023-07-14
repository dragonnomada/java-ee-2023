# Servicios RESTful de JAX-RS

JAX-RS (Java API for RESTful Service) nos permite crear controlares tipo REST (que implementan los métodos HTTP tipo GET, POST, PUT, PATCH, DELETE, etc.) para crear *ENDPOINTs* donde los clientes puedan ejecutar operaciones directas.

> **VENTAJAS**

- Cada operación está representada por un *endpoint* y puede ser versionada (`/api/frutas` o `/api/1.1/frutas`). Por ejemplo, en la versión `1.0` o la natural podríamos agregar nuevos elementos generando la versión `1.1` sin que deje de funcionar la versión (**versonamiento por mejora o adición**), pero si cambiamos físicamente valores de entrada o de salida requeridos, por ejemplo, antes se recibian los parámetros (`minPrecio` y `maxPrecio`) opcionales, pero ahora son obligatorios y la versión anterior puede seguir operando (**versionamiento de corrección floja**) y si cambiamos físicamente los valores de entrada o salida requeridos y opcionales, por ejemplo, antes se recibian los parámetros (`minPrecio` y `maxPrecio`) pero ahora se reciben (`precioLow`, `precioHigh`, `precioUpper`, `precioDown`) y la vesión anterior debería dejar de usarse en algún tiempo (**versionamiento de corrección fuerte**) y si la versión anterior se corrige involucrando seguridad, rendimiento o falla, y la versión anterior deba dejar de usarse inmediatamente (**versionamiento de corrección obligada o de baja inmediata**), por ejemplo si antes no se recibe un token para una transacción y ahora se obliga al usuario usar una llave para consumir la operación.
- Podemos recuperar y enviar rápidamente datos en diferentes tipos (`Mime-Type`), por ejemplo, podríamos recibir parámetros de texto (`@QueryParam`) o consumir y producir modelos de datos basados en XML o JSON o generar interfaces de TEXTO o HTML o devolver plantillas JSP o JSF.
- El modelo de `JAX-JS` consiste en una clase de Java anotada para controlar una ruta (*endpoint*) específica y sus métodos soportados como sub-rutas. Es decir, una clase de Java podría representar un controllar de un conjunto de rutas (*endpoints*) en distintos métodos HTTP (GET, POST, PUT, PATCH, etc).
- Puede acceder al Servlet y la petición cruda, para acceder al *stream* de archivos que se están enviando al servidor, es decir, controlar la carga de archivo hacia el servidor y también la descarga.

> **DESVENTAJAS**

- Estamos obligados a recordar cada ruta final (*endpoint*), el método *HTTP*, los parámetros que recibe y el resultado que devuelve. Por ejemplo, si tenemos un API de facturación en tres etapas: `definición de la factura`, `configuración de conceptos e impuestos`, `timbrado`. Necesitariamos recordar tres rutas (*endpoints*), como, `POST /api/factura/new` (recibe un `XML` con la definición de la factura: RFC cliente, RFC proveedor, Dirección, etc.), `PATCH /api/factura/{UUID}/conceptos` (recibe un `JSON` que tenga los conceptos y sus impuestos, y si los impuestos no están habilitados claves para deshabilitarlos) y `PUT /api/factura/{UUI}/timbrar` (recibe un parámetro sobre la URL llamado `apiKey` o recibir los archivos `PUB` y `KEY`).
- La traducción entre entidades podría obligarnos a mezclar HTML, XML, JSON y otros tipos de recursos, por lo que nuestras API podrían no ser uniformes. No hay estándares para las entradas y las salidas, por lo que no es un sistema auto-explorable, lo que requiere tener la documentación presente todo el tiempo.

> **Ejemplo del activador de JAX-RS**

```java
@ApplicationPath("/api")
public class SampleApplication extends Application {
    
}
```

> **Ejemplo de un controlador de JAX-RS**

```java
@Path("/sample")
public class SampleRest {

    @GET
    @Produces("text/plain") // MediaType.TEXT_PLAIN
    public String status() {
        return "Ok - It is working...";
    }

    @GET
    @Produces("text/html") // MediaType.TEXT_HTML
    @Path("/html")
    public String sampleHTML() {
        return "<h1 style='color:red;'>Hello sample HTML</h1>";
    }

    @GET
    @Produces("application/xml") // MediaType.APPLICATION_XML
    @Path("/xml")
    public Fruta sampleXML() {
        Fruta fruta = new Fruta();
        fruta.nombre("manzana");
        // ...
        return fruta;
    }

    @POST
    @Consumes("application/xml") // MediaType.APPLICATION_XML
    @Produces("text/html") // MediaType.APPLICATION_XML
    @Path("/fruta/view")
    public String viewFruta(Fruta fruta) { // BODY: <fruta>...</fruta>
        String html = "<div>";
        html += "<h1>" + fruta.getNombre() + "</h1>";
        html += "<h2>" + String.format("$%.2f", fruta.getPrecio()) + "</h2>";
        html += "<div>";
        return html;
    }

    @PUT
    @Consumes("application/xml") // MediaType.APPLICATION_XML
    @Produces("text/plain") // MediaType.APPLICATION_XML
    @Path("/fruta/create")
    public String createFruta(Fruta fruta) { // BODY: <fruta>...</fruta>
        // TODO: Llamamos al servicio de frutas para que guarde la fruta
        // ... frutaService.addFruta(fruta)
        return "ok | fail";
    }

}
```

Las API tipo RESTful están diseñadas para ser una carátula con el cliente o usuario. Es decir, un cliente necesita mandar a llamar a una ruta (*endpoint*) y recibir los resultados, ya sean XML, JSON o HTML. Por lo que los controladores sólo deberían hacer la parte de recepción y presentación de los datos para consumir los servicios internos (*Java Beans*).

> **Ejemplo de un controlador que recibe los parámetros para buscar las frutas en un rango de precios**

```java
@GET
@Path("/frutas/searchByPrice")
public List<Fruta> searchByPrice(@Query("minPrice") String minPriceText, 
@Query("maxPrice") String maxPriceText) {
    // Reglas de validación para sanamiento de datos (rectificación de datos)
    double minPrice = 0;
    double maxPrice = Double.MAX_VALUE;

    try {
        if (minPriceText != null) {
            minPrice = Double.parseDouble(minPriceText);
        }
    } catch (Exception e) {
        logger.warning("Error al convertir el mínimo precio: " + e.getMessage());
    }

    // Similar para maxPriceText a maxPrice

    // La lógica de negocio (no confundir con las reglas de validación)
    // es recomendable que sea absorbida por los servicios que hacen las operaciones finales
    // ya que estos buscarán las mejores estrategias y estarán optimizados
    // a parte que podremos sustir su funcionalidad del lado del servicio
    // sin afectar el lado del API.
    // Por ejemplo, el servicio cambió de MySQL a Oracle y la interfaz del API
    // no fue afectada (ni siquiera supo) porque esa lógica no está de este lado.
    // Por lo que el mantimiento a largo plazo será más barato.
    return frutaService.getAllInPriceRange(minPrice, maxPrecio);
}
```

## Construcción de Servicios Inyectables (Java Beans | Enterprise Java Beans (EJB))

Java Beans permiten crear instancias de clases que sean auto-administradas e inyectables.

> Una instancia (referencia de objeto a una clase) es un objeto que vive en la memoria *heap*
> y que es capaz de retener datos independientes a otros objetos.

```java
Fruta fruta1 = new Fruta(); // Creamos una instancia y la referenciamos a fruta1

fruta1.setId(1);
fruta1.setNombre("manzana");
// ...

Fruta fruta2 = new Fruta(); // Creamos una instancia y la referenciamos a fruta2

fruta2.setId(2);
fruta2.setNombre("pera");
// ...
```

Dos instancias apuntan a memorias diferentes, por lo que, aunque tengan los mismos valores ocuparán memoria independiente para cada una. Esto significa, que muchas instancias podrían saturar nuestra memoria si nunca las dejamos de usar durante la aplicación.

El ciclo de vida de una instancia no se puede controlar, ya que una instancia se puede propagar fácilmente sin que nos demos cuenta, por ejemplo, cuándo una instancia es llevada de un método a otro, se crea otra copia de esa instancia (ambas apuntan a la misma memoria), pero son dos referencias distintas a la misma memoria, haciendo que el ciclo de vida para una instancia se alargue más de los que pensamos. Mientras algún método tenga una copia de la referencia, y el método siga vivo, la instancia seguirá viva, es decir, su ciclo de vida se podría prolongar más allá de lo que necesitamos, acumulando a la larga mucha más memoria de la que soportamos.

La solución al problema de instanciar (crear instancias) manualmente, es anotar a la clase ante el contenedor para que él administre la instancia y no nosotros. De esta manera, según la anotación se deberá respetar el ciclo de vida que hayamos diseñado. Por ejemplo, lo que dura una petición, una sesión o la misma aplicación.

Cualquier clase POJO puede ser anotada para auto-instanciarse (ser auto-administrada por el contenedor). Generalmente a los *Beans* (las clases anotadas para auto-instanciarse) los veremos como servicios que proveen lógica y funcionalidad a otros componentes como, *WebServlet*, *JAX-RS* o *JAX-WS* (principalmente).

> **Ejemplo para crear un servicio que esté disponible en otros componentes**

```java
@ManagedBean   // Marcado como Bean 
               // (existen otros como @Named, @Stateless, @Stateful, @Singleton, etc.)
@RequestScoped // Ciclo de Vida - La duración entre la creación y liberación del Bean
               // En este caso durará lo que dure una petición de WebServlet, JAX-RS o JAX-WS
               // (existen otros @ViewScoped, @SessionScoped, @ApplicationScoped)
public class HelloService {

    public String currentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("(DDD) dd, MM yyyy");
        return formatter.format(new Date());
    }

}
```

**IMPORTANTE:** Intenta poner todas tus clases públicas al menos que no sean usadas por los contenedores (*Web Container* o *EJB Container*). 

Haciendo las anotaciones a la clase `HelloService`, este se comportará como un *Bean* permitiendo que sus instancias se auto-administren por el contenedor, cuándo hagan falta.

Es decir, que ahora `HelloService` puede ser inyectado (mediante CDI / Dependency Injection) en componentes como `HelloRest`, `HelloWebService` o algún otro componente del contenedor.

> La Inyección de Dependencias sirve para que un componente o un *Bean* recupere/cree la instancia de otro *Bean*. Por ejemplo, que un API REST inyecte un servicio, cómo, `HelloRest` inyecta a  `HelloService` porque lo necesita.

> **Ejemplo de inyección de `HelloService` en `HelloRest`**

```java
@Path("/hello")
@RequestScoped
public class HelloRest {

    @Inject
    HelloServicio helloService; // helloService es la instancia inyectada del *Bean* HelloService
                                // La inyección podría recuperar una referencia que viva
                                // durante toda la aplicación (@ApplicationScoped) o
                                // podría crear en ese momento una instancia que viva
                                // mientras dura la petición (@GET, @POST, @PUT, ...).
    @GET
    @Produces("text/html")
    public String hello() {
        // Los servicios ocultan las partes sensibles del negocio como
        // reglas de validación, accesos a las bases de datos,
        // las consultas a la base de datos o código complejo
        // que anide mucha lógica compleja u operaciones delicadas.
        String date = helloService.currentDate();
        return "<br><br><br><center><h1>" + date + "<h1></center>";
    }

}
```

**NOTA:** Al API RESTful le indicamos también que se comporte con cierto ciclo de vida, en este caso lo que dura una petición (`@RequestScoped`).

> **Ejemplo de inyección de `HelloService` en `HelloRest`**

```java
@WebService(serviceName="HelloWS")
public class HelloWebService {

    @Inject
    HelloServicio helloService; // helloService es la instancia inyectada del *Bean* HelloService
                                // La inyección podría recuperar una referencia que viva
                                // durante toda la aplicación (@ApplicationScoped) o
                                // podría crear en ese momento una instancia que viva
                                // mientras dura la petición (@GET, @POST, @PUT, ...).
    @WebMethod
    public String currentDate() {
        return helloService.currentDate();
    }

}
```