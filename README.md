# News BDUI Android

[![Static Badge](https://img.shields.io/badge/divkit-orange)](https://github.com/divkit/divkit) [![Static Badge](https://img.shields.io/badge/ktor-gray)](https://ktor.io) [![Static Badge](https://img.shields.io/badge/kodein-purple)](https://kodein.net/oss.html) [![Static Badge](https://img.shields.io/badge/glide-blue)](https://github.com/bumptech/glide) [![Static Badge](https://img.shields.io/badge/coroutines-red)](https://kotlinlang.org/docs/coroutines-overview.html) [![Static Badge](https://img.shields.io/badge/android_fragments-green)](https://developer.android.com/guide/fragments)

## Описание проекта

News-BDUI-Android — это Android-приложение для просмотра новостей, разработанное с использованием подхода Backend-driven UI (BDUI). Приложение демонстрирует преимущества использования BDUI в мобильной разработке, где сервер управляет не только данными, но и версткой и дизайном интерфейса.

## Связь с другими проектами

Данный проект является частью [исследования](https://www.hse.ru/ba/se/students/diplomas/924182125) по использованию Backend-driven UI совместно с Kotlin Multiplatform в мобильной разработке и связан со следующими проектами:

- [News-BDUI-iOS](https://github.com/Pie-Roman/News-BDUI-Ios): iOS-версия приложения с использованием BDUI
- [News-BDUI-KMP](https://github.com/Pie-Roman/News-BDUI-KMP): Версия приложения с использованием Kotlin Multiplatform и BDUI
- [News-BDUI-Server](https://github.com/Pie-Roman/News-BDUI-Server): BDUI сервер для управления UI и данными

## Преимущества подхода BDUI

- Сокращение объема кодовой базы на клиентской стороне
- Ускорение релизного цикла за счет возможности обновления UI без обновления приложения
- Единообразие UI на разных платформах
- Снижение затрат на разработку и поддержку

## Архитектура

Приложение построено с использованием многослойной архитектуры:

### Слои приложения:
1. **Presentation Layer (Слой представления)**
   - Отвечает за отображение информации и взаимодействие с пользователем
   - Включает UI компоненты и презентеры

2. **Domain Layer (Слой бизнес-логики)**
   - Содержит бизнес-правила и логику приложения
   - Включает use cases и интерфейсы репозиториев

3. **Data Layer (Слой данных)**
   - Отвечает за работу с данными (сетевые запросы, кэширование)
   - Включает реализации репозиториев и источники данных

### Ключевые модули:
- **divkit-domain**: Модуль для определения контрактов взаимодействия с BDUI сервером
- **divkit-data**: Модуль для обработки данных, получаемых от BDUI сервера
- **divkit-feature**: Модуль для отображения UI компонентов, полученных от BDUI сервера
- **search-domain**: Модуль для логики поиска новостей
- **search-data**: Модуль для обработки данных поиска
- **search-feature**: Модуль для реализации UI поисковой строки (нативная реализация)

## Функциональность

Приложение предоставляет следующие возможности:

1. **Просмотр последних новостей**
   - Вертикальный список карточек новостей
   - Данные получаются через BDUI сервер из API сервиса NewsData.io

2. **Поиск новостей**
   - Текстовое поле для ввода поискового запроса
   - Автоматический поиск через 0.5 секунды после последнего введенного символа
   - Отображение результатов поиска в виде вертикального списка карточек новостей

3. **Навигация между разделами**
   - Таббар с двумя вкладками: "Последние новости" и "Поиск"
   - Сохранение состояния вкладок при переключении

## Технологии и библиотеки

- **Kotlin**: Основной язык программирования
- **DivKit**: Библиотека для реализации Backend-driven UI
- **Retrofit**: Для сетевых запросов
- **Dagger/Hilt**: Для внедрения зависимостей
- **Coroutines**: Для асинхронного программирования
- **Jetpack Components**: LiveData, ViewModel, Navigation

## Установка и запуск

1. Клонировать репозиторий:
```
git clone https://github.com/Pie-Roman/News-BDUI-Android.git
```

2. Открыть проект в Android Studio

3. Запустить BDUI сервер (см. репозиторий [News-BDUI-Server](https://github.com/Pie-Roman/News-BDUI-Server))

4. Запустить приложение на эмуляторе или физическом устройстве

