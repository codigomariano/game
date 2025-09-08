create table CATEGORIAS(
	ID int NOT NULL,
	nombre varchar(25) NOT NULL,
	PRIMARY KEY(ID)
);

create table JUEGOS(
	ID bigint not null AUTO_INCREMENT,
	PRIMARY KEY(ID)
);

create table USUARIOS(
	ID bigint not null,
	nombre varchar(50) not null,
	juego_id bigint,
	PRIMARY KEY(ID)
);

alter table USUARIOS add constraint USR$JUG foreign key (juego_id) references JUEGOS(ID);

create table PREGUNTAS(
	ID bigint not null,
	codigo varchar(25) not null,
	texto varchar(255) not null,
	puntos smallint,
	juego_id bigint not null,
	categoria_id integer not null,
	opcion_correcta varchar(3) not null,
	discriminator varchar(50) not null,
	PRIMARY KEY(ID)
);

alter table PREGUNTAS add constraint PRE$JUG foreign key (juego_id) references JUEGOS(ID);

alter table PREGUNTAS add constraint PRE$CAT foreign key (categoria_id) references CATEGORIAS(ID);

create table RESPUESTAS(
	ID bigint not null AUTO_INCREMENT,
	texto varchar(255) not null,
	pregunta_id bigint not null,
	PRIMARY KEY(ID)
);

alter table RESPUESTAS add constraint RES$PRE foreign key (pregunta_id) references PREGUNTAS(ID);
