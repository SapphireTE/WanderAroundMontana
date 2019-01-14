alter table Images add column outdoorRecreation_id bigint default null;

alter table Images add constraint fk_Image_Outdoor_Recreation
    foreign key (outdoorRecreation_id)
    references Outdoor_Recreations (id)
    on delete no action
    on update no action;

aljflkananvnanjasnjakgit

jahfaf;asf