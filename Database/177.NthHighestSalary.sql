/*Write a SQL query to get the nth highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the nth highest salary where n = 2 is 200. If there is no nth highest salary, then the query should return null.
+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+
*/

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
SET N = N - 1;
  RETURN (
      SELECT DISTINCT salary /*DISTINCT only get distinct(one) nth highest value*/
      FROM Employee
      ORDER BY salary DESC /*DESC降序排序*/
      LIMIT N,1 /*LIMIT作用为限制select的数量，第一个参数offset为偏移量，第二个参数count为显示多少个数据*/   
  );
END