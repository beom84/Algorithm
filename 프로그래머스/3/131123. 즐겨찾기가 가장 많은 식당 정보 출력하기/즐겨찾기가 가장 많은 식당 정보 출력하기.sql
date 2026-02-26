-- 코드를 입력하세요
SELECT FOOD_TYPE,REST_ID,REST_NAME,FAVORITES
from REST_INFO
where FAVORITES IN (
    select max(FAVORITES)
    from REST_INFO
    group by FOOD_TYPE
)
group by FOOD_TYPE
order by FOOD_TYPE desc
/*
 음식 종류 별로 즐겨찾기수가 가장 많은 식당의 종류 id 이름 즐겨찾기수
 음식 종류 내에서 즐겨찾기 순으로 정렬된 가장 많은 식다의 종류
 1. 각 종류에서 가장 식당의 가격
*/