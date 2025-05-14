# finderFromFileNthMinNumber (Spring Boot)

## Описание

Приложение на Spring Boot принимает GET-запрос с параметром `path` на Excel-файл (`.xlsx`), читает файл и возвращает
N-ное минимальное число из данного файла

## Зависимости

- Java 17+
- Maven 4.0.0
- Spring Boot 3.4.2
- Springdoc 2.8.6 (+Swagger UI)
- Apache POI 5.4.1
- Lombok 1.18.38

## Сборка и запуск

1. Клонируйте репозиторий и перейдите в каталог проекта (или откройте скачанный файл `.jar`)
2. Соберите проект:
   ```bash
   mvn clean package
3. Запустите проект:
   ```bash
   java -jar target/readFromFileMinNumber-1.0-SNAPSHOT.jar
4. В браузере указываем путь к Swagger: `http://localhost:8086/swagger-ui/index.html#/`
5. В поле "path" указываем путь к файлу: `C:\Users\Ivan\IdeaProjects\readFromFileMinNumber\numbers.xlsx` (укажи свой
   путь!)
6. В поле "n" указываем от 1 до 10 (т.к. в файле по дефолту 10 чисел)  
7. Метод возвратит N-ное минимальное число (Пример: если указать 4, получим 2)