create database sitenoticias;

use sitenoticias;

create table noticia (
id bigint auto_increment not null,
titulo text,
conteudo text,
primary key (id)
);

create table comentario (
idComentario bigint auto_increment not null,
idNoticia bigint,
comentario text,
primary key (idComentario),
constraint fknoticia
	foreign key (idNoticia)
    references noticia(id)
);
