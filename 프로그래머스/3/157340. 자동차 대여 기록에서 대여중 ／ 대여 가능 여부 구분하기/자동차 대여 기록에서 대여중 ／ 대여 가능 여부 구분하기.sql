-- 2022년 10월 16일 -> 대여중

select 
    CAR_ID,
    case
        WHEN CAR_ID IN (
            SELECT CAR_ID 
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
            WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE
        ) THEN '대여중'
        ELSE '대여 가능'
    end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
order by
    CAR_ID desc