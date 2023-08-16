# Scholarship RESTful API
Uma RESTful API capaz de lidar com as requisiçôes HTTP: GET, POST, PUT e DELETE com o objetivo de cadastrar as informações para as turmas do Programa de Bolsas Compass.
# Construído com
Java 17, SpringBoot 3.0.9, Maven, MySQL 8 e JPA.
# Como o projeto foi pensado
Para facilitar o uso do programa criei um arquivo .sql que já popula automaticamente o banco de dados com 3 coordinators, 3 scrum masters, 3 instructors e 14 students. Pensei em seguir um padrão em todo o projeto, você pode cadastrar uma entidade nova por vez e para realizar as ações de juntar entidades, por exemplo, adicionar um student em uma classroom, você só precisa do ID das entidades.
# Student 
1- POST: Para registrar um Student no banco de dados, envie uma solicitação POST para /v1/students/post. Você pode usar o Postman e o request é:

{

    "name_student": "Student 1", (type:String)
    
}
# Coordinator
1- POST: Para registrar um Coordinator no banco de dados, envie uma solicitação POST para /v1/coordinators/post. O request é:

{

    "name_coordinator": "Coordinator 1", (type:String)
    
}
# Instructor
1- POST: Para registrar um Instructor no banco de dados, envie uma solicitação POST para /v1/instructors/post. O request é:

{

    "name_instructor": "Instructor 1", (type:String)
    
}
# Scrum Master
1- POST: Para registrar um Scrum Master no banco de dados, envie uma solicitação POST para /v1/scrum-masters/post. O request é:

{

    "name_scrum": "Scrum Master 1", (type:String)
    
}
# Squad
1- POST: Para registrar uma Squad no banco de dados, envie uma solicitação POST para /v1/squads/post. O request é:

{

    "name_squad": "Squad 1", (type:String)
    
}

2- PUT: Para adicionar um Student na Squad, envie uma solicitação PUT para /v1/squads/add/{id_squad}/students/{id_student}. Subistitua o {id_squad} e o {id_student} pelo valor do id da squad e do student no banco de dados.

3- GET: Para ver uma Squad, envie uma solicitação GET para /v1/squads/get/{id_squad}. Subistitua o {id_squad} pelo valor do id da squad no banco de dados.

4- DELETE: Para deletar uma Squad, envie uma solicitação DELETE para /v1/squads/delete/{id_squad}. Subistitua o {id_squad} pelo valor do id da squad no banco de dados.
# Classroom
1- POST: Para registrar uma Classroom no banco de dados, envie uma solicitação POST para /v1/classes/post. Quando você cria uma classroom, automaticamente o status da classrom é alterado para WAITING. O request é:

{

    "name_class": "Classroom 1", (type:String)
    
}

2- GET: Para ver uma Classroom, envie uma solicitação GET para /v1/classes/get/{id_class}. Subistitua o {id_class} pelo valor do id da classroom no banco de dados.

3- DELETE: Para deletar uma Classroom, envie uma solicitação DELETE para /v1/classes/delete/{id_class}. Subistitua o {id_class} pelo valor do id da classroom no banco de dados.

4- PUT: Para adicionar um Coordinator na Classroom, envie uma solicitação PUT para /v1/classes/add/{id_class}/coordinators/{id_coordinator}. Subistitua o {id_class} e o {id_coordinator} pelo valor do id da classroom e do coordinator no banco de dados.

5- PUT: Para adicionar um Scrum Master na Classroom, envie uma solicitação PUT para /v1/classes/add/{id_class}/scrum-masters/{id_scrum}. Subistitua o {id_class} e o {id_scrum} pelo valor do id da classroom e do scrum master no banco de dados.

6- PUT: Para adicionar um Instructor na Classroom, envie uma solicitação PUT para /v1/classes/add/{id_class}/instructors/{id_insructor}. Subistitua o {id_class} e o {id_insructor} pelo valor do id da classroom e do instructor no banco de dados.

7- PUT: Para adicionar um Student na Classroom, envie uma solicitação PUT para /v1/classes/add/{id_class}/students/{id_student}. Subistitua o {id_class} e o {id_student} pelo valor do id da classroom e do student no banco de dados. Você só vai conseguir adicionar estudates na classroom se o status dela for WAITING.

8- PUT: Para startar uma Classroom, envie uma solicitação PUT para /v1/classes/start/{id_class}. Substitua o {id_class} pelo valor do id da classroom no banco de dados. Você só vai consguir mudar o status da classroom para STARTED se na classroom estiver casdatrado 1 coordinator, 1 scrum master e 3 instructors.

9- PUT: Para finalizar uma Classroom, envie uma solicitação PUT para /v1/classes/finish/{id_class}. Substitua o {id_class} pelo valor do id da classroom no banco de dados. Você só vai consguir mudar o status da classroom para FINISHED se na classroom estiver casdatrado 1 coordinator, 1 scrum master, 3 instructors, no mínimo 15 students e no máximo 30 students.
# Regras de Negócio
1- O nome do database é "db_scholarship";

2- O username do database é "root" e a senha é "root";

3- A classroom deve ter no mínimo 15 estudantes e no máximo 30 estudantes.

4- A Classroom deve ter 3 status: waiting, started, finished.

5- Deve haver um endpoint para alterar o status para finished.

6- Cada Squad deverá ter no máximo 5 Students e ser o mais equilibrado possível.

7- Para startar a Classroom você precisa de 1 Coordenador, 1 Scrum Master e 3 Instrutores.

8- Versione a API.

9- Você precisa de um endpoint ou script SQL que preencha o banco de dados com 3 coordinators, 3 scrum masters, 3 instructors e exatemente 14 students.

10- Implemente endpoints para cada uma das requisiçôes HTTP (GET, POST, PUT e DELETE).

11- Crie um endpoint que mostre a Classroom e seu membros.

12- Faça Unit Test, garantindo que seja coberto por pelo menos 30% dos testes, ideal para mais de 70%.

13- Faça Integration Tests com Mock MVC.
