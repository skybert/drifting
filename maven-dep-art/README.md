## Maven project to illustrate BOM dependency management

- the dependencies are defined in a root sub module, `deb-art` is a
  sub module of the root POM, just as the `core` module is.
- you can make changes in the `deb-art` dependency sub module and make
  use of this without needing to install it.
- `core` module is using dependencies from its sibling, `deb-art`
  without needing `deb-art` to be available in the local repository.
- other projects may use the `dep-art` artifact to get the same
  dependencies and versions of these as `maven-dep-art` are using.

```
maven-dep-art/pom.xml           ← root POM
maven-dep-art/dep-art/pom.xml   ← defines all dependencies
maven-dep-art/core/pom.xml      ← uses dependencies defined in dep-art
```
