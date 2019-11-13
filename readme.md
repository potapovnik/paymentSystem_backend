**Приложение платёжная система**

1. Скачать проект с github
2. Открыть в IDE
3. Запустить AppRun по пути: controllers\src\main\java\cinimex\AppRun.java
Заметка:
    можно собрать проект в jar запустив в папке controllers команду mvn clean install
    (Упаковать клиент в отдельный исполняемый файл не удалось)

Пользователи создающиеся для приложения:
admin - имеет роль администратор
user1,user2 - роль юзер(обычный пользователь)
tele2, beeline - роль юзер, а такжее имеет в системе свои услуги, оплата которых пополняет балансы данных пользователей
Пароль для всех пользователей: **qwe**

Для настройки времени сесси менять значение в security\src\main\resources\application.yml

Замечания:
1. Т.к. в тз не было указаний по поводу карт, то данные по ним приходят на сервер, но никак не обрабатываются.

2. Удаление пользователя не удаляет действительно его из системы,
т.к. это так или иначе приведёт к потере данных связанных с данным юзером и
далее невозможно будет восстановить всю картину произошедшего.
В связи с этим пользователь помечается как удалённый и администратор не получает его в списке для редаектирования.
Баланс удалённого пользователя блокируется.



