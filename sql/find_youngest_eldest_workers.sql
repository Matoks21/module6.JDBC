--Завдання №6 - знайти найстаршого та наймолодшого працівника

WITH AgeInfo AS (
    SELECT 
        NAME,
        BIRTHDAY,
        TIMESTAMPDIFF(YEAR, BIRTHDAY, CURRENT_DATE) AS AGE
    FROM 
       worker
)
SELECT 
    CASE 
        WHEN AGE = (SELECT MIN(AGE) FROM AgeInfo) THEN 'YOUNGEST'
        WHEN AGE = (SELECT MAX(AGE) FROM AgeInfo) THEN 'ELDEST'
    END AS TYPE,
    NAME,
    BIRTHDAY,
    AGE
FROM 
    AgeInfo
WHERE 
    AGE = (SELECT MIN(AGE) FROM AgeInfo) OR AGE = (SELECT MAX(AGE) FROM AgeInfo);
