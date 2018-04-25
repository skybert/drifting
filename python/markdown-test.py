from markdown import markdown

s="""
```java
public static void main(String args[]) {
}
```
"""

print(markdown(s, extensions=['markdown.extensions.fenced_code']))
