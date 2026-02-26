-- 코드를 입력하세요
SELECT YEAR(a.SALES_DATE) as YEAR , MONTH(a.SALES_DATE) as MONTH , b.GENDER , COUNT(DISTINCT USER_ID) as USERS
from 
    ONLINE_SALE a
    inner join
    USER_INFO b using(USER_ID)
where b.GENDER is not null
group by YEAR, MONTH, GENDER
order By YEAR, MONTH, GENDER

-- 년, 월, 성별 , 별로 상품을 구매한 회원수를 집계하는 sQL문
-- user info 에서 gender를 가져온다
-- online sale에서 년도 월 성별로 구분