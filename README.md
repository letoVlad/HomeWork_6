Что означает аннотация  Before?
Аннотация Before - указывает, что метод должен будет выполнится перед каждым тестовым методом.

Как в тесте проверить, что метод должен бросить исключение?
assertThrows(ExpectedException.class, () -> methodToTest());

Что такое mock? Spy?
Mock - полностью искусственный объект, созданный для имитации поведения реального объекта. Независит от реального объекта. Реальные методы никогда не вызываются.
Spy - частично замаскированный объект, который оборачивается реальный объект.
Реальные методы вызываются, если поведение не замокировано. Если замокированно, то выполняется замена как в моке. Полезен, когда нужно тестировать реальное поведение объекта, но с возможностью подменые некоторых его методов.

Для чего применяется статический метод  Mockito.verify?
Mock.verify() используется. для проверки взаимодействия с мок-объектами в тестах. Он позволяет убедиться, что нужный метод был вызва на моке с нужными аргументами и нужное колличество раз