/**
 * @param {number} times
 * @return {string}
 */
String.prototype.replicate = function(times) {
    let res = "";
    for(let i =0;i<times;i++){
        res += this;
    }
    return res;
}