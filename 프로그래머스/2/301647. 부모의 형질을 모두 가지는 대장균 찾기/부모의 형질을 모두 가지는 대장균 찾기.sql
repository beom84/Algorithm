/*
 select ID,GENOTYPE,PARENT_GENOTYPE
 from ECOLI_DATA
 where PARENT_ID IS NOT NULL  부모의 형질을 모두 보유한 대장균
    AND
*/ 
SELECT 
    A.ID, 
    A.GENOTYPE, 
    B.GENOTYPE AS PARENT_GENOTYPE
FROM 
    ECOLI_DATA A               -- 1. 자식 테이블 (A)
    JOIN ECOLI_DATA B          -- 2. 부모 테이블 (B)
    ON A.PARENT_ID = B.ID      -- 3. 연결 (자식의 부모ID = 부모의 ID)
WHERE 
    (A.GENOTYPE & B.GENOTYPE) = B.GENOTYPE -- 4. 비트 연산: (자식 & 부모) == 부모
ORDER BY 
    A.ID ASC;                  -- 5. 아이디 순 정렬