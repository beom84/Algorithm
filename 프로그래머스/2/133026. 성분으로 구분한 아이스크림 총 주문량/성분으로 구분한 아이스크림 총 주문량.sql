-- 코드를 입력하세요
SELECT b.INGREDIENT_TYPE , sum(a.TOTAL_ORDER) as TOTAL_ORDER  -- 각 아이스크림 성분타입에 대한 아이스크림의 총주문량 
from FIRST_HALF a
join ICECREAM_INFO b on a.FLAVOR = b.FLAVOR
group by b.INGREDIENT_TYPE