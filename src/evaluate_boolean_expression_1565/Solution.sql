select ex.left_operand, ex.operator, ex.right_operand  ,
case 
    when operator = '<' then if(v1.value < v2.value, "true", "false")
    when operator = '>' then if(v1.value > v2.value, "true", "false")
    else if(v1.value =v2.value, "true", "false")
end as value
from expressions ex
 join variables v1
on v1.name = ex.left_operand
 join variables v2
 on v2.name = ex.right_operand