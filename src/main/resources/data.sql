delete from User;
insert into User values(1, 'User1', LOCALTIMESTAMP);
insert into User values(2, 'User2', LOCALTIMESTAMP);
insert into User values(3, 'User3', LOCALTIMESTAMP);
insert into User values(4, 'User4', LOCALTIMESTAMP);
insert into User values(5, 'User5', LOCALTIMESTAMP);

delete from Activity;
insert into Activity values(IDENTITY()+1, 1, 'logged in', LOCALTIMESTAMP);
insert into Activity values(IDENTITY()+1, 1, 'email changed', LOCALTIMESTAMP);
insert into Activity values(IDENTITY()+1, 1, 'logged out', LOCALTIMESTAMP);
insert into Activity values(IDENTITY()+1, 2, 'logged in', LOCALTIMESTAMP);
insert into Activity values(IDENTITY()+1, 3, 'logged in', LOCALTIMESTAMP);
insert into Activity values(IDENTITY()+1, 3, 'charged 1 yen', LOCALTIMESTAMP);
