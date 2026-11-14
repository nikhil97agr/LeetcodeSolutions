/**
 * @param {number[]} derived
 * @return {boolean}
 */
var doesValidArrayExist = function(derived) {
    return derived.reduce((value, prev) => prev^value , 0) == 0;
};