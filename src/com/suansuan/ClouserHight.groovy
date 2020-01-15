package com.suansuan

/**
 * 闭包高级策略
 *
 * 探究 ： this, owner, delegate 的区别
 *
 */
def scriptClouser = {
    println "scriptClouser this : ${this}"          // 代表闭包定义处的类
    println "scriptClouser owner: ${owner}"         // 代表闭包定义处的类或者对象
    println "scriptClouser delegate: ${delegate}"   // 代表任意对象，含有一个默认值
}
scriptClouser.call()
/*  输出， 没什么区别
    scriptClouser this : com.suansuan.ClouserHight@66d3eec0
    scriptClouser owner: com.suansuan.ClouserHight@66d3eec0
    scriptClouser delegate: com.suansuan.ClouserHight@66d3eec0 */

/**
 * 相当与Java当中定义一个内部类
 *
 * 场景2、static相关内部类当中的指向问题
 */
class Person {

    /**
     * 成员属性闭包
     */
    def static classClouser = {
        println "classClouser this : ${this}"          // 代表闭包定义处的类
        println "classClouser owner: ${owner}"         // 代表闭包定义处的类或者对象
        println "classClouser delegate: ${delegate}"   // 代表任意对象，含有一个默认值
    }

    /**
     * 方法体当中定义闭包
     */
    def static function () {
        def functionClouser = {
            println "functionClouser this : ${this}"          // 代表闭包定义处的类
            println "functionClouser owner: ${owner}"         // 代表闭包定义处的类或者对象
            println "functionClouser delegate: ${delegate}"   // 代表任意对象，含有一个默认值
        }
        functionClouser.call()
    }
}
Person.classClouser.call()      // 调用Person静态属性的闭包
/*  输出：(因为是在static当中定义的，所以相关的只是指向了.class字节码，而没有指向对象(因为没有对象标示))
    classClouser this : class com.suansuan.Person
    classClouser owner: class com.suansuan.Person
    classClouser delegate: class com.suansuan.Person*/

Person.function()               // 调用Person静态方法的闭包
/*  输出： (因为是在static当中定义的，所以相关的只是指向了.class字节码，而没有指向对象(因为没有对象标示))
    functionClouser this : class com.suansuan.Person
    functionClouser owner: class com.suansuan.Person
    functionClouser delegate: class com.suansuan.Person*/

/**
 * 相当与Java当中定义一个内部类
 *
 * 场景3、非static相关内部类当中的指向问题
 */
class People {

    /**
     * 成员属性闭包
     */
    def classClouser = {
        println "classClouser this : ${this}"          // 代表闭包定义处的类
        println "classClouser owner: ${owner}"         // 代表闭包定义处的类或者对象
        println "classClouser delegate: ${delegate}"   // 代表任意对象，含有一个默认值
    }

    /**
     * 方法体当中定义闭包
     */
    def function () {
        def functionClouser = {
            println "functionClouser this : ${this}"          // 代表闭包定义处的类
            println "functionClouser owner: ${owner}"         // 代表闭包定义处的类或者对象
            println "functionClouser delegate: ${delegate}"   // 代表任意对象，含有一个默认值
        }
        functionClouser.call()
    }
}
People people = new People()
people.classClouser.call()          // 调用People对象属性的闭包
/*  输出：
    classClouser this : com.suansuan.People@2dc54ad4
    classClouser owner: com.suansuan.People@2dc54ad4
    classClouser delegate: com.suansuan.People@2dc54ad4*/

people.function()                   // 调用People对象方法的闭包
/*  输出：
    functionClouser this : com.suansuan.People@2dc54ad4
    functionClouser owner: com.suansuan.People@2dc54ad4
    functionClouser delegate: com.suansuan.People@2dc54ad4*/

/**
 * 场景4、闭包当中定义闭包。
 *
 * 注意 {} 和 + 的区别
 */
def outClouser = {
    def innerClouser = {
        println "innerClouser this : ${this}"          // 代表闭包定义处的类
        println "innerClouser owner: " + owner         // 代表闭包定义处的类或者对象
        println "innerClouser delegate: " +  delegate  // 代表任意对象，含有一个默认值
    }
    innerClouser.call()
}
outClouser.call()
/*  输出
    innerClouser this : com.suansuan.ClouserHight@e15b7e8
    innerClouser owner: com.suansuan.ClouserHight$_run_closure2@121314f7
    innerClouser delegate: com.suansuan.ClouserHight$_run_closure2@121314f7*/

/**
 * 场景5、默认修改delegate的情况
 */
def outClouser1 = {
    def innerClouser1 = {
        println "innerClouser this : ${this}"          // 代表闭包定义处的类
        println "innerClouser owner: " + owner         // 代表闭包定义处的类或者对象
        println "innerClouser delegate: " +  delegate  // 代表任意对象，含有一个默认值
    }
    innerClouser1.delegate = people
    innerClouser1.call()
}
outClouser1.call()
/*  输出： 注意 this 和 owner 不可以修改
    innerClouser this : com.suansuan.ClouserHight@6392827e
    innerClouser owner: com.suansuan.ClouserHight$_run_closure3@70e9c95d
    innerClouser delegate: com.suansuan.People@4b0d79fc*/

/**
 * 闭包的委托策略
 */
class Student {
    String name
    def pretty = {
        "my name is ${name}"
    }

    String toString(){
        return pretty.call()
    }
}

class Teacher {
    String name
}

def stu = new Student(name: "liusuansuan")
def tea = new Teacher(name: "liupengcheng")
stu.pretty.delegate = tea
stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST
println stu.toString()


























