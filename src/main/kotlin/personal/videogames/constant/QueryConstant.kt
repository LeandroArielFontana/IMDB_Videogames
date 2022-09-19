package personal.videogames.constant

class QueryConstant {
    companion object {
        const val FIND_BY_NAME = "SELECT v.* FROM videogames v WHERE v.name LIKE %:name%"
        const val FIND_BY_ID = "SELECT v.* FROM videogames v WHERE v.id = :id"
    }
}
