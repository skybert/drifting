
# A web application made while studying various JEE technologies

The web application was set out to utilise technologies and techniques
like:

## Serious Java EE stuff
- Conversation scope
- JMS

## EJBs
- Securing method calls

## CDI
- Own annotations
- (x) Interceptor
- Alternatives
- Decorators

## Persistence
- (x) JPA
- (x) Enums
- (x) MySQL
- In-memory database for interactive and automatic testing.

## UI
- Rich Faces
- JSF
- JSF templates
- JSF Validators
- (x) JSF Converters
- Resource bundles, language, strings.
- Securing the web application
- Navigation from one XHTML to another

## Web services
- JAX-RS

## Testing
- (x) Unit testing with Arquillian
- Automatic testing with Drone
- Automatic testing with Selenium
- Unit testing with an in-memory database

## Problems & solutions

> Caused by: org.jboss.weld.exceptions.DeploymentException: WELD-001408
> Unsatisfied dependencies for type [IndianService] with qualifiers
> [@Named] at injection point [[field] @Inject @Named
> net.skybert.model.IndianEntry.service]

Because I had the second ```@Named``` here:
```
@Model
public class IndianEntry implements Serializable
{
  @Named @Produces private Indian indian = new Indian();
  @Named @Inject IndianService service;
}
```
Why?

----

> javax.ejb.EJBException: java.lang.IllegalArgumentException:
> org.hibernate.hql.internal.ast.QuerySyntaxException: indian is not
> mapped [select i from indian i]

Because of I had a lower case "indian" in the query (!) Capitalising
it solved the problem:

```
TypedQuery<Indian> query = entityManager.createQuery( "select i
from indian i", Indian.class);
```
----

> Caused by: org.jboss.weld.exceptions.DefinitionException: WELD-000068
> Method Producer Method [List<Tribe>] with qualifiers
> [@Any @Tribes @Named] declared as [[method] @Logged @Produces @Tribes
> @Named public net.skybert.ejb.IndianServiceImpl.allTribes()] must be
> declared on a business interface of Session bean
> [class net.skybert.ejb.IndianServiceImpl with qualifiers [@Any @Default];
> local interfaces are [IndianService]

I had declared the method in the impl class (the EJB), but not in the
interface (the Local interface).

---

> javax.servlet.ServletException: HV000030: No validator could be
> found for type: java.lang.Integer.
> javax.faces.webapp.FacesServlet.service(FacesServlet.java:606)


----
When you have @Produces on a method bean, the return type in that
class must be unique within the class.

---

> Caused by: java.lang.IllegalArgumentException: Named query not found: select i from Indian i where i.tribe.name = :tribeName
>   at org.hibernate.ejb.AbstractEntityManagerImpl.createNamedQuery(AbstractEntityManagerImpl.java:665) [hibernate-entitymanager-4.2.7.SP1-redhat-3.jar:4.2.7.SP1-redhat-3]
>   at org.jboss.as.jpa.container.AbstractEntityManager.createNamedQuery(AbstractEntityManager.java:79) [jboss-as-jpa-7.3.0.Final-redhat-14.jar:7.3.0.Final-redhat-14]
>   at net.skybert.ejb.IndianServiceImpl.getIndiansByTribeName(IndianServiceImpl.java:89) [classes:]

I did:
    TypedQuery<Tribe> query = entityManager.createNamedQuery("...");
instead of:
    TypedQuery<Tribe> query = entityManager.createQuery("....");
