## LSP & PECS

> 要从泛型类取数据时，用extends

> 要往泛型类写数据时，用super

> 既要取又要写，就不用通配符（即extends与super都不用）

```bash
// producer-extends, consumer-super
// Get and Put Principle
/*
         如果要从集合中读取类型T的数据，并且不能写入，可以使用 ? extends 通配符；(Producer Extends)

         如果要从集合中写入类型T的数据，并且不需要读取，可以使用 ? super 通配符；(Consumer Super)

         如果既要存又要取，那么就不要使用任何通配符。
 */
```