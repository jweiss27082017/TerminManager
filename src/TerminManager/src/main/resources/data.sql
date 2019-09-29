start transaction;

 insert into Termin (Titel , Ort , Datum)
 values ('Test','ZLI', '2009-02-12T23:33:22');

 insert into User (username, password, email)
 values ('Harold','123','email@emai.ch');

insert into Rolle (bezeichnung)
 values ('slave');

 insert into user_rollen (users_id, rollen_id)
 values (1, 1);

insert into Teilnahme (termin_id, user_id, status)
 values (1, 1,'aktiv');

 commit;

