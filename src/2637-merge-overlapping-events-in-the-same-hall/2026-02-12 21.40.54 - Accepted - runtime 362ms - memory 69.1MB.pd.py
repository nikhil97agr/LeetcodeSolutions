import pandas as pd

def merge_events(hall_events: pd.DataFrame) -> pd.DataFrame:
    df = hall_events.sort_values(['hall_id', 'start_day', 'end_day'])
    df['prev_end'] = df.groupby('hall_id')['end_day'].cummax().shift(1)

    df['state'] = df.start_day > df.prev_end
    df['state' ] = df.groupby('hall_id')['state'].cumsum()

    return df.groupby(['hall_id', 'state']).agg(start_day = ('start_day', 'min'), end_day=('end_day', 'max')).reset_index().iloc[:, [0,2,3]]