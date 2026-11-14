/**
 * @param {Array} arr
 * @param {Function} fn
 * @return {Array}
 */
var sortBy = function(arr, fn) {
    arr.sort((a,b)=>{
        const val1 = fn(a);
        const val2 = fn(b);
        if(val1 > val2) return 1;
        return -1;
    });
    return arr;
};