package com.suansuan

def x = 1.23
def result
switch (x) {
    case 'foo':
        result = "found foo"        //字符串
        break

    case 'bar':
        result = "found bar"        //字符串
        break

    case [4,5,6,7, "inlist"] :      //列表
        result = "found bar"
        break

    case 1..30:
        result = "range"            //范围
        break

    case Integer:
        result = "found integer"    //类型
        break

    case BigDecimal:
        result = "found BigDecimal" //类型
        break

    default:result = 'default'
}

//println result


//def sum = 0
//for (i in 0..10){
//    sum +=i
//}
//println sum

//List list = new ArrayList()
//list.add(1)
//list.add(2)
//list.add(3)
//list.add(4)
//list.add(5)
//list.add(6)
//list.add(7)
//list.add(8)
//list.add(9)
//list.add(10)
//for (i in [1,2,3,4,5,6,7,8,9,10]){
//    sum +=i
//}
//println sum

// map是没有顺序的哦
Map map = new HashMap()
map.put("name", "张三")
map.put("age", "19")
map.put("password", "123456789")
map.put("description", "三好学生")
map.put("sex", "男")

// 也可以这么写
for (entry in ["name": "张三", "age": "19", "password": "123456789", "description": "三好学生", "sex": "男"]) {
    println "${entry.key} : ${entry.value}"
}




