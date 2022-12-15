create table if not exists empresa(
id serial primary key,
name_emp varchar(10) not null,
state_emp varchar(1) not null
);

create table if not exists convenio(
id serial primary key,
fecha_inicio date not null,
fecha_fin date not null,
state_con varchar(1) not null,
empresa_id int not null,
foreign key empresa_id references empresa(id)
);

create table if not exists tareas(
id serial primary key,
detalles varchar(200) not null,
convenio_id int not null,
foreign key convenio_id references convenio(id)
);

create table if not exists direccion(
id serial primary key,
dir varchar(200) not null,
empresa_id int not null,
foreign key empresa_id references empresa(id)
);

create table if not exists carreras(
id serial primary key,
especialidad varchar(200) not null,
descipcion int not null,
state_car varchar(1) not null,
convenio_id int not null,
foreign key convenio_id references convenio(id)
);

create table if not exists tutor_suda(
id serial primary key,
rol varchar(200) not null,
carreras_id int not null,
foreign key carreras_id references carreras(id)
);

create table if not exists tutor_emp(
id serial primary key,
funcion varchar(200) not null,
empresa_id int not null,
foreign key empresa_id references empresa(id)
);