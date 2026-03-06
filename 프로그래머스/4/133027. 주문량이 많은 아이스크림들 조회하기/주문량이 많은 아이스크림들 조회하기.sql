SELECT FLAVOR
FROM (
    -- 1. 상반기 데이터
    SELECT FLAVOR, TOTAL_ORDER FROM FIRST_HALF
    UNION ALL
    -- 2. 7월 데이터 (맛별로 여러 줄일 수 있으므로 상관없음, 나중에 한꺼번에 합칠 것임)
    SELECT FLAVOR, TOTAL_ORDER FROM JULY
) AS COMBINED_TABLE
GROUP BY FLAVOR                       -- 3. 맛별로 묶어서
ORDER BY SUM(TOTAL_ORDER) DESC        -- 4. 총합 기준으로 내림차순
LIMIT 3;                              -- 5. 상위 3개