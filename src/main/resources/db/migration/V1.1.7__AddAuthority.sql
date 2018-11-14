Create SEQUENCE authority_id_seq;
create table authorities (
    id bigint not null DEFAULT NEXTVAL ('authority_id_seq'),
    user_id bigint,
    authority varchar(255) not null,
    primary key (id)
);

Alter SEQUENCE authority_id_seq owned by authorities.id;

ALTER TABLE authorities ADD CONSTRAINT fk_authority_user
   FOREIGN KEY (user_id)
   REFERENCES Users (id)
   ON DELETE NO ACTION
   ON UPDATE NO ACTION;