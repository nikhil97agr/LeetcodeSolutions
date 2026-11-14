/** 
 * @param {number} target
 * @return {number}
 */
Array.prototype.upperBound = function(target) {
    let start= 0;
    let end = this.length - 1;
    let ind = -1;

    while(start <= end){
        const mid = Math.floor((start+end)/2);

        if(this[mid] > target){
            end= mid-1;
        }else if(this[mid] < target){
            start = mid + 1;
        }else{
            start = mid + 1;
            ind = mid;
        }
    }

    return ind;
};


// [3,4,5].upperBound(5); // 2
// [1,4,5].upperBound(2); // -1
// [3,4,6,6,6,6,7].upperBound(6) // 5