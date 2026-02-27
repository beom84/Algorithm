-- 분화된 연도 , 연도별 대장균 크기의 편자 , ID를 출력
-- 편차 : 분화된 연도별 가장 큰 대장균의 크기 - 각 대장균의 크기
-- 연도 asc . 크기 편자 asc
-- 연도별 MAX를 구한다. 연도에 따라 편차를 출력

select 
    YEAR(DIFFERENTIATION_DATE) as YEAR, MAX(SIZE_OF_COLONY) over ( partition by YEAR(DIFFERENTIATION_DATE) ) - SIZE_OF_COLONY as YEAR_DEV , ID
from ECOLI_DATA
order by YEAR asc , YEAR_DEV asc