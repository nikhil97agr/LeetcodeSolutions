interface Array<T> {
    snail(rowsCount: number, colsCount: number): number[][];
}


Array.prototype.snail = function(row: number, col: number): number[][] {
    const length = this.length;
    if(length !== row*col) return [];
    const result : number[][] = new Array<number[]>(row).fill(null).map(() => new Array<number>(col).fill(0));

    let dir = 1;
    
    let c = 0;
    let ind = 0;
    while(c < col){
        let r = 0;

        if(dir === -1){
            r = row - 1;
        }

        let cnt = 0;
        while(cnt < row){
            result[r][c] = this[ind];
            console.log(r,c,ind);
            ind++;
            r += dir;
            cnt++;
        }


        dir = -dir;
        c++;

    }

    return result;
}

/**
 * const arr = [1,2,3,4];
 * arr.snail(1,4); // [[1,2,3,4]]
 */