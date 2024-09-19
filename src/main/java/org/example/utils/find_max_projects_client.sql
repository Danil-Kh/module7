SELECT NAME, project_count
FROM client1
         JOIN (
    SELECT CLIENT_ID, COUNT(ID) AS project_count
    FROM project1
    GROUP BY CLIENT_ID
) AS project_counts
              ON client1.ID = project_counts.CLIENT_ID
         JOIN (
    SELECT COUNT(ID) AS max_count
    FROM project1
    GROUP BY CLIENT_ID
    ORDER BY COUNT(ID) DESC
    LIMIT 1
) AS max_projects
              ON project_counts.project_count = max_projects.max_count;



