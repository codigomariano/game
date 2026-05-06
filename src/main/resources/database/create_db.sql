create table CATEGORIAS(
	ID int NOT NULL,
	nombre varchar(25) NOT NULL,
	PRIMARY KEY(ID)
);

create table OPCIONES_BINARIAS(
	ID int NOT NULL,
	caracter varchar(1) NOT NULL,
	PRIMARY KEY(ID)
);

create table OPCIONES_MULTIPLES(
	ID int NOT NULL,
	caracter varchar(1) NOT NULL,
	PRIMARY KEY(ID)
);

create table PERMISOS(
	ID int NOT NULL,
	nombre varchar(25) NOT NULL,
	PRIMARY KEY(ID)
);

create table JUEGOS(
	ID bigint not null AUTO_INCREMENT,
	PRIMARY KEY(ID)
);

create table USUARIOS(
	ID bigint not null AUTO_INCREMENT,
	email varchar(50) not null,
	juego_id bigint,
	PRIMARY KEY(ID)
);

insert into PACIENTE (DNI, NOMBRE) values ('2566555', 'José');

SELECT * from PACIENTE; 


alter table USUARIOS add constraint USR$JUG foreign key (juego_id) references JUEGOS(ID);

create table PREGUNTAS(
	ID bigint not null AUTO_INCREMENT,
	codigo varchar(25) not null,
	texto varchar(255) not null,
	puntos smallint,
	juego_id bigint not null,
	categoria_id integer not null,
	PRIMARY KEY(ID)
);

alter table PREGUNTAS add constraint PRE$JUG foreign key (juego_id) references JUEGOS(ID);

alter table PREGUNTAS add constraint PRE$CAT foreign key (categoria_id) references CATEGORIAS(ID);

create table PREGUNTAS_BINARIAS(
	ID bigint not null,
	opcion_correcta integer not null,
	PRIMARY KEY(ID)
);

alter table PREGUNTAS_BINARIAS add constraint PREB$ID foreign key (ID) references PREGUNTAS(ID);

alter table PREGUNTAS_BINARIAS add constraint PREB$OPT foreign key (opcion_correcta) references OPCIONES_BINARIAS(ID);

create table PREGUNTAS_MULTIPLES(
	ID bigint not null,
	PRIMARY KEY(ID)
);

alter table PREGUNTAS_MULTIPLES add constraint PREM$ID foreign key (ID) references PREGUNTAS(ID);

create table RESPUESTAS(
	ID bigint not null AUTO_INCREMENT,
	texto varchar(255) not null,
	correcta TINYINT(1) null,
	pregunta_id bigint not null,
	PRIMARY KEY(ID)
);

alter table RESPUESTAS add constraint RES$PRE foreign key (pregunta_id) references PREGUNTAS_MULTIPLES(ID);

create table PERMISOS_USUARIOS(
	PERMISO_ID int not null,
	USUARIO_ID bigint not null,
	PRIMARY KEY(PERMISO_ID, USUARIO_ID)
);

alter table PERMISOS_USUARIOS add constraint PUSR$PER foreign key (PERMISO_ID) references PERMISOS(ID);

alter table PERMISOS_USUARIOS add constraint PUSR$USR foreign key (USUARIO_ID) references USUARIOS(ID);

