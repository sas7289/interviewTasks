drop table if exists movie_grid;
drop table if exists time_zome;
drop table if exists films;

CREATE TABLE films
(
    id       bigserial primary key,
    name     varchar(128) unique,
    duration interval
);

CREATE TABLE time_zome
(
    id       bigserial primary key,
    time_beg TIME,
    time_end TIME,
    price    int
);

CREATE TABLE movie_grid
(
    id          bigserial primary key,
    session_beg time,
    session_end time,
    film_id     bigint references films (id)
);

insert into films (name, duration)
values ('dune', '02:35'),
       ('malignant', '01:51'),
       ('the night house', '01:47'),
       ('free guy', '01:55');

insert into time_zome (time_beg, time_end, price)
values ('09:00', '13:00', 200),
       ('13:01', '17:00', 300),
       ('17:01', '23:00', 400),
       ('23:01', '02:00', 250);

insert into movie_grid (session_beg, session_end, film_id)
values ('09:00', '11:35', 1),
       ('11:00', '12:51', 2),
       ('12:52', '14:44', 2),
       ('14:00', '16:35', 1),
       ('17:00', '18:47', 3),
       ('19:00', '20:55', 4),
       ('21:30', '00:05', 1),
       ('00:00', '01:51', 2);

-- Первый вариант задания 1
select distinct mg.film_id      as "фильм 1",
                mg.session_beg  as "время начала фильма 1",
                mg.session_end  as "время окончания фильма 1",
                mg2.film_id     as "фильм 2",
                mg2.session_beg as "время начала фильма 2",
                mg2.session_end as "время окончания фильма 2"
from movie_grid as mg
         join movie_grid as mg2 on (mg.session_end > mg2.session_beg) and (mg.session_beg < mg2.session_end) and
                                   (mg.session_beg <> mg2.session_beg) and (mg.session_beg < mg2.session_beg)
order by mg.session_beg;

select mg.film_id, mg.session_beg + f.duration as dur
from movie_grid as mg
         join films as f on mg.film_id = f.id;

-- Второй вариант задания 1
select temp.film_id, temp.dur, temp.f2_id, temp.f2_beg from (
                                                                select mg.film_id,
                                                                       mg.session_beg + f.duration as dur,
                                                                       mg2.film_id                 as f2_id,
                                                                       mg2.session_beg             as f2_beg
                                                                from movie_grid as mg
                                                                         join films as f on mg.film_id = f.id
                                                                         join movie_grid as mg2 on mg.id + 1 = mg2.id

                                                            ) as temp where (dur > f2_beg);

-- Задание 1
select temp.film_id, temp.dur, temp.f2_id, temp.f2_beg from (
                                                                select mg.film_id,
                                                                       mg.session_beg + f.duration as dur,
                                                                       mg2.film_id                 as f2_id,
                                                                       mg2.session_beg             as f2_beg
                                                                from movie_grid as mg
                                                                         join films as f on mg.film_id = f.id
                                                                         join movie_grid as mg2 on mg.id + 1 = mg2.id

                                                            ) as temp where (f2_beg - dur) > '00:30' ;