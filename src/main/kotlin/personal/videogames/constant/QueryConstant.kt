package personal.videogames.constant

class QueryConstant {
    companion object {
        const val FIND_BY_NAME = "SELECT v.* FROM videogame v WHERE v.Name LIKE %:name%"
        const val FIND_BY_ID = "SELECT v.* FROM videogame v WHERE v.Id = :id"
        const val FIND_BY_YEAR = "SELECT v.* FROM videogame v WHERE v.Year = :year"
        const val FIND_BY_CERTIFICATE = "SELECT v.* FROM videogame v WHERE v.Certificate LIKE %:certificate%"
    }
}
