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
);

create table if not exists User (
  id identity,
  name varchar(100),
  created_at timestamp
);

create table if not exists Activity (
  id identity,
  user_id int,
  detail varchar(1000),
  happened_at timestamp
);


alter table Activity
    add foreign key (user_id) references User(id);
    
    