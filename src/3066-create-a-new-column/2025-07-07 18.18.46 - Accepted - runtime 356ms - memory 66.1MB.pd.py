import pandas as pd

def createBonusColumn(employees: pd.DataFrame) -> pd.DataFrame:
    employees['bonus'] = employees.apply(lambda row: row.salary*2, axis=1)
    return employees