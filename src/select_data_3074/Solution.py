import pandas as pd

def selectData(students: pd.DataFrame) -> pd.DataFrame:
    filtered_data = students[students['student_id'] == 101]
    return filtered_data[['name', 'age']]