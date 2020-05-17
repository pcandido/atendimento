create sequence atendimento_id_seq;

create table atendimento(
    id bigint not null primary key default nextval('atendimento_id_seq'::regclass),
    sumario varchar(512) not null,
    criacao timestamp not null,
    descricao text not null,
    tipo varchar(10) not null,
    cliente_id bigint not null,
    responsavel_id bigint not null,
    constraint atendimento_cliente_id foreign key (cliente_id) references cliente(id),
    constraint atendimento_resposavel_id foreign key (responsavel_id) references operador(id)
);