package com.suansuan

/**
 * 闭包和普通类型的使用
 * 如何不通过循环求出10以内的阶乘
 */
def fab(int startNumber, int endNumber) {
    int result = 1
//    1.upto(endNumber, { num ->
//        result *= num
//    })
    startNumber.upto(endNumber, { num ->
        result *= num
    })
    return result
}

def fab2(int number){
    int result = 1
    number.downto(1) { numb ->
        result *= numb
    }
    return result
}


int resultNumberUpTo = fab(1,5)
int resultNumberDownTo = fab2(5)

println resultNumberUpTo
println resultNumberDownTo

/**
 * 如何不通过循环求出累加
 * @param number
 */
def cal(int number){
    int result = 0
    number.times { numb ->
        result += numb
    }
    return result
}

int resultNumberCal = cal(101)
println resultNumberCal