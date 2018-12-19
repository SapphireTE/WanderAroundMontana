CREATE SEQUENCE culturalInheritances_id_seq;
create table cultural_inheritances (
   id bigint not null DEFAULT NEXTVAL('culturalInheritances_id_seq'),
   category varchar(255) not NULL,
   museum varchar(255) not NULL,
   historical_scene varchar(255) not NULL,
	primary key (id)
);

ALTER SEQUENCE culturalInheritances_id_seq OWNED BY Cultural_inheritances.id;