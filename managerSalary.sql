#Little SQL query for a table that contains names, ids, salaries, and manager ids
#To look up employees with salaries that are higher than their managers.
# Write your MySQL query statement below
SELECT
    t2.Name AS 'Employee'
FROM
    `Employee`AS t1
JOIN
    `Employee` AS t2
ON
    t1.Id = t2.ManagerId
WHERE
    t1.Salary < t2.Salary
