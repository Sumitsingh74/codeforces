//package kot
//data class PQElement<T>(val data: T, val priority: Int)
//class PriorityQueue<T> {
//    private val elements: MutableList<PQElement<T>> = mutableListOf()
//
//    // 3. Implement the `enqueue` method
//    fun enqueue(item: T, priority: Int) {
//        val pqElement = PQElement(item, priority)
//        elements.add(pqElement)
//        elements.sortByDescending { it.priority }
//    }
//
//    // 4. Implement the `dequeue` method
//    fun dequeue(): T? {
//        if (isEmpty()) {
//            return null
//        }
//        return elements.removeAt(0).data
//    }
//
//    // 5. Implement the `peek` method
//    fun peek(): T? {
//        return elements.firstOrNull()?.data
//    }
//
//    // 6. Implement the `isEmpty` method
//    fun isEmpty() = elements.isEmpty()
//}
//
//class Kotlin {
//    fun main(args: Array<String>) {
//        var Te = 1
//
//        superOuter@ while (Te-- > 0) {
//            val n = readLine()!!.toLong()
//            val k = readLine()!!.toInt()
//            val pq = PriorityQueue<Long>()
//            for (i in 0 until 63) {
//                if ((n and (1L shl i)) != 0L) pq.enqueue(1L shl i)
//            }
//            if (k > n || k < pq.size) {
//                println("NO")
//                continue@superOuter
//            }
//            var kCopy = k - pq.size
//            while (kCopy-- > 0) {
//                if (pq.isEmpty() || pq.peek() == 1L) {
//                    println("NO")
//                    continue@superOuter
//                }
//                val l = pq.poll()
//                pq.add(l / 2)
//                pq.add(l / 2)
//            }
//            println("YES")
//            while (pq.isNotEmpty()) {
//                print("${pq.poll()} ")
//            }
//            println()
//        }
//    }
//
//
//}