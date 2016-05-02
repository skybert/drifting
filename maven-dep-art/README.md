## Maven project to illustrate BOM dependency management

- the dependencies are defined in a root sub module
- you can make changes in the dependency sub module and make use of this
  without needing to install it
- other projects may use the `dep-art` artifact to get the same
  dependencies and versions of these as `maven-dep-art` are using.

```
maven-dep-art/pom.xml           ← root POM
maven-dep-art/dep-art/pom.xml   ← defines all dependencies
maven-dep-art/core/pom.xml      ← uses dependencies defined in dep-art
```
