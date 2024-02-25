--Завдання №7 - вивести вартість кожного проєкту

SELECT 'Project ' || project.ID AS NAME,
    COALESCE(SUM(worker.SALARY) * DATEDIFF(MONTH, project.START_DATE, project.FINISH_DATE), 0) AS PRICE
FROM project
LEFT JOIN project_worker ON project.ID = project_worker.PROJECT_ID
LEFT JOIN worker ON project_worker.WORKER_ID = worker.ID
GROUP BY project.ID, project.START_DATE, project.FINISH_DATE
ORDER BY PRICE DESC;