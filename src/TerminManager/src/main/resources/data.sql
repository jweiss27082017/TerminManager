start transaction;

 insert into Termin (Titel , Ort , Datum)
 values ('ÜK','ZLI', '2009-02-12T23:33:22');

 insert into User (username, password, email)
 values ('Harold23','123','Harold@email.ch');

insert into Rolle (bezeichnung)
 values ('admin');

 insert into user_rollen (users_id, rollen_id)
 values (1, 1);

insert into Teilnahme (termin_id, user_id, status)
 values (1, 1,'aktiv');

 commit;

