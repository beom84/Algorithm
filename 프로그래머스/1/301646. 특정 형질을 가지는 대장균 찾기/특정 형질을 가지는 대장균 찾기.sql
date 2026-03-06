/*
    select
    COUNT(*) 대장균 개체의수
    from
    ECOLI_DATA
    where
    GENOTYPE 2번이 없어야하고 1,3중 한개는 있어야하며 4는 상관없음
    1 4 8 2
*/
SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE 
      (GENOTYPE & 2) = 0          -- 2번 형질은 없고 (필수)
  AND (
      (GENOTYPE & 1) > 0          -- 1번 형질이 있거나
      OR 
      (GENOTYPE & 4) > 0          -- 3번 형질이 있거나
      );