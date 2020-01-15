package com.suansuan.container

/**
 * 1、列表的定义
 * 2、列表的操作
 *      2.1、增加
 *      2.2、删除
 *      2.3、查找
 *      2.4、排序
 */

/**
 * 列表的定义
 */
def javaList = new ArrayList() //java当中的定义方式

def list = [1, 2, 3, 4]
println list.class
println list.size()
/*
class java.util.ArrayList
4
 */

def array = [1, 2, 3, 4, 5] as int[]    //定义一个数组
int[] array2 = [1, 2, 3, 4, 5]
println array.class
println array2.class
/*
class [I
class [I
 */

/**
 * 数组的基本操作
 *
 * 列表排序
 */
def sortList = [4, 2, 5, 63, -1, -3]  // Java当中的排序
Comparator mc = { int a, int b ->
    a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1
}
Collections.sort(sortList, mc)
println sortList

sortList.sort { a, b ->                  // Groovy 当中的排序
    a == b ? 0 : Math.abs(a) > Math.abs(b) ? -1 : 1
}
println sortList

def sortStringList = ['abc', 'bcde', 'hello', 'android', 'JavaScript', 'b', 'ds']  //按照字符串的长度进行排序
//sortStringList.sort { a, b ->
//    a.size() == b.size() ? 0 : a.size() > b.size() ? 1 : -1
//}
sortStringList.sort { return it.size() }
println sortStringList

/**
 * 数组的基本操作
 *
 * 列表查找
 */
def findList = [4, 2, 5, 63, -1, -3]      // Java当中的排序
println findList.find { return it > 4 }      // 返回第一个大于四的元素
println findList.findAll { return it > 4 }    // 返回所有大于四的元素
println findList.any { return it > 4 }         // 只要列表有大于四的元素 返回true
println findList.every { return it > -4 }       // 只要列表全部元素大于四 返回true

println findList.min { return Math.abs(it) }      //返回绝对值最小的值
println findList.max { return Math.abs(it) }      //返回绝对值最大的值
println findList.count { return it % 2 == 0 }      //返回满足条件的个数










