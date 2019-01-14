alter table Images add column culturalInheritance_id bigint default null;

alter table Images add constraint fk_Image_Cultural_Inheritance
    foreign key (culturalInheritance_id)
    references Cultural_Inheritances (id)
    on delete no action
    on update no action;
