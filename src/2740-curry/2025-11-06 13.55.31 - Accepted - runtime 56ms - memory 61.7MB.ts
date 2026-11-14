function curry(fn: Function): Function {
    
    const curried = (...args)=>{
        if(args.length >= fn.length){
            return fn(...args);
        }

        return (...newArgs) => curried(...args, ...newArgs);
    }

    return curried;
};

/**
 * function sum(a, b) { return a + b; }
 * const csum = curry(sum);
 * csum(1)(2) // 3
 */
