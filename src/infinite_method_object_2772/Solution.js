/**
 * @return {Object}
 */
var createInfiniteObject = function() {
    return new Proxy({},{
        get: (_, property) =>{
            return  () => property
        }
    })
};

/**
 * const obj = createInfiniteObject();
 * obj['abc123'](); // "abc123"
 */