-- 코드를 입력하세요
SELECT 
    a.AUTHOR_ID,
    c.AUTHOR_NAME,
    a.CATEGORY,
    sum(a.PRICE*b.SALES) as TOTAL_SALES
from 
    BOOK a
    left join
    (
        select BOOK_ID,sum(SALES) as SALES
        from BOOK_SALES
        where SALES_DATE LIKE '2022-01%'
        group by BOOK_ID
    ) b using(BOOK_ID)
    left join
    AUTHOR c using(AUTHOR_ID)
group by a.AUTHOR_ID,a.CATEGORY
order by a.AUTHOR_ID asc,a.CATEGORY desc
-- 저자 ID(AUTHOR_ID), 저자명(AUTHOR_NAME), 카테고리(CATEGORY), 매출액(SALES) 출력
-- 카테고리별 매출액 (판매량 * 판매가) 를 구하여 책별로 묶었으니까 그다음은 카테고리 별로 묶어야하네
-- 저자 id 로음차순 , 카테고리 내림차순
