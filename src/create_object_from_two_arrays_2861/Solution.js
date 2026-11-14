/**
 * @param {Array} keysArr
 * @param {Array} valuesArr
 * @return {Object}
 */
var createObject = function(keysArr, valuesArr) {
    const res = {}

    for(let i=0;i<keysArr.length;i++){
        const key = String(keysArr[i]);
        const val =valuesArr[i];

        if(res[key] === undefined){
            res[key] = val
        }
    }
    return res;
};