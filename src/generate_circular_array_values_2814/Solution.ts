function* cycleGenerator(arr: number[], startIndex: number): Generator<number, void, number> {
    let start = startIndex
    const len = arr.length;

    let next = yield arr[start]
    while (next !==undefined){
        next = next%len;
        start += next + len;
        start %=len;
        next = yield arr[start];
    }

};

/**
 *  const gen = cycleGenerator([1,2,3,4,5], 0);
 *  gen.next().value  // 1
 *  gen.next(1).value // 2
 *  gen.next(2).value // 4
 *  gen.next(6).value // 5
 */