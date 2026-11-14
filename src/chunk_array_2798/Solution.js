/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    const res = [];
    for(let i=0;i<arr.length;i+=size){
        const sub = arr.slice(i, Math.min(i+size, arr.length));
        res.push(sub);
    }
    return res;
};
