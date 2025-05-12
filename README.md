# XLSX Min Finder (Spring Boot)

## Описание
Приложение на Spring Boot принимает GET-запрос с параметром `path` на Excel-файл (`.xlsx`), читает столбец целых чисел и возвращает минимальное значение

## Зависимости
- Java 17+
- Maven
- Spring Boot 3.4.2
- Springdoc-openapi-starter-webmvc-ui 2.8.6 (Swagger UI)
- Apache POI
- Lombok

## Сборка и запуск
1. Клонируйте репозиторий и перейдите в каталог проекта (или откройте скачанный файл `.jar`)
2. Соберите проект:
   ```bash
   mvn clean package
3. Запустите проект:
   ```bash
   java -jar target/readFromFileMinNumber-1.0-SNAPSHOT.jar
4. В браузере указываем путь к Swagger: `http://localhost:8086/swagger-ui/index.html#/`
5. В поле path указываем путь к файлу: `C:\Users\Ivan\IdeaProjects\readFromFileMinNumber\numbers.xlsx` (укажи свой путь!)
6. Метод возвратит минимальное число -55
