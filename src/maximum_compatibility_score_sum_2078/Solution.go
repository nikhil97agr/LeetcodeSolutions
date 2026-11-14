func maxCompatibilitySum(students [][]int, mentors [][]int) int {
    n := len(students)
    m := len(students[0])

    dp := make([][]int, n)
    for i := 0; i<n;i++{
        dp[i] = make([]int, 1<<n)
        for j := 0;  j < (1<<n); j++{
            dp[i][j]= -1
        }
    }

    ans :=  solve(students, mentors, dp, 0, 0, n, m);

    return ans
}

func solve(students , mentors, dp [][]int, state, ind, n, m int) int{
    if ind ==n {
        return 0
    }

    if dp[ind][state] != -1{
        return dp[ind][state]
    }
    ans := 0
    for i := 0 ;i<n;i++{
        if((state & (1<<i)) ==0){
            temp := score(students[i], mentors[ind], m) + solve(students, mentors, dp, state | (1<<i), ind + 1, n, m)
            if temp > ans{
                ans = temp
            }
        }
    }

    dp[ind][state] = ans

    return ans
}

func score (student, mentor []int, m int) int{
    score := 0

    for i := 0 ;i<m; i++{
        if student[i] == mentor[i]{
            score++;
        }
    }

    return score
}