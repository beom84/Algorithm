-- 3개의 테이블에서 2022년 / 상,하반기 점수의 합 가 가장 높은 사원의 정보
select c.SCORE,a.EMP_NO,a.EMP_NAME,a.POSITION,a.EMAIL -- 점수, 사번, 성명, 직책, 이메일
from HR_EMPLOYEES a
left join HR_DEPARTMENT b using(DEPT_ID)
left join 
(select EMP_NO,YEAR, sum(SCORE) as SCORE
from HR_GRADE
 where YEAR = '2022'
group by EMP_NO) c using(EMP_NO)
order by c.SCORE desc limit 1

-- 사원ㅇ