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

