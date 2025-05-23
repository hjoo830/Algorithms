SELECT FLAVOR
FROM (
    SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL
    FROM (
        SELECT FLAVOR, TOTAL_ORDER FROM FIRST_HALF
        UNION ALL
        SELECT FLAVOR, TOTAL_ORDER FROM JULY
    ) AS TOTAL_INFO
    GROUP BY FLAVOR
) T
ORDER BY TOTAL DESC
LIMIT 3
