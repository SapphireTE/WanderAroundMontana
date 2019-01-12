drop table Images;

CREATE SEQUENCE images_id_seq;
create table Images(
    id bigint not null default nextval('images_id_seq'),
    image_name varchar(255) not null unique,
    user_id bigint DEFAULT NULL,
    scenery_id bigint default null,
--     outdoorRecreation_id default null,
--     culturalInheritance_id default null,
    primary key (id),
    constraint fk_Image_User
    foreign key (user_id)
    references Users (id)
    on delete no action
    on update no action
--
--     constraint fk_Image_Scenery,
--     foreign key scenery_id,
--     references Sceneries (id),
--     on delete no action ,
--     on update no action,
--
--     constraint fk_Image_Outdoor_Recreation,
--     foreign key (outdoorRecreation_id),
--     references Outdoor_Recreations (id),
--     on delete no action,
--     on update no action,
--
--     constraint fk_Image_Cultural_Inheritance,
--     foreign key (culturalInheritance_id),
--     references Cultural_Inheritances (id),
--     on delete no action,
--     on update no action,
);

alter sequence images_id_seq owned by Images.id;


