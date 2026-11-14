/**
 * @return {Generator<number>}
 */

var fibGenerator = function*() {
     var first = 0;
 var second = 1;
    while(true){
        yield first;
        temp = first;
        first = second;
        second = first + temp;
    }

};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */