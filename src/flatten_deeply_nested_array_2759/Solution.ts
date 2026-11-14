type MultiDimensionalArray = (number | MultiDimensionalArray)[];

var flat = function (arr:  MultiDimensionalArray, n: number):  MultiDimensionalArray {
    const ans = []

    for( var x of arr){
        if(Array.isArray(x) && n > 0) ans.push(...flat(x, n-1));
        else ans.push(x);
    }

    return ans;
};