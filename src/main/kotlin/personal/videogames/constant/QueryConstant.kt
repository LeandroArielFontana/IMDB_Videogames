package personal.videogames.constant

class QueryConstant {
    companion object {
        const val FIND_BY_NAME: String = "SELECT v FROM videogame v WHERE v.name = :name"
    }
}
