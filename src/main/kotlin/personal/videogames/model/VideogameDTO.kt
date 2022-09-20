package personal.videogames.model

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.* // ktlint-disable no-wildcard-imports

@Entity
@EntityListeners(AuditingEntityListener::class)
class Videogame(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int,
    @Column(name = "name")
    val name: String,
    @Column(name = "url")
    val url: String,
    @Column(name = "year")
    val year: Int,
    @Column(name = "certificate")
    val certificate: String,
    @Column(name = "rating")
    val rating: Double,
    @Column(name = "votes")
    val votes: String,
    @Column(name = "plot")
    val plot: String
)
