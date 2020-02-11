package com.suansuan.storage.format.json

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

/**
 * 实体对象转换成为JSON
 * JsonOutput
 */

def list = [new Person(name: 'suansuan', age: 25),
            new Person(name: 'tiantian', age: 24)]
def json = JsonOutput.toJson(list)
println JsonOutput.prettyPrint(json)

/**
 * 将 JSON 转换为实体对象类
 * JsonSlurper
 */
def slurper = new JsonSlurper()
def person = slurper.parse(json.toCharArray())
println person

/**
 * 以下位测试类
 */
class Person {
    String name
    int age
}

/**
 * Demo 去网络请求数据
 * 不用去按照之前的建立一个Bean对象进行一一对应， 系统直接会返回一个与请求JSON相对于的对象
 * http://localhost:3200/getSongListCategories 该地址为本地服务器地址
 */
static def getNetworkData (String url) {
    // 请求数据
    def connection = new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.connect()
    def response = connection.content.text
    // 解析Json
    def slurper = new JsonSlurper()
    return slurper.parseText(response)
}

def response = getNetworkData ("http://localhost:3200/getSongListCategories")
println response