type F = () => Promise<any>;

function promisePool(functions: F[], n: number): Promise<any> {
    return new Promise((resolve) => {
        let ind = 0;
        let progress = 0;

        const helper = () => {
            if (ind == functions.length) {
                if (progress == 0)
                    resolve(0);
                return;
            }

            while (progress < n && ind < functions.length) {
                const promise = functions[ind]();
                ind++;
                progress++;

                promise.then(() => {
                    progress--;
                    helper();
                });
            }
        }

        helper();
    })
};

/**
 * const sleep = (t) => new Promise(res => setTimeout(res, t));
 * promisePool([() => sleep(500), () => sleep(400)], 1)
 *   .then(console.log) // After 900ms
 */