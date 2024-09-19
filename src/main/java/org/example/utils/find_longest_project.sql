SELECT month_count, project_counts.ID
FROM project1
         JOIN (
    SELECT ID, MAX(TIMESTAMPDIFF(month, START_DATE, FINISH_DATE)) as month_count
    from project1
    GROUP BY ID
) AS project_counts
              ON project1.ID = project_counts.ID
         JOIN (
    SELECT MAX(TIMESTAMPDIFF(month, START_DATE, FINISH_DATE)) AS max_count
    FROM project1
    GROUP BY ID
    ORDER BY MAX(TIMESTAMPDIFF(month, START_DATE, FINISH_DATE)) DESC
    LIMIT 1
) AS max_projects
              ON project_counts.month_count = max_projects.max_count;
