-- 코드를 입력하세요
/*
 들어올떄 아니지만 나갈때 중성화된 동물
*/
SELECT a.ANIMAL_ID,a.ANIMAL_TYPE,a.NAME
from
     ANIMAL_INS a
     join
     ANIMAL_OUTS b using(ANIMAL_ID)
where 
    a.SEX_UPON_INTAKE LIKE 'Intact%' and (b.SEX_UPON_OUTCOME LIKE 'Spayed%' or b.SEX_UPON_OUTCOME LIKE 'Neutered%') 