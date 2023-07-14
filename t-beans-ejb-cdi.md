# JavaBeans (WebBeans) - Enterprise JavaBeans (EJB) - CDI

Un *JavaBean* o *bean* es una clase que ha sido anotada para que una instancia de dicha clase
sea administrada por el contenedor que la utilice.

Por ejemplo, un clase de Java provee operaciones y cálculos (reglas de negocio) sobre distintas propiedades y parámetros, y dicha clase es muy utilizada en distintos componentes. Por ejemplo, una clase de Java que accede a la base de datos y a la tabla de *contratos* y recupera los contratos no firmados del día, lo que ya están firmados, etc. Y este servicio es ocupado en varias partes de nuestro sistema, por ejemplo, en *JAX-RS* para darle al usuario los contratos del día en formato JSON o XML, también en *JAX-WS* para crear nuevos contratos o firmalos, y en JSF para mostrar los contratos en interfaces HTML.

Por lo mismo necesitamos una instancia que "viva" dentro de nuestro sistema, y no dependa de nostros, es decir, no dependa que nosotros hayamos definido esa instancia y busquemos un mecanismo para llevar la instancia de un componente (por ejemplo, desde JSF) hasta otro componente (por ejemplo, hasta JAX-RS).

Entonces, el mecanismo propuesto por Java EE para administrar las instancias auto-administradas por los contenedores (*Web Container* y *EJB Container*), se basa en anotar a una clase (o configurar un archivo llamado `beans.xml`) para que cree o guarde (administre) las instancias de los servicios (las clases de Java de utilería, cómputo de negocio y bases de datos) y las provea cuándo hagan falta en los distintos componentes.

> Podemos pensar al **bean** como **intancia + ciclo-de-vida** (recordando que es administrado por un contenedor como `Web Container` o `EJB Container`).

> **Tres tipos de Beans**

- **Web Beans de JavaServer Faces (JSF)** - Son beans provistos por `javax.faces.bean` y anotados como `@ManagedBean` con ciclo de vida anotado como `@RequestScoped` (lo que dura la petición), `@ViewScoped` (lo que dura la interacción con la página), `@SessionScoped` (lo que dura la sesión) o `@ApplicationScoped` (lo que dura la aplicación/servidor encendido)
- **Web Beans Formalizados (Web Bean estándar)** - Son beans provistos por `javax.enterprise.context` y anotados como `@ManagedBean` (no confundir con `@ManagedBean` de `javax.faces.bean`) o anotados como `@Named` con ciclo de vida anotado como `@RequestScoped` (lo que dura la petición), `@SessionScoped` (lo que dura la sesión) o `@ApplicationScoped` (lo que dura la aplicación/servidor encendido), pero no confundir con los similares de `javax.faces.bean`, sino que estos proveen del formalizado `javax.enterprise.context`.
- **EJB Beans Estandirados (EJB)** - Son beans provistos por `javax.ejb` y anotados como `@Stateless`, `@Stateful` o `@Singleton`.

## CDI (Context and Dependency Injection)

La Inyección de Dependencias es un proceso automático del Contenedor (Web Container o EJB Container), en el cual detecta las propiedades anotas con `@Inject` o `@EJB` para colocar la instancia anotada como `@ManagedBean`, `@Named`, `@Stateless`, `@Stateful`, `@Singleton`, `@Resource`, etc.

Y esto significa que en el proce de inyección se haría una equivalencia a identificar una instancia y ajustarla en un constructor.

> **Ejemplo de Inyección de Dependencias manual**

Vamos a suponer que tenemos un `ClienteService` y un `ProductoService`. Entonces, una clase llamada `VentaService` requiere una instancia de ambos servicio que sea inyectada.

```java
public class VentaService {

    ClienteService clienteService; // No tiene instancia
    ProductoService productoService; // No tiene instancia

    // NOTA: Tenemos que definir un constructor y no podremos usar el VentaService
    //       hasta que no llamemos a este constructor y conectemos los servicios
    public VentaService(ClienteService clienteService, ProductoService productoService) {
        this.clienteService = clienteService; // Ya hay instancia
        this.productoService = productoService; // Ya hay instancia
    }

    public void generarVenta() {
        Cliente cliente = clienteService.getCurrentCliente();
        List<Producto> productos = productoService.openCarrito(cliente.getId()).getProductos();

        // ... Guarda una venta para ese cliente y esos productos
    }

}
```

> **Ejemplo de un administrador de instancias que nos permita conectar los servicios**

```java
// No habría un ciclo de vida, ya que las instancias vivirían toda la aplicación
public class InstanceManager {

    public static ClienteService clienteService = new ClienteService();
    public static ProductoService productoService = new ProductoService();
    public static VentaService VentaService = new VentaService(InstanceManager.clienteService, InstanceManager.productoService);

}
```

> **Inyección de Dependencias automática**

```java
@Named
@RequestScoped // Se crea al inicio de la petición y se destruye al final
// @SessionScoped // Se crea al inicio de la sesión y se destruye al final
// @ApplicationScoped // Se crea al inicio de la aplicación y se destruye al final
public class VentaService {

    @Inject // Buscar el que implementa a ClienteService o la clase
    ClienteService clienteService;

    @Inject // Buscar al que implementa a ProductoService o la clase
    ProductoService productoService;

    public Venta generarVenta() {
        Cliente cliente = clienteService.getCurrentCliente();
        List<Producto> productos = productoService.openCarrito(cliente.getId()).getProductos();

        // ... Guarda una venta para ese cliente y esos productos
    }

}
```

> **Ejemplo de Inyección de Dependencias en otros Componentes**

```java
@WebContainer(serviceName="VentasWS")
public class VentaWebService {

    @Inject
    VentaService ventaSevice;

    @Inject
    ClienteService clienteSevice;

    @WebMethod
    public Venta generarVenta(@WebParam(name="clienteID") Long clienteId) {
        clienteService.setCurrent(clienteId);
        return ventaService.generarVenta();
    }

}
```

## Interfaces Remotas y Calificadores

En una inyección, un servicio sólo permite una implementación para ser inyectado. Por ejemplo, nosotros podríamos definir un servicio a partir de una interfaz que determine cómo debería funcionar el servicio.

> **Ejemplo de un servicio de Frutas**

```java
@Remote
public interface FrutaService {

    Fruta agregaFruta(String nombre, double precio);

    Fruta consultarFrutaPorId(long id);
    List<Fruta> consultarTodasFrutas();

    Fruta modificarFrutaNombre(long id, String nombre);
    Fruta modificarFrutaPrecio(long id, double precio);

    // ...

}
```

La interfaz define qué métodos debería tener un servicio de frutas, pero no especifica su implementación, es decir, alguien (una clase) debería implementar cómo agregar, consultar y modificar las frutas.

Entonces podemos implementar dicho servicio como un servicio local que retenga las frutas en la memoria (`LocalFrutaService`), un servicio persistente que retenga las frutas en una base de datos (`JDBFrutaService`) o podríamos implementar el servicio como un servicio remoto que mande las frutas a otro servicio remoto y él se encargue de todo (`RemoteFrutaService`).

> **Ejemplo de la implementación local de la interfaz del servicio de frutas**

```java
@Named
@ApplicationScoped
public class LocalFrutaService implements FrutaService {

    private List<Fruta> frutas = new ArrayList<Fruta>();
    private long nextId = 0;

    @Override
    public Fruta agregaFruta(String nombre, double precio) {
        Fruta fruta = new Fruta();
        fruta.setId(++nextId);
        fruta.setNombre(nombre);
        fruta.setPrecio(precio);
        frutas.add(fruta);
        return fruta;
    }

    @Override
    public Fruta consultarFrutaPorId(long id) {
        for (Fruta fruta : frutas) {
            if (fruta.getId() == id) {
                return fruta;
            }
        }
        return null;
    }
    @Override
    public List<Fruta> consultarTodasFrutas() {
        return frutas;
    }

    @Override
    public Fruta modificarFrutaNombre(long id, String nombre) {
        Fruta fruta = consultarFrutaPorId(id);
        
        if (fruta != null) {
            fruta.setNombre(nombre);
        }

        return fruta;
    }
    @Override
    public Fruta modificarFrutaPrecio(long id, double precio) {
        Fruta fruta = consultarFrutaPorId(id);
        
        if (fruta != null) {
            fruta.setPrecio(precio);
        }

        return fruta;
    }

    // ...

}
```

Al implementar un servicio de tipo interfaz, podemos inyectarlo, marcando sobre la interfaz que es un *bean* remoto, y sobre la implementación que es un *bean* tradicional.

En este punto podríamos inyectar dicho servicio en algún componente que lo requiera. Sin embargo, en todo el proyecto sólo podríamos tener una única implementación de ese servicio.

```java
@WebService(serviceName="FrutaWS")
public class FrutaWebService {

    @Inject
    FrutaService frutaService; // Interfaz (@Remote) -> Clase (@Named) -> intancia

    // ... frutaService.agregarFruta("manzana", 45.5)

}
```

El problema de tener una única implementación es no poder hacer que convivan más implementaciones distintas, por ejemplo, una implementación que use la base de datos.

```java
@Named
@ApplicationScoped
public class JDBCFrutaService implements FrutaService {

    private Connection connection;

    public JDBCFrutaService() {
        try { 
            // Conexión a la base de datos
            Class.forName("<driver>")
            connection = DriverManager.getInstance()...
        } catch (Exception e) {
            // ...
        }
    }

    @Override
    public Fruta agregaFruta(String nombre, double precio) {
       // 1. Un statement que inserte la fruta a la base de datos
       // 2. Recuperar el último id insertado
       // 3. Recuperar la fruta de ese último id y devolverlo
       return consultarFrutaPorId(insertedId);
    }

    @Override
    public Fruta consultarFrutaPorId(long id) {
        // 1. Un statemente que consulte una fruta por id en la base de datos
        // 2. Recuperar el resulSet y su primer registro (si existe)
        // 3. Reconstruir la fila del resultSet como una Fruta
        return fruta;
    }
    @Override
    public List<Fruta> consultarTodasFrutas() {
        // ... similar hacer el query a base de datos y recolectar las frutas
    }

    @Override
    public Fruta modificarFrutaNombre(long id, String nombre) {
        // query update por nombre y id
    }
    @Override
    public Fruta modificarFrutaPrecio(long id, double precio) {
        // query update por precio y id
    }

    // ...

}
```

Si implementamos la interfaz dos veces (`LocalFrutaService` y `JDBCFrutaService`) vamos a generar un conflicto de *quién* debería ser el *bean* a inyectar cuándo se solicite, debería ser de tipo `LocalFrutaService` o debería ser de tipo `JDBCService`.

Entonces necesitamos un calificador que determine quién será el ganador para ese inyección. Por lo que debemos generar una interfaz calificativa. Que permita determina la calificación o el nombre calificador en una inyección.

> **Ejemplo de un calificador que determina ser *LocalFruta* (a implementaciones *Locales*).**

```java
@Target({TYPE, METHOD, PARAMETER, FIELD})
@Retention(RUNTIME)
@Documented
@Qualifier
public @interface LocalFruta {
}
```

> **Ejemplo de un calificador que determina ser *JDBCFruta* (a implementaciones *JDBC*).**

```java
@Target({TYPE, METHOD, PARAMETER, FIELD})
@Retention(RUNTIME)
@Documented
@Qualifier
public @interface JDBCFruta {
}
```

> **Ejemplo del uso del calificador de *LocalFruta* en la implementación `LocalFrutaService`**

```java
@LocalFruta
@Named
@ApplicationScoped
public class LocalFrutaService implements FrutaService {
    ...
}
```

> **Ejemplo del uso del calificador de *JDBCFruta* en la implementación `JDBCFrutaService`**

```java
@JDBCFruta
@Named
@ApplicationScoped
public class JDBCFrutaService implements FrutaService {
    ...
}
```

A partir de ahora, bastará con decir que calificador le queremos dar a la inyección.

> **Ejemplo de uso de la inyección calificada como *LocalFruta***

```java
@WebService(serviceName="FrutaWS")
public class FrutaWebService {

    @Inject
    @LocalFruta
    FrutaService frutaService; // Interfaz (@Remote) -> Clase (@Named) -> intancia

    // ... frutaService.agregarFruta("manzana", 45.5)

}
```

> **Ejemplo de uso de la inyección calificada como *JDBCFruta***

```java
@WebService(serviceName="FrutaWS")
public class FrutaWebService {

    @Inject
    @JDBCFruta
    FrutaService frutaService; // Interfaz (@Remote) -> Clase (@Named) -> intancia

    // ... frutaService.agregarFruta("manzana", 45.5)

}
```