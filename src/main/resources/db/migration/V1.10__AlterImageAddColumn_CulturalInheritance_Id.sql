alter table Images
  add column culturalInheritanceImage_id bigint not null;

alter table Images
   add column outdoorRecreationImage_id bigint not null;

alter table Images
   add column sceneryImage_id bigint not null;
--
-- Alter table Outdoor_recreations
--   Add column distance double precision not NULL;