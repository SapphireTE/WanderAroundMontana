alter table images
  add column upload_data timestamp not null;

alter table images
  add column url varchar(255) not null unique;

alter table images
  add column extension varchar(255) not null unique;

alter table images
  add column uuid varchar(255) not null unique;