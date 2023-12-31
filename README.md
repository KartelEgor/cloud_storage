# Облачное хранилище
Cервис, предоставляющий интерфейс для хранения данных пользователя.
# Запуск
Порт по умолчанию: 5500. 
Можно переопределить в файле application.properties.

В файле application.properties необходимо задать параметры подключения к базе данных:
    
    1 spring.datasource.url=jdbc:postgresql://localhost:5432/cloud_storage
    2 spring.datasource.username=postgres
    3 spring.datasource.password=postgres
    4 spring.jpa.hibernate.ddl-auto=validate
    
В папке приложения resources содержится файл schema.sql, описывающий таблицы базы данных для корректной работы.

Для корректной аутентификации в таблице users у значения колонки password должен быть префикс {noop}.

Для запуска можно использовать комануд "java -jar имя jar файла"

# Описание
Сервис предоставляет следующие endpoints:
    
    1 /login - аутентификация пользователя. 
        Все последующие запросы выполняются с помощю полученного token. Метод Post.
        Пример тела запроса:
        {
            "login": "user@gmail.com",
            "password": "123"
        }
        Тело ответа:
        {
            "auth-token": "8ac78c8a-10a3-45a7-826c-e3774de04f35"
        }
    2 /logout - выход из приложения. Метод Post.
    3 /ping - проверка доступности сервиса. Метод Get.
    4 /file загрузка файла в облачное хранилище. 
        В заголовках должен присутствовать заголовок auth-token. Метод Post.
        Пример заголовка: auth-token - Bearer 01599b79-bc6e-438d-a534-9aeefea5e422
        В теле запроса файл multipart form data
    5 /list - Возвращает список файлов пользователя. Метод Get.
        Пример ответа:
        [
            {
                "size": 9826,
                "filename": "proguard-snippets.png"
            }
        ]
    6 /file - загрузка файла из хранилища. Метод Get.
        В строке запросаа должен быть параметр filename с именем получаемого файла.
    7 /file - изменение файла в хранилище. Метод Put.
        В строке запросаа должен быть параметр filename с именем изменяемого файла.
        В теле должно быть новое имя файла:
        {
        "filename": "proguard-snippets.png"
        }
    8 /file - удление файла в хранилище. Метод Delete.
        В строке запросаа должен быть параметр filename с именем удаляемого файла.
