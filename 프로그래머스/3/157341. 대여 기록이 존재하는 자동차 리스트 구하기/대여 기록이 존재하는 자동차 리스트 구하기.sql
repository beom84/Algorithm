-- 코드를 입력하세요
-- 자동차 종류가 '세단' 10월에 대여를 시작한 기간이 있는 자동차 추력
-- id lis t중복 x desc
SELECT distinct a.CAR_ID
from 
    CAR_RENTAL_COMPANY_RENTAL_HISTORY a
    join
    CAR_RENTAL_COMPANY_CAR b using(CAR_ID)
where b.CAR_TYPE = '세단'  and MONTH(a.START_DATE) = 10
order by a.CAR_ID desc