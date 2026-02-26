-- 코드를 입력하세요
SELECT CATEGORY,PRICE as MAX_PRICE,PRODUCT_NAME
from FOOD_PRODUCT
where (CATEGORY,PRICE) in (
    select CATEGORY,MAx(PRICe)
    from FOOD_PRODUCT
    where CATEGORY IN ('과자', '국', '김치', '식용유')
    group by CATEGORY
)
group by CATEGORY 
order by MAX_PRICE desc
-- 식품 분류별로 가격이 제일 비싼 식품 조회
-- 분류 가격 이름
-- 식품 분류가 '과자', '국', '김치', '식용유 인경우만 출력
-- 식품가격 desc