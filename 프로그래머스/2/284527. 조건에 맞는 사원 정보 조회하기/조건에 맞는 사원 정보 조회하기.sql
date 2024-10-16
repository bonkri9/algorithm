select
    sum(score) as score,
    e.emp_no as emp_no,
    e.emp_name as emp_name,
    e.position as position,
    e.email as email
from hr_department d, hr_employees e, hr_grade g
where
    d.dept_id = e.dept_id
    and
    e.emp_no = g.emp_no
    and
    g.year = 2022
group by e.emp_no
order by score desc
limit 1;
