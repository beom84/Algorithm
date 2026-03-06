-- 코드를 입력하세요
SELECT MCDP_CD as 진료과코드,count(*) as 5월예약건수-- 환자수
from APPOINTMENT
where YEAR(APNT_YMD) = '2022' and MONTH(APNT_YMD) = '5'
group by MCDP_CD
order by 
`5월예약건수` ASC, MCDP_CD  asc
-- 2022년 5월에 예약한 
-- 진료과 코드 별