Create SEQUENCE authorities_id_seq;
create table Authorities (
    id bigint not null DEFAULT NEXTVAL ('authorities_id_seq'),
    user_id bigint,
    authority varchar(255) not null,
    primary key (id)
);

Alter SEQUENCE authorities_id_seq owned by Authorities.id;

ALTER TABLE authorities ADD CONSTRAINT fk_authority_user
   FOREIGN KEY (user_id)
   REFERENCES Users (id)
   ON DELETE NO ACTION
   ON UPDATE NO ACTION;