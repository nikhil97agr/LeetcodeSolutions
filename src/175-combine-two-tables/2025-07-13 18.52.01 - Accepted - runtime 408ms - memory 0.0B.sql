select firstname, lastName, city, state
from person
left join
address
 on person.personid = address.personId