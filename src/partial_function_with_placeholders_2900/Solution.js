/**
 * @param {Function} fn
 * @param {Array} args
 * @return {Function}
 */
var partial = function(fn, args) {
    
    return function(...restArgs) {
        const n = args.length;
        const m = restArgs.length;

        let i =0;
        let j =0;

        while( i < n && j < m){
            if(args[i] === '_'){
                args[i] = restArgs[j]
                j++;
            }
            i++;
        }    


        return fn(...[...args, ...restArgs.slice(j)])
    }
};