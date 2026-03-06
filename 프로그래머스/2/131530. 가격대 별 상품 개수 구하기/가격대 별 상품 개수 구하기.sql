-- 코드를 입력하세요
SELECT floor(PRICE/10000) *10000 as PRICE_GROUP,count(*) as PRODUCTS-- 만원 단위의 가격대 별로 상품개수를 출력 
from PRODUCT
group by PRICE_GROUP
order by PRICE_GROUP asc
-- 조인해서 