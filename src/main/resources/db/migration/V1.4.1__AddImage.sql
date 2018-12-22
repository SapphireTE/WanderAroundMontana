CREATE SEQUENCE images_id_seq;
create table Images(
    id bigint not null default nextval('images_id_seq'),
    image_name varchar(255) not null unique,
    primary key (id)
);

alter sequence images_id_seq owned by Images.id;

