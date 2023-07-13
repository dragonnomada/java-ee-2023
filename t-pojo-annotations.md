# Clases POJO y las Anotaciones

Las clases *POJO* (Plain-Old Java Objects) son clases simples, es decir, clases
usadas para preservar datos (como la capa DTO de modelo transaccional) y no para resolver tareas. A estas clases se les suelen llamar: `Clase Modelo`, `Clase Entidad` o `Clase DTO` (DTO - Data Transactional Object).

    Si queremos preservar los datos de una Fruta, 
    podríamos definir una clase POJO

```java
// POJO -> Modelo, Entidad, DTO
class Fruta {

    // Propiedades
    // El nivel de acceso es privado, para que no estén
    // expuestas a ser modificadas desde afuera
    private String nombre;
    private Double precio; // Nota: Que usamos el número tipo Clase

    // Getters | Setters

    // Expone un valor computado a partir de las propiedades internas
    // Para dar una sensación de "lectura" sobre la propiedad
    public String getNombre() {
        return nombre;
    }
    // Expone un método que actualiza el nombre,
    // si lo omitimos quitaríamos la sensació de "escritura" sobre la propiedad
    public void setNombre(String nombre) {
        this.nombre = nombre;
        // this.nombre -> Referencia interna a la propiedad de la clase
        // nombre -> Referencia al parámetro del método actual
        // nombre = nombre -> Absurdo (Ambigüedad entre this.nombre y nombre)
        // this.nombre = nombre -> Desambiguo
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    // Generamos una propiedad computada
    // que no necesariamente expone los datos literales
    // sino que los adapta a una necesidad.
    // Por ejemplo, un sistema de ventas podría
    // requerir objetos que tengan el método `public String getDescripcion();`
    public String getDescripcion() {
        // Computamos el valor resultante
        return String.format("%s $%.2f", nombre, precio);
    }

    // Las convenciones de nombrado son:
    // - PascalCase: Comienza con mayúscula y alterna a minúsculas
    //               en los cambios de palabra nuevamente mayúscula inicial
    // - camelCase: Comienza con minúscula y alterna a minúsculas
    //               en los cambios de palabra nuevamente mayúscula inicial
    // - SNAKE_CASE_UPPER: Todo es mayúculas y guiones bajos (_) en
    //               en los cambios de palabra
    //
    // Las clases se convienen en PascalCase
    // Las variables, propiedades, getters/setters y métodos son en camelCase 
    // Enumeraciones y constantes son en SNAKE_CASE_UPPER

}
```

Las anotaciones son clases que adaptan/configuran/modifican/decoran las clases POJO, para brindarles nuevas características, auto-configurarlas, hacer marcados o anotaciones y demás. Permitiendo así, usar las clases normales, como objetos sofisticados en ecosistemas más amplios que solo el lenguaje Java, por ejemplo, Hibernate, Spring Boot, Java EE, etc. Adaptando así su uso para *frameworks* o ecosistemas operativos.

> **Ejemplo de una clase adaptada a XML**

```java
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement("fruta") // <fruta> ... </fruta>
public class Fruta {
    
    private String nombre;
    private Double precio;

    @XmlElement // <fruta> <nombre> ... </nombre> ... </fruta>
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlAttribute // <fruta precio="..."> <nombre> ... </nombre> ... </fruta>
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    @XmlTransient
    public String getDescripcion() {
        return String.format("%s $%.2f", nombre, precio);
    }

}
```

> **Ejemplo de una clase adaptada a JPA (Java Persistence API)**

```java
@Entity
@Table(name="frutas")
public class Fruta {
    
    @Id
    private Long id;
    private String nombre;
    private Double precio;

    // ...
    @Column(name="name")
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Column(name="price")
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    // ...

}
```
