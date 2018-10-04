CREATE SEQUENCE culturalInheritances_id_seq;
create table Cultural_inheritances (
   id bigint not null DEFAULT NEXTVAL('culturalInheritances_id_seq'),
   category varchar(255) not NULL,
   museum varchar(255) not NULL,
   historical_scene varchar(255) not NULL,
	primary key (id)
);

ALTER SQUENCE culturalInheritances_id_seq OWNED by Cultural_inheritances.id;