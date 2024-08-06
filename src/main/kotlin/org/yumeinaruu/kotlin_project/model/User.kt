package org.yumeinaruu.kotlin_project.model

import jakarta.persistence.*
import org.springframework.stereotype.Component
import java.sql.Timestamp

@Entity(name="users")
@Component
class User {
    @Id
    @SequenceGenerator(name = "linksIdSeqGen", sequenceName = "links_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "linksIdSeqGen")
    var id: Long? = null

    @Column(name = "username")
    var username: String? = null

    @Column(name = "description")
    var description: String? = null

    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    var created: Timestamp? = null

    @Column(name = "changed")
    @Temporal(TemporalType.TIMESTAMP)
    var changed: Timestamp? = null

    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    var links: MutableSet<Link> = mutableSetOf()
}