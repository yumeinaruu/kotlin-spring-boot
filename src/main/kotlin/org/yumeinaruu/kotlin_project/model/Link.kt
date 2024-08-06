package org.yumeinaruu.kotlin_project.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.springframework.stereotype.Component

@Entity(name = "links")
@Component
class Link {
    @Id
    @SequenceGenerator(name = "linksIdSeqGen", sequenceName = "links_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "linksIdSeqGen")
    var id: Long? = null

    @Column(name = "service")
    var service: String? = null

    @Column(name = "link")
    var link: String? = null

    @JsonIgnore
    @JoinColumn(name = "user_id")
    @ManyToOne
    var userId: User? = null
}