create view view_add as
select *
from ads
         join cars c on c.id = ads.car_id
         join engines e on e.id = c.engine_id
         join models m on m.id = c.model_id
         join types t on t.id = c.type_id
         join users u on ads.user_id = u.id