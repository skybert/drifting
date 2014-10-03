
# A web application made while studying various JEE technologies

The web application was set out to utilise technologies and techniques
like:

## Serious Java EE stuff
- Conversation scope
- EJBs
- JMS

## CDI
- Own annotations
- (x) Interceptor
- Alternatives
- Decorators

## Persistence
- JPA
- (x) MySQL
- In-memory database for interactive and automatic testing.

## UI
- Rich Faces
- JSF
- JSF templates
- JSF Validators
- JSF Converters

## Web services
- JAX-RS

## Testing
- Unit testing with Arquillian
- Automatic stating with Selenium

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
