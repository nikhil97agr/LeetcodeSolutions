/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var undefinedToNull = function(obj) {
    if(obj === undefined || obj === null) return null;
    if(Array.isArray(obj)){
        const res = []
        for( let x of obj){
            res.push(undefinedToNull(x))
        }
        return res;
    }

    if(typeof obj === 'object'){
        const keys = Object.keys(obj);
    const res = {}
    for(let key of keys){
        res[key] = undefinedToNull(obj[key]);
    }

    return res;
    }
    return obj;
};

/**
 * undefinedToNull({"a": undefined, "b": 3}) // {"a": null, "b": 3}
 * undefinedToNull([undefined, undefined]) // [null, null] 
 */