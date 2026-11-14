type JSONValue =
  | boolean
  | JSONValue[]
  | null
  | number
  | string
  | { [key: string]: JSONValue };
type Obj = Array<JSONValue> | Record<string, JSONValue>;

function compactObject(obj: Obj): Obj {
  if (Array.isArray(obj)) {
    return obj
      .filter((val) => Boolean(val))
      .map((val) => {
        if (
          typeof val === 'boolean' ||
          typeof val === 'number' ||
          typeof val === 'string'
        ) {
          return val;
        }

        return compactObject(val as Obj);
      });
  }

  return Object.fromEntries(
    Object.entries(obj)
      .filter(([_, value]) => Boolean(value))
      .map(([key, value]) => {
        if (
          typeof value === 'boolean' ||
          typeof value === 'number' ||
          typeof value === 'string'
        ) {
          return [key, value];
        }
        return [key, compactObject(value as Obj)];
      })
  );
}
