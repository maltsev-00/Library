# Library
База данных - mongoDb 

Cluster - нету, использовал локальную бд 

Topic kafka - test, или использовать уже созданный

Во всех запросах необходима авторизация через Basic Auth(в бд уже будет создан пользователь, логин:admin пароль:admin , после компиляции )

Функции:
1) Вывод всех книг    
2) Вывод всех свободных книг 
3) Поиск книг по автору
4) Поиск по жанру 
5) Поиск по языку на котором написана книга, выводится информация о доступности книги, есть ли доступ для резервирования или нет
6) Сделать резервирование книги(проверка  на не больше 5 книг текущему юзеру, есть ли  такая книга в бд и если книга уже взята )
7) Отмена резерва
8) Продление резерва
9) Удалить все резервы у которых истек срок действия  
10)Админ может регистрировать новых пользователей 

Пример Json резервации для тестирования 
{
    "id": "баста#",
    "user": {
        "_id": {
            "$numberLong": "1"
        },
        "name": "admin",
        "password": "admin"
    },
    "book": {
        "name": "баста",
        "authors": [{
            "name": "баста"
        }],
        "publisher": "qw",
        "year": "2020",
        "translators": ["Ru", "By"],
        "description": "О книге Q ",
        "genre": ["Реали"]
    },
    "dateReserved": "2021-01-22"
}





