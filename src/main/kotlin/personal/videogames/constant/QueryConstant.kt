package personal.videogames.constant

class QueryConstant {
    companion object {
        const val FIND_BY_NAME: String = "SELECT v.* FROM videogames v WHERE v.name = :name"
    }
}
