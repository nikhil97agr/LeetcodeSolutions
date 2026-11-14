func getSum(a int, b int) int {
    mask := 0xFFFFFFFF
    for b != 0 {
        carry := (a & b & mask) << 1
        a = (a ^ b) & mask
        b = carry
    }
    if a > 0x7FFFFFFF {
        a = ^(a ^ mask)
    }
    return a
}