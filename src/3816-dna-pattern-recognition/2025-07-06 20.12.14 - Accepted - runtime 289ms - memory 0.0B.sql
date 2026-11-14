select a.sample_id, a.dna_sequence, a.species, case when a.dna_sequence like "ATG%" then 1 else 0 END as has_start,
case when (a.dna_sequence like "%TAA" or a.dna_sequence like "%TAG" or a.dna_sequence like "%TGA" ) then 1 else 0 END as has_stop,
case when (a.dna_sequence like "%ATAT%") then 1 else 0 end as has_atat,
case when (a.dna_sequence REGEXP "G{3,}") then 1 else 0 end as has_ggg
from samples a