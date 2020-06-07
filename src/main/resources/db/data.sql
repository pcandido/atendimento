delete from atendimento;
delete from operador;
delete from cliente;

alter sequence cliente_id_seq restart with 1;
alter sequence operador_id_seq restart with 1;
alter sequence atendimento_id_seq restart with 1;

insert into cliente(nome, email)
values ('Paulo', 'paulo@dominio.com'),
       ('Maria', 'maria@dominio.com'),
       ('Carlos', 'carlos@dominio.com'),
       ('Ana', 'ana@dominio.com'),
       ('Vitória', 'vitoria@dominio.com'),
       ('Henrique', 'henrique@dominio.com'),
       ('Claudio', 'claudio@dominio.com'),
       ('Denise', 'denise@dominio.com'),
       ('Flavio', 'flavio@dominio.com'),
       ('Cecilia', 'cecilia@dominio.com');