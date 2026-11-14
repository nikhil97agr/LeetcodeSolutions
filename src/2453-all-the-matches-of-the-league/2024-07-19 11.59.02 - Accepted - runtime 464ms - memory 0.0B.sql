# Write your MySQL query statement below


select a.team_name home_team, b.team_name away_team
from teams a join teams b
on a.team_name != b.team_name