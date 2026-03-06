/*
 select 
  COUNT as FISH_COUNT (바스 스내퍼의 수)
  from
   FISH_INFO
  where
   WHERE FISH_TYPE =
    SELECT FISH_TYPE FROM FISH_NAME_INFO where FISH_NAME = 'BASS' OR FISH_NAME = 'SNPPER'
   
*/
select 
  COUNT(*) as FISH_COUNT 
  from
   FISH_INFO
   WHERE FISH_TYPE in
   ( SELECT FISH_TYPE 
    FROM FISH_NAME_INFO 
    where FISH_NAME = 'BASS' OR FISH_NAME = 'SNAPPER')
   
    