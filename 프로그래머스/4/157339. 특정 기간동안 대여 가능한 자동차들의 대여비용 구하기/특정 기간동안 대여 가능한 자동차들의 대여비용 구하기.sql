-- 코드를 입력하세요
/*
 type == 세단 suv
 대여기간이 11월 1일 전 11일 30일 후
 Duration Type이 30일 이상 에서 DISCOUNT_RATE를 뽑아서 계산
 1. carID type이 저거중에
 2. 2번 테이블에서 group by -> DATE 가 있는거만 뽑아주고 ID로
 3. 3번에서 대여기간을 걸러서 붙여준다.
*/ 
SELECT 
    a.CAR_ID,
    a.CAR_TYPE, 
    round(a.DAILY_FEE * 30 * (1 - c.DISCOUNT_RATE/100)) as FEE
from CAR_RENTAL_COMPANY_CAR a
    join
    (
        select CAR_TYPE , DISCOUNT_RATE
        from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
        where DURATION_TYPE = '30일 이상'
    ) c using(CAR_TYPE)
where 
    a.CAR_ID Not in  (
        select distinct CAR_ID
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where END_DATE >= '2022-11-01' AND START_DATE<= '2022-11-30'
        group by CAR_ID 
    ) and
    a.CAR_TYPE in ('SUV','세단') and a.DAILY_FEE * 30 * (100 - c.DISCOUNT_RATE)/100 >= 500000 and a.DAILY_FEE * 30 * (100 - c.DISCOUNT_RATE)/100 < 2000000
order by FEE desc , CAR_TYPE asc ,CAR_ID desc
-- 자동차 종류가 '세단','SUV' 인 자동차 중
-- 2022년 11월 1 ~ 30 까지 대여가능하고
-- 30일간의 대여금액이 50만 이상 ~ 200만원 미만
-- 인 자동차 ID 종류 대여금액  출력
-- 대여금액 desc , 자동차 종류 asc,  id desc