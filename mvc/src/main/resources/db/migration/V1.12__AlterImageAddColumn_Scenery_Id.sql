alter table Images add constraint fk_Image_Scenery
    foreign key (scenery_id)
    references Sceneries (id)
    on delete no action
    on update no action;