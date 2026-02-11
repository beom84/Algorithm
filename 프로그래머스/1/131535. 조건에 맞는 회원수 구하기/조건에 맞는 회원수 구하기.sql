/*
 출력 컬럼 
 - 회원의 수 as USERS
 
 어떤 데이터
 - joined 2021
 - 20<=age <= 29
 
 묶어서 계산
 - 기준 : 회원
*/
SELECT COUNT(*) AS USERS
FROM USER_INFO 
WHERE YEAR(JOINED) = 2021 
  AND AGE <= 29 
  AND AGE >= 20;