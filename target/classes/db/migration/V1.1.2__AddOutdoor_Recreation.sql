CREATE SEQUENCE outdoorRecreations_id_seq;
create table Outdoor_recreations (
   id bigint not null DEFAULT NEXTVAL('outdoorRecreations_id_seq'),
   category varchar(255) not NULL,
   hiking varchar(255) not NULL,
	 fishing varchar(255) not NULL,
   skiing varchar(255) not NULL,
   distance float not null,
	 primary key (id)
);

ALTER SEQUENCE outdoorRecreations_id_seq OWNED BY Outdoor_Recreations.id;