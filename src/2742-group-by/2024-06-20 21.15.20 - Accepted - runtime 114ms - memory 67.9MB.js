/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    const res = {}
    for(let ele of this){
        const key = fn(ele);
        if(res[key]){
            res[key].push(ele);
        }else{
            res[key] = [ele]
        }
    }
    return res;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */