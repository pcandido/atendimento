create sequence cliente_id_seq;

create table cliente(
    id bigint not null primary key default nextval('cliente_id_seq'::regclass),
    nome varchar(255) not null,
    email varchar(255) not null
);