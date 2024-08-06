package org.yumeinaruu.kotlin_project.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
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
}