# Дипломный проект по профессии «Инженер по тестированию»

## Тестирование мобильного приложения «Мобильный хоспис»

[Ссылка на задание](https://github.com/netology-code/qamid-diplom)

# Документация

- [План тестирования](https://github.com/AlessioLoginov/diploma/blob/master/Plan.md)
- [Чек-лист](https://docs.google.com/spreadsheets/d/1gTjyUHkcQfmJK7_jNAA6gCGzWxkf2OGuMRAAZf1uhoo/edit?usp=sharing)
- [Тест-кейсы](https://docs.google.com/spreadsheets/d/18EOriyNmkvxDnbUzjyPIR86qTo1irk1DnD3H78v5dFk/edit?usp=sharing)
- [Отчет о тестировании](https://github.com/AlessioLoginov/diploma/blob/master/Result.md)

# Запуск приложения и тестов

### 1. Склонировать репозиторий https://github.com/AlessioLoginov/diploma с помощью команды git clone

### 2. Открытие проекта

Откройте клонированный проект в Android Studio.

### 3. Подготовка устройства для тестирования

- Запустите эмулятор или подключите физическое устройство.
- Установите язык устройства на Русский.
- Убедитесь, что на устройстве установлены следующие данные для входа в приложение:
  - **Логин**: `login2`
  - **Пароль**: `password2`

### 4. Переход в директорию проекта

Перейдите в каталог проекта `fmh_android_15_03_24`

### 5. Запуск тестов

- Запустите тесты с помощью команды в терминале: ./gradlew connectedAndroidTest
- Примечание: если возникает ошибка "zsh: permission denied: ./gradlew" то необходимо предоставить права доступа к файлу, чтобы сделать его исполняемым. В этом случае воспользуйтесь следующей командой в терминале: chmod +x ./gradlew

- Дождитесь выполнения всех тестов.

### 6. Формирование отчёта AllureReport

#### Настройка Allure

Добавьте следующую строку в файл `allure.properties` в ресурсах `androidTest` вашего проекта: allure.results.useTestStorage=true

#### Добавление зависимостей

Добавьте следующую зависимость в файл `build.gradle` вашего приложения: androidTestUtil "androidx.test:orchestrator:1.4.2"

#### Извлечение результатов

Выгрузите каталог результатов тестирования с тестируемого устройства используя `Device File Explorer` в Android Studio: /sdcard/googletest/test_outputfiles/allure-results

#### Генерация отчёта

Переместите скачанные результаты на ваш компьютер и выполните команду в терминале на уровне выше каталога с результатами: allure serve

- Дождитесь генерации отчёта и просмотрите его в автоматически открывшемся окне браузера.
