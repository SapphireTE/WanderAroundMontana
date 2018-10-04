REATE SEQUENCE scenery_id_seq;
create table scenery (
   id bigint not null DEFAULT NEXTVAL('scenery_id_seq'),
   category varchar(255) not NULL,
	 nature varchar(255) not NULL,
	 national_park varchar (255) not NULL,
   primary key (id)
);

ALTER SEQUENCE scenery_id_seq OWNED by scenery.id;