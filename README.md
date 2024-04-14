# Welcome to StackEdit!

Наше приложение c прицелом на мультиплатформу. Тащим только мультиплатформенные либы и желательно в которых нет кодгена.

## Стуктура
```
├── target (пакет для разных сборок приложений)
│   ├── google  (приложение для гугл стора)
│   ├── ios  (приложение для iPhone)
│   ├── huawei  (пока нет, но может будет и для huawei)
├── core (пакет для модулей с core функционалом)
│   ├── di
│   ├── decompose
│   ├── design (Compose тема, цвета,  шрифты и т.п.)
│   ├── etc
├── feature (пакет для feature модулей)
│   ├── feature1
│   │   ├── api
│   │   ├── impl
│   ├── featureN
├── compose (пакет где собираем все модули)
│   ├── android - точка входа в для андройд приложений
│   ├── ios - точка входа в для ios приложений
├── build-src (лежат  gradle convention plugins)
```

### Gradle convention plugins:
В папке build-src лежать следующие gradle convention plugins:
- android-app-setup.gradle.kts - для настройки модулей с приложениями, т.е используется в :target:google
- android-lib-setup.gradle.kts - для настройки библиотечных модулей. Используется во всех модулях
- android-compose-setup.gradle.kts - для настройки библиотечных модулей где есть compose.
- module-api-setup.gradle.kts - для настройки feature:api модулей
- module-impl-setup.gradle.kts - для настройки feature:impl модулей
- multiplatform-compose-setup.gradle.kts - для настроек мультиплатформенных модулей с compose
- multiplatform-setup.gradle.kts - для настроек мультиплатформенных модулей


### Вдохновлялся:
 - https://github.com/flipperdevices/Flipper-Android-App
 - https://github.com/IlyaGulya/TodoAppDecomposeMviKotlin


## Архитектура

Используем:
- [Decompose](https://github.com/arkivanov/Decompose)
- [orbit mvi](https://github.com/orbit-mvi/orbit-mvi)
- DI пока самописный, но может можно прикрутить либы.