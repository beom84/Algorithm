-- 코드를 작성해주세요
-- 물고기의 종류별 / 물고기의 이름과 잡은 수
select count(*) as FISH_COUNT, b.FISH_NAME 
from FISH_INFO a
left join FISH_NAME_INFO b using(FISH_TYPE)
group by FISH_NAME
order by FISH_COUNT desc