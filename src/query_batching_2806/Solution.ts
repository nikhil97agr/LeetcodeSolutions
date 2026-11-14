type QueryMultiple = (keys: string[]) => Promise<string[]>

class QueryBatcher {
    private current : Promise<string[]>;
    private coolDown : Promise<void> = Promise.resolve();
    private que: string[] = [];
    
    constructor(private queryMultiple: QueryMultiple,private t: number) {
        
    }
    
    async getValue(key: string): Promise<string> {
        const index = this.que.length;
        this.que.push(key);

        if(index == 0){
            this.current = this.coolDown.then(()=>{
                const task = this.queryMultiple(this.que);
                this.que = []
                this.coolDown = new Promise(resolve => setTimeout(resolve, this.t));
                return task;
            })
        }

        return this.current.then(a => a[index]);
    }
};

/**
 * async function queryMultiple(keys) { 
 *   return keys.map(key => key + '!');
 * }
 *
 * const batcher = new QueryBatcher(queryMultiple, 100);
 * batcher.getValue('a').then(console.log); // resolves "a!" at t=0ms 
 * batcher.getValue('b').then(console.log); // resolves "b!" at t=100ms 
 * batcher.getValue('c').then(console.log); // resolves "c!" at t=100ms 
 */