with data as (
    select p1.patient_id, patient_name,p2.age, p1.test_date, result, rank() over(partition by patient_id order by test_date asc) as ranking
    from covid_tests p1
    inner join patients p2
    on p1.patient_id = p2.patient_id
    
    where result <> 'Inconclusive' 
)

select d1.patient_id, d1.patient_name, d1.age, datediff(min(d2.test_date), min(d1.test_date)) as recovery_time
from data d1
inner join data d2
on d1.patient_id = d2.patient_id 
where d1.ranking < d2.ranking
and d1.result = 'Positive'
and d2.result = 'Negative'
group by d1.patient_id
order by recovery_time asc, patient_name asc