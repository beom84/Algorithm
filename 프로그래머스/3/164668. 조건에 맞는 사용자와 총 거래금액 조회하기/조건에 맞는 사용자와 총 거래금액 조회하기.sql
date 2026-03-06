-- 코드를 입력하세요
SELECT a.USER_ID,a.NICKNAME,b.TOTAL_SALES
from USED_GOODS_USER a 
    inner join
    (
        select WRITER_ID as USER_ID,SUM(PRICE) as TOTAL_SALES
        from USED_GOODS_BOARD
        where STATUS = 'DONE'
        group by WRITER_ID
    ) b using(USER_ID)
where b.TOTAL_SALES >= 700000
order by b.TOTAL_SALES
-- 완료된 중고 거래의 총금액이 70만원 이상인 사람
-- 회원 ID, 닉네임, 총거래금액
-- 회원 ID를 기준으로  게시글에서 STATUS == DONE 인 게시물의 PRICE를 가져와야한다.
