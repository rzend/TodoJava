create table tarefas(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    descricao varchar(100) not null unique,
    status varchar(100) not null unique,

    primary key(id)

);