/**
 * @param {null|boolean|number|string|Array|Object} object
 * @return {string}
 */
var jsonStringify = function(object) {
    if(typeof object === 'object'){
        return JSON.stringify(object);
    }
    if(typeof object === 'string'){
        return `"${object}"`
    }
    return object;
};