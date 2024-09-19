SELECT project1.ID as project1,
       TIMESTAMPDIFF(month, project1.START_DATE, project1.FINISH_DATE) * SUM(worker1.SALARY) AS project_cost
FROM project1
         JOIN project_worker1 ON project1.ID = project_worker1.PROJECT_ID
         JOIN worker1 ON project_worker1.WORKER_ID = worker1.ID
GROUP BY project1.ID
ORDER BY project_cost DESC;



