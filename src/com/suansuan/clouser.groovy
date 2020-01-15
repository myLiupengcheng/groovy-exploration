package com.suansuan


// 定义
def clouser = {
    println "hello groovy"
}

//调用
clouser.call()
clouser()   //类似一个方法


//参数，类似一个方法，方法可以通过参数，闭包也可以

def clouserParam = { String name ->
    println "${name} hello groovy"
}

//调用
clouserParam.call("张三")
clouserParam("张三")   //类似一个方法

//多参数
def clouserDoubleParam = { String name, int age ->
    println "${age} 的 ${name} 说 ： hello groovy"
}

//调用
clouserDoubleParam.call("张三", 24)
clouserDoubleParam("张三", 24)   //类似一个方法

//隐式参数 , 注意在不传递隐士参数的情况下，it表示什么  null
def clouserNullParams = {
    println "hello ${it}"
}
clouserNullParams.call()
clouserNullParams("Groovy")

// 闭包的返回值，闭包一定含有返回值

def clouserReturnParams = {
    return "hello Groovy"
}
def clouserNullReturnParams = {
    println "hello Groovy"
}
println clouserReturnParams()
println clouserNullReturnParams()