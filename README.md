# contacts_api
**Бекенд для хранилища контактов**
## Реализованные функции
* Добавление контактов
* Удаление контактов
* Просмотр всех и отфильрованных контактов
## Структура базы данных
### Таблица Contacts
```
+---------+--------------+------+-----+---------+----------------+
| Field   | Type         | Null | Key | Default | Extra          |
+---------+--------------+------+-----+---------+----------------+
| id      | int          | NO   | PRI | NULL    | auto_increment |
| name    | varchar(30)  | YES  |     | NULL    |                |
| surname | varchar(50)  | YES  |     | NULL    |                |
| phone   | varchar(20)  | YES  |     | NULL    |                |
| address | varchar(255) | YES  |     | NULL    |                |
+---------+--------------+------+-----+---------+----------------+
```
## Цели
* Возможность изменения контактов
* Модернизирование структуры таблицы и возможность добавления дополнительной информации (доп. номера, дни рождения, etc)
