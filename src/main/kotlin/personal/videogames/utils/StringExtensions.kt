package personal.videogames.utils // ktlint-disable filename

import java.util.*

private val CAMEL_REGEX = "(?<=[a-zA-Z])[A-Z]".toRegex()

fun String.camelToSnakeCase(): String {
    return replace(CAMEL_REGEX) {
        "_${it.value}"
    }.lowercase(Locale.getDefault())
}
