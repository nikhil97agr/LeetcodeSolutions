function* dateRangeGenerator(start: string, end: string, step: number) : Generator<string> {
    const currentDate = new Date(start);
    const endDate = new Date(end);

    while(currentDate <= endDate){
        yield currentDate.toISOString().substring(0, 10);
        currentDate.setDate(currentDate.getDate()+step);
    }
};

/**
 * const g = dateRangeGenerator('2023-04-01', '2023-04-04', 1);
 * g.next().value; // '2023-04-01'
 * g.next().value; // '2023-04-02'
 * g.next().value; // '2023-04-03'
 * g.next().value; // '2023-04-04'
 * g.next().done; // true
 */