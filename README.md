# VotingSystem

Design and implement a JSON API using Hibernate/Spring/SpringMVC without frontend.

### <a href="https://gist.github.com/juozapas/f20b55e4568d7f5c63b1">Тестовое задание</a>

## Install:

    git clone https://github.com/vladkucher/VotingSystem

## Run (from project directory)

    mvn install org.codehaus.cargo:cargo-maven2-plugin:1.5.0:run

## Users

        User login: user@yandex.ru
          password: password
     Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=

       Admin login: admin@gmail.com
          password: admin
     Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu
          
### User handling

CURL:

Access allowed for Admin

    curl http://localhost:8080/votingsystem/api/admin/users -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
    curl http://localhost:8080/votingsystem/api/admin/users/0 -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
    curl http://localhost:8080/votingsystem/api/admin/users/by?email=admin@gmail.com -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
    curl http://localhost:8080/votingsystem/api/admin/users -i -d'{"name" : "NewUser", "email" : "new@mail.ru","password" : "123456","roles" : ["ROLE_USER"]}' -H'Content-Type: application/json' -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'

Access allowed for User

    curl http://localhost:8080/votingsystem/api/profile -i -H'Authorization:Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='
    curl -X PUT http://localhost:8080/votingsystem/api/profile -i -d'{"name" : "NewUser", "email" : "new@mail.ru","password" : "123456"}' -H'Content-Type: application/json' -H'Authorization:Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='
    curl -X DELETE http://localhost:8080/votingsystem/api/profile -H'Authorization:Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='
     
### Restorant handling

CURL:

Access allowed for Admin

    curl http://localhost:8080/votingsystem/api/admin/restaurants -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
    curl http://localhost:8080/votingsystem/api/admin/restaurants/0 -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
    curl http://localhost:8080/votingsystem/api/admin/restaurants -i -d'{"name" : "newRestaurant"}' -H'Content-Type: application/json' -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
    curl -X PUT http://localhost:8080/votingsystem/api/admin/restaurants/0 -i -d'{"id" : 0, "name" : "newName"}' -H'Content-Type: application/json' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
    curl -X DELETE http://localhost:8080/votingsystem/api/admin/restaurants/1 -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
     
Access allowed for User

    curl http://localhost:8080/votingsystem/api/profile/restaurants -i -H'Authorization:Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='
    curl http://localhost:8080/votingsystem/api/profile/restaurants/1 -i -H'Authorization:Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='
     
### Dish handling

CURL:     
     
Access allowed for Admin

    curl http://localhost:8080/votingsystem/api/admin/restaurants/0/dishes -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
    curl http://localhost:8080/votingsystem/api/admin/restaurants/0/dishes/4 -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
    curl http://localhost:8080/votingsystem/api/admin/restaurants/0/dishes -i -d'{"name" : "newDish", "date" : "2017-04-24", "price" : 4.55}' -H'Content-Type: application/json' -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
    curl -X PUT http://localhost:8080/votingsystem/api/admin/restaurants/0/dishes/5 -i -d'{"name" : "newName", "date" : "2017-04-24", "price" : 5.55}' -H'Content-Type: application/json' -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
    curl -X DELETE http://localhost:8080/votingsystem/api/admin/restaurants/0/dishes/5 -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
    
Access allowed for User

    curl http://localhost:8080/votingsystem/api/profile/restaurants/0/dishes -i -H'Authorization:Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='

### Dish handling

CURL:     

Vote for restaurant 0:

    curl http://localhost:8080/votingsystem/api/profile/votes/1 -i -X POST -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=' -H'Content-Type: application/json'    

Vote for restaurant 2:
    
    curl http://localhost:8080/votingsystem/api/profile/votes/2 -i -X POST -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=' -H'Content-Type: application/json'
    
Check current vote:

    curl http://localhost:8080/votingsystem/api/profile/votes -i -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='



