import spark.ResponseTransformer
import spark.kotlin.*
import com.google.gson.Gson;

class JsonResponseTransformer: ResponseTransformer {
    private val gson = Gson()
    override fun render(model: Any?) = gson.toJson(model)
}

data class Person(val name: String)

fun Any.toJson(): String {
    val gson = Gson()
    return gson.toJson(this)
}

fun main(args: Array<String>) {
    val http: Http = ignite()
    http.get("/health") {
        Person("john").toJson()
    }
    http.get("/hello") {
        "Hello Spark Kotlin!"
    }
}