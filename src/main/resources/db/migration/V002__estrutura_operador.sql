create sequence operador_id_seq;

create table operador(
    id bigint not null primary key default nextval('operador_id_seq'::regclass),
    nome varchar(255) not null,
    email varchar(255) not null
);