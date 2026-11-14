type Fn = (...params: any) => any
const keyGenerator =  ()=>{
    let key = 0;
    const map = new Map<unknown, number>();

    return (input: unknown) =>{
        if(map.has(input)) return map.get(input);
        key++;
        map.set(input, key);

        return key;
    }
}
function memoize(fn: Fn): Fn {
    const cache = new Map<string, any>();
    const generator = keyGenerator();
    return function(...args) {
        const data =args.map(generator);

        const key = data.join(",");
        if(cache.has(key)) return cache.get(key);
        const result = fn(...args);
        cache.set(key, result);
        return result;
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */