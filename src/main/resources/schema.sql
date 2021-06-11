create table if not exists Article (
  id identity,
  title varchar(200),
  status int,
  type varchar(20)
);

create table if not exists Task (
  id identity,
  title varchar(200),
  priority int
);

create table if not exists Event (
  id identity,
  title varchar(200),
  category varchar(20)
)